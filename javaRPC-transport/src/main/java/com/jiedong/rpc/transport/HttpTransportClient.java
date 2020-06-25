package com.jiedong.rpc.transport;

import com.jiedong.rpc.Peer;

import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 19411
 * @date 2020/06/24 22:19
 **/
public class HttpTransportClient implements TransportClient{
    /**
     * http短连接需要一个url连接
     */
    private String url;
    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost()+":"
                +peer.getPort();

    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");
            httpConn.connect();
            IOUtils.copy(data,httpConn.getOutputStream());

            int resultCode = httpConn.getResponseCode();
            //正常输出时判断http状态码为200，否则获取错误的输出
            if (resultCode==HttpURLConnection.HTTP_OK){
                return httpConn.getInputStream();
            }else {
                return httpConn.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
