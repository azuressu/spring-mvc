package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    @DisplayName("Object To JSON : get Method 필요")
    // Star 클래스의 Getter 메소드를 자동으로 사용하고 있음
    // 직렬화: Object To Json 하는 과정인데, Getter를 자동으로 사용하기 때문에 지우면 안됨(ObjectMapper)
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);

        ObjectMapper objectMapper = new ObjectMapper();      //Jackson 라이브러리의 ObjectMapper
        String json = objectMapper.writeValueAsString(star); // 변화하고싶은 오브젝트 객체를 넣어주면 됨

        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON TO Object : 기본 생성자 & (get OR set) Method 필요")
    // 역직렬화
    // 기본 생성자와 getter 혹은 setter가 없으면 오류가 남 . 자동으로 사용하기 때문에 지우면 안됨
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String
        // 클라이언트에서 요청으롭 낼 때, 브러우저에 넘어오는 데이터의 키값과 매칭이 되는 클래스의 필드 명이
        // 정확하게 동일하게, 일치시켜야 함

        ObjectMapper objectMapper = new ObjectMapper();   // Jackson 라이브러리의 ObjectMapper

        Star star = objectMapper.readValue(json, Star.class); // json을 어떤 객체로 만들것이냐 ?
        System.out.println("star.getName() = " + star.getName());
        System.out.println("star.getAge() = " + star.getAge());
    }
}
