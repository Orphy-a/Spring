package kr.co.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User3DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user3")
@Entity
public class User3 {

    @Id
    private String uid;
    private String name;
    private String hp;
    private String birth;
    private String addr;

    public User3DTO toDTO(){

        return User3DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .birth(birth)
                .addr(addr)
                .build();
    }


}
