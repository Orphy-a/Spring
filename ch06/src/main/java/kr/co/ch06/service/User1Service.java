package kr.co.ch06.service;

import kr.co.ch06.dao.User1Mapper;
import kr.co.ch06.dto.User1DTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class User1Service {

    // 생성자 주입 - 상단에 AllArgsconstrutor 어노테이션으로 주입
    private final User1Mapper user1Mapper;


    public void register(User1DTO user1DTO) {
        user1Mapper.insertUser1(user1DTO);
    }
    public User1DTO find(String uid) {
        return user1Mapper.selectUser1(uid);
    }
    public List<User1DTO> findAll() {
        return user1Mapper.selectAllUser1();
    }
    public void modify(User1DTO user1DTO) {
        user1Mapper.updateUser1(user1DTO);
    }
    public void delete(String uid) {
        user1Mapper.deleteUser1(uid);
    }





}
