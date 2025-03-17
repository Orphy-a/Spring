package kr.co.ch07.dto;

import kr.co.ch07.entity.User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {

    private String uid;
    private String name;
    private String birth;
    private String addr;

    // DTO를 엔티티로 변환하는 메서드 정의
    public User2 toentity(){

        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }

}
