package com.jiedong.rpc.transport;

/**
 * 1、启动、监听端口
 * 2、接受请求
 * 3、关闭监听
 *
 * @author 19411
 * @date 2020/06/24 22:12
 **/
public interface TransportServer {
    /**
     * 把这个handler传递给server
     * @param port 监听的接口
     * @param handler 处理模块
     */
    void init(int port,RequestHandler handler);

    /**
     * 启动
     */
    void start();


    /**
     * 停止
     */
    void stop();

}
