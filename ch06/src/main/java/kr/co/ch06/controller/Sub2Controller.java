package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class Sub2Controller {

    // 어노테이션으로 로거 생성
    //private Logger logger = LoggerFactory.getLogger(Sub2Controller.class);



    @GetMapping("/sub2/thymeleaf")
    public String thymeleaf(Model model) {

        String str1 = "Hello World";
        String str2 = "Hello Thymeleaf";

        // User1DTO 객체 생성 - 생성자 방식
        User1DTO user1 = new User1DTO("a101","김유신","010-1234-1234", 21);

        log.info("user1 : {}",user1);


        // User1DTO 객체 생성 - 세터 방식
        User1DTO user2 = new User1DTO();
        user2.setUid("a102");
        user2.setName("김춘추");
        user2.setHp("010-4567-4567");
        user2.setAge(22);
        log.info("user2 : {}",user2);

        // User1DTO 객체 생성 - 빌더 방식
        User1DTO user3 = User1DTO.builder()
                                    .uid("a103")
                                    .name("홍길동")
                                    .hp("010-4454-1234")
                                    .age(25)
                                    .build();
        log.info("user2 : {}",user2);

        // 리스트 생성
        List<User1DTO> users = List.of(user1,user2,user3);

        
        // 모델 참조
        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);

        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        model.addAttribute("user3", user3);
    
        model.addAttribute("users", users);


        return "/sub2/thymeleaf";
    }






}
