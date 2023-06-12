package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount = 0;

    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html"; // 해당 이름과 맞는 파일을 찾아서 반환해줌
        // http://localhost:8080/hello.html 이라고 입력해서 파일에 직접 연결함
        // 보통 templates 폴더 내부에서 찾음
    }

    @GetMapping("html/redirect")
    public String htmlStatic() {
        return "redirect:/hello.html";
    }

    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "Hello";
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount); // 이름, 실제 데이터
        return "hello-visit"; // 뷰 이름주기
    }
}
