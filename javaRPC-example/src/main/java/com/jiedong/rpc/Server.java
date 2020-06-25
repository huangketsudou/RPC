package com.jiedong.rpc;

import com.jiedong.rpc.server.RpcServer;
import com.jiedong.rpc.server.RpcServerConfig;

/**
 * @author 19411
 * @date 2020/06/25 11:18
 **/
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}
