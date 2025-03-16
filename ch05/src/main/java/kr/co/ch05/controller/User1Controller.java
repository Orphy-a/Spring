package kr.co.ch05.controller;

import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class User1Controller {

    private final User1Service service;

    @Autowired
    public User1Controller(User1Service service) {
        this.service = service;
    }


    @RequestMapping(value = "/user1/list", method = RequestMethod.GET)
    public String list(Model model){

        List<User1DTO> user1DTOS = service.findAll();

        // 모델 참조
        model.addAttribute("user1DTOS", user1DTOS);


        // forward
        return "user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){

        // forward
        return "user1/register";
    }

    @PostMapping("user1/register")
    public String register(User1DTO user1DTO){

        // 서비스 호출
        service.register(user1DTO);

        // forward
        return "redirect:/user1/list";
    }


    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model){

        // 수정 데이터 조회
        User1DTO user1DTO = service.findById(uid);

        // 수정 출력하기 위해 모델 참조
        model.addAttribute(user1DTO);

        return "user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO) {
        service.modify(user1DTO);
        return "redirect:/user1/list";
    }


    @GetMapping("/user1/remove")
    public String remove(@RequestParam("uid") String uid){

        service.delete(uid);

        return "redirect:/user1/list";
    }



}
