package kr.co.ch04.dao;

import kr.co.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User2DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User2DTO selectUser2(String uid){

        String sql = "select * from user2 where uid = ?";

        Object[] params = {uid};

        return jdbcTemplate.queryForObject(sql, new User2RowMapper(), params);


    }

    public List<User2DTO> selectAllUser2(){

        String sql = "select * from user2";

        return jdbcTemplate.query(sql, new User2RowMapper());

    }


}
