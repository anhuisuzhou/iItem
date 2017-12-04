package com;


import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 *
 * Created by trh on 2017/12/4.
 */
public class JettyStarter {

public static void main(String[] args) throws Exception {
        // 服务器的监听端口
        Server server = new Server(80);
        // 关联一个已经存在的上下文
        WebAppContext context = new WebAppContext();
        // 设置描述符位置
        context.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
        // 设置Web内容上下文路径
        context.setResourceBase("./src/main/webapp");
        // 设置上下文路径
        context.setContextPath("/item");
        context.setParentLoaderPriority(true);
        server.setHandler(context);


        try {
        server.start();
        // server.join();
        } catch (Exception e) {
        e.printStackTrace();
        }
        System.out.println("server is  start");


        }


}
