package kr.co.sboard.repository;

import kr.co.sboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    long countByUid(String uid);

    long countByEmail(String email);

    long countByNick(String value);

    long countByHp(String value);
}
