package kr.co.ch04.dao;

import kr.co.ch04.dto.User2DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User2RowMapper implements RowMapper<User2DTO> {

    public User2DTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        User2DTO dto = new User2DTO();
        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setBirth(rs.getString(3));
        dto.setAddr(rs.getString(4));

        return dto;
    }


}
