package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {

    // [key]해당경로     [value]컨트롤러   => 해당경로를 입력했을 때 해당 컨트롤러를 실행할 수 있도록 key value 를 관리
    private Map<String, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put("/", new HomeController());
    }

    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath); // 해당 url 이 들어오면 해당 컨트롤러를 반환
    }
}
