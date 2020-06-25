package com.jiedong.rpc.transport;

import com.jiedong.rpc.Peer;

import java.io.InputStream;

/**
 * 1、创建连接
 * 2、发送数据，并且等待响应
 * 3、关闭连接
 *
 * @author 19411
 * @date 2020/06/24 22:08
 **/
public interface TransportClient {
    /**
     * 连接某个端口
     * @param peer
     */
    void connect(Peer peer);

    /**
     * 读取数据
     * @param data 写入数据
     * @return 等待响应
     */
    InputStream write(InputStream data);

    /**、
     * 关闭连接
     */
    void close();
}
