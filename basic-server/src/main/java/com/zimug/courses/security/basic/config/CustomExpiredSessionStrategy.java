package com.zimug.courses.security.basic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;

public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {

//    页面跳转的处理逻辑
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

//    JSON处理对象（前后端分离）
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
//        最后为踢下线后跳转的页面地址
//        redirectStrategy.sendRedirect(sessionInformationExpiredEvent.getRequest(), sessionInformationExpiredEvent.getResponse(), "/invalid");

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",403);
        map.put("msg","您的登录已经超时或者已经在另外一台机器登录，您被迫下线" + sessionInformationExpiredEvent.getSessionInformation().getLastRequest());
//        将map转化为json字符串
        String json = objectMapper.writeValueAsString(map);
        sessionInformationExpiredEvent.getResponse().setContentType("application/json;charset=UTF-8");
        sessionInformationExpiredEvent.getResponse().getWriter().write(json);
    }
}
