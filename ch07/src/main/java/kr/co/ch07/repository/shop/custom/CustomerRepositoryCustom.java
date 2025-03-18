package kr.co.ch07.repository.shop.custom;

import kr.co.ch07.entity.shop.Customer;
import kr.co.ch07.repository.shop.CustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// CustomerRepository 확장 인터페이스 - queryDsl 실행할 메서드 선언
public interface CustomerRepositoryCustom extends JpaRepository<Customer, String>, CustomerRepository {

    public List<Customer> selectAllCustomer();
    public Customer selectCustomer(String custId);


}
