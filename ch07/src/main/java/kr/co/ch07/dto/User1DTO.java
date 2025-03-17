package kr.co.ch07.dto;

import kr.co.ch07.entity.User1;
import kr.co.ch07.repository.User1Repository;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {



    private String uid;
    private String name;
    private String hp;
    private int age;
    private String email;

    // 엔티티 변환 메서드 정의
    public User1 toentity(){

        return User1.builder()
                    .uid(uid)
                    .name(name)
                    .hp(hp)
                    .age(age)
                    .build();
    }

}
