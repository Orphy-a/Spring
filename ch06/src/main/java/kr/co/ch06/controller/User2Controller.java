package kr.co.ch06.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class User2Controller {

    @GetMapping("/user2/list")
    public String list(){

        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){


        return "/user2/register";
    }

}
