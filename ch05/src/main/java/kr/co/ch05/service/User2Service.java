package kr.co.ch05.service;

import kr.co.ch05.dao.User2Mapper;
import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private final User2Mapper user2Mapper;

    @Autowired
    public User2Service(User2Mapper user2Mapper) {
        this.user2Mapper = user2Mapper;
    }

    public void registerUser2(User2DTO user2DTO) {
        user2Mapper.insertUser2(user2DTO);
    }
    public User2DTO findUser2(String uid) {
        return user2Mapper.selectUser2(uid);
    }
    public List<User2DTO> findAllUser2() {
        return user2Mapper.selectAllUser2();
    }
    public void modifyUser2(User2DTO user2DTO) {
        user2Mapper.updateUser2(user2DTO);
    }
    public void remove(String uid) {
        user2Mapper.deleteUser2(uid);
    }




}
