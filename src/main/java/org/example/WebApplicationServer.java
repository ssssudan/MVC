package org.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 1. 톰켓으로 서버를 연다.
 * 2. DispatcherServlet 을 통해 모든 요청을 받아온다.
 * 3. RequestMappingHandlerMapping 을 통해 경로에 따라 컨트롤러를 실행시킨다.
 */
public class WebApplicationServer {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws LifecycleException {
        String webappDirLocation = "webapps/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081); // 포트 설정

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath()); // contextPath 를 입력 -> 해당 경로(webapps/WEB-INF/classes 를 통해 실행
        logger.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}