package com.jiedong.rpc.server;

import com.jiedong.rpc.Request;
import com.jiedong.rpc.Response;

import com.jiedong.rpc.codec.Decoder;
import com.jiedong.rpc.codec.Encoder;
import com.jiedong.rpc.common.utils.ReflectionUtils;
import com.jiedong.rpc.transport.RequestHandler;
import com.jiedong.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author 19411
 * @date 2020/06/25 10:06
 **/
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;


    public RpcServer(RpcServerConfig config) {
        this.config = config;
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(),this.handler);
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass,bean);
    }

    public void start(){
        this.net.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive,receive.available());
                Request request =decoder.decode(inBytes,Request.class);
                log.info("get request:{}",request);
                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis,request);
                resp.setData(ret);
            } catch (IOException e) {
                log.warn(e.getMessage(),e);
                resp.setCode(1);
                resp.setMessage("RpcServe got error: "+
                        e.getClass().getName()+" : "+
                        e.getMessage());
            }finally {
                byte[] outBytes = encoder.encoder(resp);
                try {
                    toResp.write(outBytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                }
            }
        }
    };
}
