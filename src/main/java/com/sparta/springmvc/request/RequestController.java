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
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) { // @RequestParam도 생략 가능
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // Request Sample
    // POST http://localhost:8080/hello/request/form/model
    // Header
    // Content type: application/x-www-form-urlencoded
    // Body
    // name=Robbie&age=95
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        // @ModelAttrubute annotation을 사용하면 body 부분에 들어온 query string 방식의 데이터를
        // 객체에 mapping 해서 가지고 올 수 있음
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
        // 이름 자체를 클라이언트에서 보내주는 이름과 동일하게 맞춰주어야 함. (name이라고 했으면 여기서도 name으로 받기)
    }


    // Request Sample
    // GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    // @ModelAttribute를 사용해서 데이터를 받아올 때는
    // Setter 혹은 오버로딩된 생성자가 꼭 필요함
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) { // @ModelAttribute는 생략이 가능함
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    /* @ModelAttribute와 @RequestParam 둘다 생략이 가능한데, Spring은 이를 어떻게 구분하는가?
    * Spring은 해당 파라미터가 SimpleValueType이면 @RequestParam으로 간주,
    * 아니라면 @ModelAttribute로 간주한다.
    * SimpleValueType - int(원시타입), Integer(Wrapper), Date 등등
    * 우리가 만든 클래스가 오브젝트 일때는 ModelAttribute 생략으로 간주 */

    // Request Sample
    // POST http://localhost:8080/hello/request/form/json
    // Header
    // Content type: application/json
    // Body
    // {"name":"Robbie", "age":95}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) { // RequestBody annotation으로 이거 json 형태로 받아주세요~ 라고 알림
        // 필드를 꼭 맞춰주어야 함
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }



}
