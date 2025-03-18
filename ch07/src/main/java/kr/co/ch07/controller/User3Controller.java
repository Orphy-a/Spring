package kr.co.ch07.controller;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.dto.User3DTO;
import kr.co.ch07.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class User3Controller {

    private final User3Service user3Service;


    @GetMapping("/user3/list")
    public String list(Model model){

        List<User3DTO> user3DTOList = user3Service.findall();

        log.info("user3DTOList: " + user3DTOList);

        model.addAttribute("user3DTOList", user3DTOList);

        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){

        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO){

        user3Service.register(user3DTO);

        return "redirect:/user3/list";

    }

    @GetMapping("/user3/modify")
    public String modify(){
        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO, Model model){


        user3Service.modify(user3DTO);


        return "redirect:/user3/list";
    }



}
