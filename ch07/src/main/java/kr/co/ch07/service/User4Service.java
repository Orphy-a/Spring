package kr.co.ch07.service;

import kr.co.ch07.dto.User4DTO;
import kr.co.ch07.entity.User4;
import kr.co.ch07.repository.User4Repository;
import kr.co.ch07.repository.board.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class User4Service {

    private final User4Repository repository;

    public void register(User4DTO user4DTO){
        User4 user4 = user4DTO.toEntity();

        repository.save(user4); // 등록

    }


}
