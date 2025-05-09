package kr.co.ch07.dto;

import kr.co.ch07.entity.User5;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User5DTO {

    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User5 toEntity() {
        return User5.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }

}
