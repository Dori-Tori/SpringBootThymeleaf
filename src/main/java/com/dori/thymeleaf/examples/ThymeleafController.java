package com.dori.thymeleaf.examples;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Controller
@RequestMapping("/examples")
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
    
    @GetMapping("/basic-objects")
    public String basicObject(HttpSession httpSession) {
        httpSession.setAttribute("sessionData", "Hello Session");        
        return "examples/basic-objects";
    }
    
    @Component("helloBean")
    static class HelloBean{
        public String hello(String data) {
            return "Hello " + data;
        }
    }
    
    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "examples/date";
    }
    
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "examples/link";
    }
    
    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "examples/literal";
    }
    
    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");

        return "examples/operation";
    }
    
    @GetMapping("/attribute")
    public String attribute(Model model) {
    	model.addAttribute("userA", "test");
        return "examples/attribute";
    }
    
    @GetMapping("/each")
    public String each(Model model) {
    	addUsers(model);
    	return "examples/each";
    }    
    
    private void addUsers(Model model) {
        List<User> users = Arrays.asList(new User("userA", 10),
                new User("userB", 20),
                new User("userC", 30));

        model.addAttribute("users", users);
    }
    
    @GetMapping("/condition")
    public String condition(Model model) {
    	addUsers(model);
    	return "examples/condition";
    }
    
    @GetMapping("/comments")
    public String comments(Model model) {
    	model.addAttribute("data", "Spring!");
    	return "examples/comments";
    }
    
    @GetMapping("/block")
    public String block(Model model) {
    	addUsers(model);
    	return "examples/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
    	return "examples/javascript";
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
