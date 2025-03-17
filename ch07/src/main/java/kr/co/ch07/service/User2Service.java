package kr.co.ch07.service;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.entity.User2;
import kr.co.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User2Service {

    // 생성자 주입
    private final User2Repository repository;


    public void register(User2DTO user2DTO) {
        User2 user2 = user2DTO.toentity();


        // Entitiy insert => 새로운 엔티티
        // Entitiy Update => 기존 엔티티
        repository.save(user2);

    }

    public User2DTO find(String uid){

        // 아이디 조회
        Optional<User2> user2entity = repository.findById(uid);

        // Entity 존재 여부
        if(user2entity.isPresent()){

            User2 user2 = user2entity.get();
            return user2.toDTO();

        }

        return null;
    }

    public List<User2DTO> findAll() {

        List<User2> user2entities = repository.findAll();

        List<User2DTO> user2DTOS = user2entities
                                            .stream()
                .map(entity->{return entity.toDTO();})
                .toList();

        return user2DTOS;

    }


    public void modify(User2DTO user2DTO) {

        boolean exist = repository.existsById(user2DTO.getUid());

        if (exist) {
            User2 user2 = user2DTO.toentity();

            // Entitiy insert => 새로운 엔티티
            // Entitiy Update => 기존 엔티티
            repository.save(user2);
        }

    }
    public void delete(String uid) {

        repository.deleteById(uid);


    }

}
