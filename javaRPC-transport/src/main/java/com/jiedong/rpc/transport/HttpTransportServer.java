package com.jiedong.rpc.transport;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 19411
 * @date 2020/06/24 22:33
 **/
@Slf4j
public class HttpTransportServer implements TransportServer{
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler = handler;
        //启动服务端，指定监听的接口
        this.server = new Server(port);
        //servlet接收请求
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);

        //处理网络请求的抽象
        ServletHolder holder = new ServletHolder(new RequestServlet());
        //pathSpec表示处理路径
        ctx.addServlet(holder,"/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    class RequestServlet extends HttpServlet{
        /**
         * 处理post请求，并返回
         * @param req 请求
         * @param resp 返回数据
         * @throws ServletException
         * @throws IOException
         */
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");
            InputStream in  = req.getInputStream();
            OutputStream out = resp.getOutputStream();

            if (handler!=null){
                handler.onRequest(in,out);
            }
            out.flush();
        }
    }
}
