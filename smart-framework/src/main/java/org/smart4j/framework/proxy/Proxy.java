package org.smart4j.framework.proxy;

/**
 * 代理接口
 */
public interface Proxy {
    /**
     * 执行链式代理（链式代理：多个代理通过一个链子串起来，一个个的去执行）
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
