package kr.co.ch09.controller;

import kr.co.ch09.Service.User3Service;
import kr.co.ch09.dto.User3DTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class User3Controller {

    private final User3Service user3Service;

    @GetMapping("/user3")
    public List<User3DTO> list(){
        return user3Service.findAll();
    }

    @PostMapping("/user3")
    public ResponseEntity<User3DTO> register(User3DTO user3DTO){


        User3DTO savedUser3 = user3Service.register(user3DTO);

        return ResponseEntity.ok(savedUser3);

    }

    @PutMapping("/user3")
    public ResponseEntity<User3DTO> modify(@RequestBody User3DTO user3DTO){

        log.info("Modify user3DTO: {}", user3DTO);


        User3DTO modifiedUser3 = user3Service.modify(user3DTO);



        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(modifiedUser3);

    }


    @DeleteMapping("/user3/{uid}")
    public ResponseEntity<String> delete(@PathVariable("uid") String uid){

        boolean isDeleted = user3Service.delete(uid);

        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("success");
        }

        return ResponseEntity
                .notFound()
                .build();


    }

}
