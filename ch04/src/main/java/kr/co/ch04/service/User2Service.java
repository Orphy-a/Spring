package kr.co.ch04.service;

import kr.co.ch04.dao.User2DAO;
import kr.co.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    @Autowired
    private User2DAO dao;


    public List<User2DTO> list(){
        return dao.selectAllUser2();
    }

}
