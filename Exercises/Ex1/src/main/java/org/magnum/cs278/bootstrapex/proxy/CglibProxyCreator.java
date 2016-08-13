package org.magnum.cs278.bootstrapex.proxy;

/* 
**
** Copyright 2014, Jules White
**
** 
*/


import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * This implementation of the ProxyCreator interface using the CGLib library to generate
 * dynamic proxies to any Java class. The implementation relies on the Objensis library
 * to create proxies to concreate classes without calling the parent class' constructor.
 * 
 * @author jules
 *
 */
public class CglibProxyCreator implements ProxyCreator, Serializable {

	private static final String NON_CLASHING_ID_METHOD_NAME = "hopeNobodyNamesAMethodWithThisName";
	
	/*
	 * The HandledProxy and HandledProxyInterceptor are used to secretly
	 * stash a reference to a proxy's InvocationHandler inside of it. When
	 * the proxy is generated, it has an extra method included that returns
	 * the InvocationHandler associated with the proxy. The HandledProxyInterceptor
	 * watches for invocations on this method and returns the correct InvocationHandler
	 * when called.
	 * 
	 */
	public interface HandledProxy {
		public InvocationHandler hopeNobodyNamesAMethodWithThisName();
	}

	private class HandledProxyInterceptor implements MethodInterceptor, Serializable {
		private final InvocationHandler invocationHandler_;

		public HandledProxyInterceptor(InvocationHandler hdlr) {
			invocationHandler_ = hdlr;
		}

		public Object intercept(Object object, Method method, Object[] args,
				MethodProxy methodProxy) throws Throwable {
			return invocationHandler_;
		}
	}

	/*
	 * MethodInterceptor implementations, such as CglibProxy,
	 * are invoked when any method is called on the proxy object. The
	 * passed in Method handle and arguments can be introspected using
	 * Java reflection in order to determine the appropriate course of
	 * action. In this case, we simply delegate method calls on the
	 * proxy to the InvocationHandler. 
	 * 
	 *
	 */
	private class CglibProxy implements MethodInterceptor, Serializable {
		private InvocationHandler handler_;

		public CglibProxy(InvocationHandler hdlr) {
			handler_ = hdlr;
		}

		public Object intercept(Object object, Method method, Object[] args,
				MethodProxy methodProxy) throws Throwable {
			return handler_.invoke(object, method, args);
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.magnum.cs278.bootstrapex.ProxyCreator#createProxy(java.lang.ClassLoader, java.lang.Class, java.lang.reflect.InvocationHandler)
	 */
	@Override
	public Object createProxy(ClassLoader cl, Class<?>[] types,
			InvocationHandler hdlr) {
		
		// Enhancers are used to generate new classes at runtime
		// using an interface or class as a template.
		Enhancer enhancer = new Enhancer();
		
		Class<?> sup = getSuperClass(types);
		
		List<Class<?>> inflist = getInterfaces(types);
		inflist.add(HandledProxy.class);
		Class<?>[] infs = inflist.toArray(new Class[0]);
		
		// We tell the Enhancer what we want the super class of the
		// dynamically generated class to be. If no class is specified,
		// java.lang.Object will be the super class.
		if(sup != null){enhancer.setSuperclass(sup);}
		
		// We tell the Enhancer the interfaces that the new class should
		// implement.
		enhancer.setInterfaces(infs);
		
		// We create our MethodInterceptor that is going to be called whenever
		// anyone invokes a method on an instance of our dynamically genereated
		// class.
		CglibProxy intercept = new CglibProxy(hdlr);
		
		// Each dynamically generated class has one or more MethodInterceptors (Callbacks)
		// that can be registered to handle different method calls. In this case, we
		// add two MethodInterceptors. One interceptor deals with calls to our secret
		// method to get the InvocationHandler for a proxy. The second MethodInterceptor
		// delegates all other calls to the InvocationHandler that the caller specified
		// when they created the proxy. For this exercise, the InvocationHandler is always
		// going to be an instance of Mock. 
		enhancer.setCallbackTypes(new Class[] { HandledProxyInterceptor.class,
				intercept.getClass() });
		
		// Since we are injecting multiple MethodInterceptors, we have to tell the
		// generated class which one to use for which method call. 
		enhancer.setCallbackFilter(new CallbackFilter() {

			@Override
			public int accept(Method arg0) {
				return (arg0.getName()
						.equals(NON_CLASHING_ID_METHOD_NAME)) ? 0 : 1;
			}
		});

		// We ask the Enhancer to generate the bytecode for the new class
		// and load it into the JVM as a new Class object.
		final Class<?> proxyClass = enhancer.createClass();
		Enhancer.registerCallbacks(proxyClass, new Callback[] {
				new HandledProxyInterceptor(hdlr), intercept });
		
		Object proxy = null;
		try{
			proxy = proxyClass.newInstance();
		} catch(Exception e){
			throw new RuntimeException(e);
		}

		return proxy;
	}
	
	/*
	 * Helper method to use Java reflection to figure out which
	 * of the many classes passed in is the actual concreate class
	 * that the proxy should inherit from. If the mock is for an
	 * interface, the proxy will inherit from java.lang.Object only.
	 */
	private Class<?> getSuperClass(Class<?>[] types){
		Class<?> sup = null;
		
		for(Class<?> type : types){
			if(!type.isInterface()){
				sup = type;
				break;
			}
		}
		
		return sup;
	}
	
	/*
	 * Helper method to use Java reflection to figure out which
	 * of the many classes passed in are actually interfaces.
	 */
	private List<Class<?>> getInterfaces(Class<?>[] types){
		return Lists.newArrayList(Iterables.filter(Arrays.asList(types), new Predicate<Class<?>>() {
			@Override
			public boolean apply(Class<?> arg0) {
				return arg0.isInterface();
			}
		}));
	}

	/* (non-Javadoc)
	 * @see org.magnum.cs278.bootstrapex.ProxyCreator#getInvocationHandler(java.lang.Object)
	 */
	@Override
	public InvocationHandler getInvocationHandler(Object proxy) {
		return ((HandledProxy) proxy).hopeNobodyNamesAMethodWithThisName();
	}

	/* (non-Javadoc)
	 * @see org.magnum.cs278.bootstrapex.ProxyCreator#supportsNonInterfaceProxies()
	 */
	@Override
	public boolean supportsNonInterfaceProxies() {
		return true;
	}

}