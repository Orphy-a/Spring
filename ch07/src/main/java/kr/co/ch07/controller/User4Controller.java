package kr.co.ch07.controller;

import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.dto.User4DTO;
import kr.co.ch07.service.User4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class User4Controller {

    private final User4Service user4Service;

    @GetMapping("/user4/list")
    public String list(){

        return "/user4/list";
    }


    @GetMapping("/user4/register")
    public String register(User4DTO user4DTO, Model model){

        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(Model model, User4DTO user4DTO){

        user4Service.register(user4DTO);

        model.addAttribute("user4DTO", user4DTO);

        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(String uid, Model model){

        return "/user4/modify";
    }


}
