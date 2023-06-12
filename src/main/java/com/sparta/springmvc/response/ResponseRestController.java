package com.sparta.springmvc.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller + Rest Body (ResponseBody를 적지 않아도 됨)
@RequestMapping("/response/rest")
public class ResponseRestController {
    // Response Header
    // Content-Type: text/html
    // Response Body
    // {"name":"Robbie", "age":95}
    @GetMapping("/json/string")
    public String helloStringJson() {
        return "{\"name\":\"Robbie\", \"age\":95}";
    }

    // Response Header
    // Content-Type: application/json
    // Response Body
    // {"name":"Robbie", "age":95}
    @GetMapping("/json/class")
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }

}
// 예를 들어 클래스 내에서 우리가 View를 반환해야 하는 경우가 있다
// 최초 요청 때는 html을 반환해야 하기 때문에 Controller로 달려있을 것임
// 만약에 그 안에서 데이터를 반환해야 한다면 ResponseBody를 달 것

// 반대로 어떤 클래스 같은 경우에는 html 반환이 아닌 json 형태의 데이터를 반환할 것
// 그런 경우, RestController를 달아서