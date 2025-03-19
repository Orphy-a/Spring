package kr.co.ch08.controller;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.entity.User;
import kr.co.ch08.security.MyUserDetails;
import kr.co.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/user/login")
    public String login() {

        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {

        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO) {

        userService.register(userDTO);

        return "redirect:/user/login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    @GetMapping("/user/info")
    public String info(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication : {}", authentication);

        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        log.info("user : {}", user);

        model.addAttribute(user);

        return "/user/info";
    }

}
