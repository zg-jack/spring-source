package com.zhuguang.jack.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class SpringApplication {

    public static void main(String[] args) {
        run(SpringApplication.class,args);
    }

    public static void run(Object source, String... args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(9090);

            String basePath = System.getProperty("user.dir") + File.separator + "spring-source" + File.separator;
            tomcat.getHost().setAppBase(basePath);

            //改变文件读取路径，从resources目录下去取文件
            StandardContext ctx = (StandardContext) tomcat.addWebapp("/", basePath + "src" + File.separator + "main" + File.separator + "resources");
            // 禁止重新载入
            ctx.setReloadable(false);
            // class文件读取地址
            File additionWebInfClasses = new File("spring-source/target/classes");
            // 创建WebRoot
            WebResourceRoot resources = new StandardRoot(ctx);
            // tomcat内部读取Class执行
            resources.addPreResources(
                    new DirResourceSet(resources, "/spring-source/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
            tomcat.start();
            // 异步等待请求执行
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
