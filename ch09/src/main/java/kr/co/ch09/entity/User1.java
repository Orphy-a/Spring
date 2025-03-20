package kr.co.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User1DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user1")
public class User1 {

    @Id
    private String uid;
    private String name;
    private String hp;
    private String age;


    public User1DTO toDTO(){

        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();

    }


}
