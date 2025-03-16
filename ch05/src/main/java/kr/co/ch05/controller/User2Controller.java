package kr.co.ch05.controller;

import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private final User2Service service;

    @Autowired
    public User2Controller(User2Service service) {
        this.service = service;
    }

    @GetMapping("/user2/list")
    public String list(Model model){
        
        // 리스트 서비스 호출
        List<User2DTO> dtos = service.findAllUser2();

        // 모델참조
        model.addAttribute("dtos", dtos);

        return "/user2/list";

    }

    @GetMapping("/user2/register")
    public String register(){


        return "/user2/register";
    }


    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){

        service.registerUser2(user2DTO);


        return "redirect:/user2/list";
    }


    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){

        // 수정 데이터 조회
        User2DTO user2DTO = service.findUser2(uid);

        // 수정 출력하기 위해 모델 참조
        model.addAttribute(user2DTO);

        return "user2/modify";
    }




}
