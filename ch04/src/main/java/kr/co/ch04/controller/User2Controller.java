package kr.co.ch04.controller;

import kr.co.ch04.dto.User2DTO;
import kr.co.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class User2Controller {

    @Autowired
    private User2Service service;



    @RequestMapping(value = "/user2/list", method = RequestMethod.GET)
    public String list(Model model) {

        // 서비스 호출
        List<User2DTO> user2List = service.list();

        // 모델 참조 공유
        model.addAttribute("user2List", user2List);

        return "user2/list";
    }


    @PostMapping("/user2/register")
    public String register(){
        return "user2/register";
    }



}
