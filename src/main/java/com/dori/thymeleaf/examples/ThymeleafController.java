package com.dori.thymeleaf.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Controller
@RequestMapping("examples/")
public class ThymeleafController {
	
    @GetMapping("text")
    public String text(Model model) {
        model.addAttribute("data", "Hello Spring");
        return "examples/text";
    }
    
    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring</b>");
        return "examples/text-unescaped";
    }
    
    @GetMapping("/variable")
    public String variable(Model model) {
    	
    	String[] userArrays = {"홍길동" , "장동건" , "원빈"};
    	
    	var userA = new User("홍길동", 20);
        var userB = new User("장동건", 25);
        var userC = new User("원빈", 30);

        List<User> list = new ArrayList<>(Arrays.asList(userA, userB, userC));

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);
        map.put("userC", userC);

        model.addAttribute("userArrays", userArrays);
        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);
        
        return "examples/variable";
    }
    
    
    
    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

}
