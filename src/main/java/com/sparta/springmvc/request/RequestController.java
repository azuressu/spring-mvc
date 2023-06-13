package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // Request Sample
    // Get http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    // @PathVariable 의 변수명과 일치하게 중괄호 안에 적어주어야 함
    @ResponseBody
    public String helloRequstPath(@PathVariable String name, @PathVariable int age){
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // Request Sample
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam(required = false) String name, int age) { // @RequestParam을 붙이지 않아도 동작됨
        // 만약 데이터를 주지 않는다면?
        // null로 초기화가 됨.
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // Request Sample
    // POST http://localhost:8080/hello/request/form/param
    // Header
    // Content type: application/x-www-form-urlencoded
    // Body (post는 바디부분을 갖고있음)
    // name=Robbie&age=95
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


}
