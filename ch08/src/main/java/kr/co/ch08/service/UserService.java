package kr.co.ch08.service;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.entity.User;
import kr.co.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public void register(UserDTO userDTO) {

        String pass = userDTO.getPass();
        String encodedPass = passwordEncoder.encode(pass);
        userDTO.setPass(encodedPass);

        // DTO를 Entity로 변환
        User user = userDTO.toEntity();

        userRepository.save(user);

    }



}
