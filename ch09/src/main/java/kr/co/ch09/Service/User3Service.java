package kr.co.ch09.Service;

import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.dto.User3DTO;
import kr.co.ch09.entity.User1;
import kr.co.ch09.entity.User3;
import kr.co.ch09.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User3Service {


    private final User3Repository user3Repository;

    public User3DTO find(String uid){

       Optional<User3> optionalUser3 = user3Repository.findById(uid);

       if(optionalUser3.isPresent()){
           return optionalUser3.get().toDTO();
       }

       return null;

    }

    public List<User3DTO> findAll(){

        List<User3> list = user3Repository.findAll();

        return list.stream()
                .map(entity -> entity.toDTO())
                .toList();


    }

    public User3DTO register(User3DTO user3DTO){

        User3 user3 = user3DTO.toEntity();

        User3 saved = user3Repository.save(user3);

        return saved.toDTO();

    }
    public User3DTO modify(User3DTO user3DTO) {

        if(user3Repository.existsById(user3DTO.getUid())){

            User3 user3 = user3DTO.toEntity();

            User3 savedUser3 = user3Repository.save(user3);


            return savedUser3.toDTO();

        }

        return null;

    }
    public boolean delete(String uid){

        if(user3Repository.existsById(uid)){

            user3Repository.deleteById(uid);

            return true;

        }

        return false;

    }


}
