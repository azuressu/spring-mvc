package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class responseController {
    // Content-Type: text/html
    // Response Body
    // {"name":"Robbie", "age":95} - text 타입
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // Content-Type: application/json
    // Response Body
    // {"name":"Robbie", "age":95} - json 타입
    @GetMapping("/json/class")
    @ResponseBody // 데이터를 반환하는 방법
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }


}
