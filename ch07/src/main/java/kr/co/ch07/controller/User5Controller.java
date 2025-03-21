package kr.co.ch07.controller;

import kr.co.ch07.dto.User5DTO;
import kr.co.ch07.entity.User5;
import kr.co.ch07.repository.User5Repository;
import kr.co.ch07.service.User5Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class User5Controller {

    private final User5Service user5Service;

    @GetMapping("/user5/list")
    public String list(Model model){

        List<User5DTO> user5DTOList = user5Service.list();

        model.addAttribute("user5dtoList", user5DTOList);

        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String register(){

        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO user5DTO) {

        user5Service.register(user5DTO);


        return "redirect:/user5/list";
    }


    @GetMapping("/user5/modify")
    public String modify(String seq, Model model){

        User5DTO user5dto = user5Service.find(seq);

        model.addAttribute("user5dto", user5dto);

        return "/user5/modify";
    }


    @PostMapping("/user5/modify")
    public String modify(User5DTO user5DTO){

        user5Service.modify(user5DTO);

        return "redirect:/user5/list";

    }



}
