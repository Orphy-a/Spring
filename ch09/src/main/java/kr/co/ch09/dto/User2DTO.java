package kr.co.ch09.dto;

import jakarta.validation.constraints.*;
import kr.co.ch09.entity.User1;
import kr.co.ch09.entity.User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {

    @NotBlank // null, "", " " 허용하지 않는다.
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자, 숫자로 최소 4~10 입력") // 정규 표현식
    private String uid;

    @NotEmpty // null, "" 허용하지 않는다.
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "영어 소문자, 숫자로 최소 4~10 입력")
    private String name;

    @NotNull
    private String birth;

    @NotBlank
    private String addr;

    public User2 toEntity(){

        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();

    }

}
