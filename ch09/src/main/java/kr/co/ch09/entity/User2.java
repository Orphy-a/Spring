package kr.co.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.dto.User2DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user2")
public class User2 {

    @Id
    private String uid;
    private String name;
    private String birth;
    private String addr;


    public User2DTO toDTO(){

        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();

    }


}
