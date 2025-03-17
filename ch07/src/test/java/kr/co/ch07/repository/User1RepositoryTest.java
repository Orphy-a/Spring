package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;


    @Test
    void findUser1ByUid() {

        // given
        String uid = "a101";

        // when
        User1 user1 = user1Repository.findUser1ByUid(uid);

        System.out.println(user1);

    }


    @Test
    void testFindUser1ByUid() {

        String uid = "a102";
        User1 user1 = user1Repository.findUser1ByUid(uid);
        System.out.println(user1);

    }

    @Test
    void findUser1ByName() {
        String name = "라마바";

        List<User1> user1 = user1Repository.findUser1ByName(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByNameNot() {
        String name = "라마바";

        List<User1> user1 = user1Repository.findUser1ByNameNot(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByUidAndName() {
        String uid = "a101";
        String name  = "가나다";

        User1 user1 = user1Repository.findUser1ByUidAndName(uid, name);

        System.out.println(user1);

    }

    @Test
    void findUser1ByUidOrName() {

        String uid = "a101";
        String name = "라마바";
        List<User1> user1 = user1Repository.findUser1ByUidOrName(uid, name);

        System.out.println(user1);

    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void findUser1ByNameLike() {
    }

    @Test
    void findUser1ByNameContains() {
    }

    @Test
    void findUser1ByNameStartsWith() {
    }

    @Test
    void findUser1ByNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByName() {
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void countUser1ByName() {
    }

    @Test
    void selectUser1UnderAge30() {

    }

    @Test
    void selectUser1ByName() {
    }

    @Test
    void selectUser1ByNameParam() {
    }

    @Test
    void selectUser1ByUid() {
    }

    @Test
    void selectParentWithChild() {

        // given
        String pid = "p101";

        List<Object[]> list = user1Repository.selectParentWithChild(pid);

        for (Object[] o : list) {
            Parent parent = (Parent) o[0];
            Child child = (Child) o[1];

            System.out.println(parent);
            System.out.println(child);
        }

    }
}