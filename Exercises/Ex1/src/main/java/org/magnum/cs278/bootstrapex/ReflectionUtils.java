package org.magnum.cs278.bootstrapex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.magnum.cs278.bootstrapex.proxy.CglibProxyCreator;
import org.magnum.cs278.bootstrapex.proxy.ProxyCreator;

/**
 * A utility class that 
 * 
 * @author jules
 *
 */
public class ReflectionUtils implements InvocationHandler {

	private static final ProxyCreator CREATOR = new CglibProxyCreator();

	private Class<?> type_;
	private Object delegate_;
	private Method method_;
	private boolean configured_ = false;
	private Function replacement_;

	public ReflectionUtils(Class<?> type, Object delegate) {
		super();
		this.type_ = type;
		this.delegate_ = delegate;
	}

	@SuppressWarnings("unchecked")
	public static <T> T wrap(Class<T> type, T delegate) {
		ReflectionUtils utils = new ReflectionUtils(type, delegate);
		return (T) CREATOR.createProxy(Thread.currentThread()
				.getContextClassLoader(), new Class[] { type,
				ReflectionUtils.class }, utils);

	}

	public ReflectionUtils replaceMethod(Object o) {
		return this;
	}

	public static ReflectionUtils on(Object o) {
		ReflectionUtils hdlr = (ReflectionUtils) CREATOR
				.getInvocationHandler(o);
		return hdlr;
	}

	public ReflectionUtils with(Function f) {
		replacement_ = f;
		configured_ = true;
		return this;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Object result = null;
		
		try {
			if (configured_) {
				result = doInvocationDelegation(method, args);
			} else if (method.getDeclaringClass().equals(ReflectionUtils.class)) {
				result = doConfigurationDelegation(method, args);
			} else {
				method = method;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	private Object doConfigurationDelegation(Method method, Object[] args)
			throws IllegalAccessException, InvocationTargetException {
		Object result;
		result = method.invoke(this, args);
		return result;
	}

	private Object doInvocationDelegation(Method method, Object[] args)
			throws IllegalAccessException, InvocationTargetException {
		Object result;
		if (!method_.equals(method)) {
			result = method.invoke(delegate_, args);
		} else {
			Object[] argsWithTarget = insertTargetIntoArgs(args);
			result = replacement_.apply(argsWithTarget);
		}
		return result;
	}

	private Object[] insertTargetIntoArgs(Object[] args) {
		Object[] argsWithTarget = new Object[args.length + 1];
		System.arraycopy(args, 0, argsWithTarget, 0, args.length);
		argsWithTarget[0] = delegate_;
		return argsWithTarget;
	}

}
