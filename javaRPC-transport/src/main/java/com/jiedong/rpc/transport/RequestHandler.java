package com.jiedong.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 * @author 19411
 * @date 2020/06/24 22:14
 **/
public interface RequestHandler {
    /**
     * 处理请求
     * @param receive 接收到的数据
     * @param toResp 处理完成的数据
     */
    void onRequest(InputStream receive, OutputStream toResp);
}
