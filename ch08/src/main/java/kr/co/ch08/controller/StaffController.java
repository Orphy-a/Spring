package kr.co.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/staff")
@Controller
public class StaffController {

    @GetMapping(value = {"", "/index"})
    public String index() {

        return "/staff/index";
    }

}
