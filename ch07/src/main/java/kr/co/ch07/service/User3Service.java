package kr.co.ch07.service;

import kr.co.ch07.dto.User3DTO;
import kr.co.ch07.entity.User3;
import kr.co.ch07.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User3Service {

    private final User3Repository repository;

    public void register(User3DTO user3DTO) {
        User3 user3 = user3DTO.toEntity();

        repository.save(user3);

    }


    public List<User3DTO> findall(){



        List<User3> user3Entities = repository.findAll();

        List<User3DTO> user3DTOS = user3Entities.stream()
                    .map(entity->{return entity.toDTO();})
                    .toList();

        return user3DTOS;

    }

    public User3DTO find(String uid){

        Optional<User3> user3Entity = repository.findById(uid);

        if(user3Entity.isPresent()){

            User3 user3 = user3Entity.get();
            return user3.toDTO();

        }

        return null;

    }

    public void modify(User3DTO user3DTO) {

        boolean exist = repository.existsById(user3DTO.getUid());

        if(exist){
            User3 user3 = user3DTO.toEntity();
            repository.save(user3);
        }

    }




}
