package org.magnum.cs278.bootstrapex.proxy;

import java.lang.reflect.InvocationHandler;

public interface ProxyCreator {

	/**
	 * This method uses CGLib to dynamically generate a class that either:
	 * 1) implements th
	 */
	public abstract Object createProxy(ClassLoader cl, Class<?>[] types,
			InvocationHandler hdlr);

	/**
	 * This method accesses the secret method that was injected into the
	 * dynamically generated proxy class in order to extract the InvocationHandler
	 * that was passed in when the proxy was created.
	 * 
	 */
	public abstract InvocationHandler getInvocationHandler(Object proxy);

	public abstract boolean supportsNonInterfaceProxies();

}