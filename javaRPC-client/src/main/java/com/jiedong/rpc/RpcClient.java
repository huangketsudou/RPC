package com.jiedong.rpc;

import com.jiedong.rpc.codec.Decoder;
import com.jiedong.rpc.codec.Encoder;
import com.jiedong.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @author 19411
 * @date 2020/06/25 10:51
 **/
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass());
    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoke(clazz,encoder,decoder,selector)
        );
    }
}
