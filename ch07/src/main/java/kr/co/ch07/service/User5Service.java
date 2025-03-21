package kr.co.ch07.service;

import kr.co.ch07.dto.User5DTO;
import kr.co.ch07.entity.User5;
import kr.co.ch07.repository.User5Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User5Service {

    private final User5Repository user5Repository;

    public User5 register(User5DTO user5DTO) {


        log.info("register user5DTO: {}", user5DTO);

        User5 user5 =  user5DTO.toEntity();

        return user5Repository.save(user5);
    }

    public List<User5DTO> list(){

        List<User5> user5Entity = user5Repository.findAll();


        List<User5DTO> user5DTOS = user5Entity.stream()
                                        .map(entity -> {return entity.toDTO();})
                                        .toList();

        return user5DTOS;

    }

    public User5DTO find(String seq){

        Optional<User5> optUser5 = user5Repository.findById(seq);


        if(optUser5.isPresent()){

            User5 user5 = optUser5.get();
            log.info("user5: {}", user5);

            return user5.toDTO();
        }

        return null;
    }


    public void modify(User5DTO user5DTO) {


        boolean exist = user5Repository.existsById(String.valueOf(user5DTO.getSeq()));


        if(exist){
            User5 user5 = user5DTO.toEntity();


            user5Repository.save(user5);

        }

    }


}
