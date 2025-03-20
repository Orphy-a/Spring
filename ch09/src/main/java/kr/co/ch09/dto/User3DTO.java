package kr.co.ch09.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kr.co.ch09.entity.User2;
import kr.co.ch09.entity.User3;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User3DTO {

    @NotBlank // 빈칸 허용 x
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자, 숫자로 최소 4~10 입력")
    private String uid;

    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자, 숫자로 최소 4~10 입력")
    private String name;

    @NotBlank
    private String hp;

    @NotBlank
    private String birth;

    @NotBlank
    private String addr;


    public User3 toEntity() {
        return User3.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .birth(birth)
                .addr(addr)
                .build();
    }



}
