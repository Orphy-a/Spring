package kr.co.ch09.controller;

import jakarta.validation.Valid;
import kr.co.ch09.Service.User2Service;
import kr.co.ch09.dto.User2DTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController// REST API 서비스 컨트롤러 어노테이션
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2")
    public List<User2DTO> list(){

        return user2Service.findAll();

    }

    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid){

        return user2Service.findById(uid);

    }

    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@Valid @RequestBody User2DTO user2DTO){ // 요청본문 내용에 포함된 데이터를 Java 객체로 변환하는 어노테이션, JSON 데이터 수신

        log.info("user2DTO: {}", user2DTO);

        User2DTO savedUser2 = user2Service.register(user2DTO) ;

        // ResponseEntity 응답객체를 반환하면 @ResponseBody 어노테이션 생략가능
        return ResponseEntity.ok(savedUser2);
    }

    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(@RequestBody User2DTO user2DTO){

        User2DTO user2dto = user2Service.modify(user2DTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(user2dto);


    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity<String> delete(@PathVariable("uid") String uid) {

        boolean isDelete = user2Service.delete(uid);

        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("success");
        }

        return ResponseEntity.notFound().build();

    }





}
