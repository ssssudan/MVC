package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {

    // [key]해당경로     [value]컨트롤러   => 해당경로를 입력했을 때 해당 컨트롤러를 실행할 수 있도록 key value 를 관리
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {  // 경로에 따라 컨트롤러 선택
        mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/users/form"), new ForwardController("/user/form"));
    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey); // 해당 url 이 들어오면 해당 컨트롤러를 반환
    }
}
