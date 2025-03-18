package kr.co.ch07.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shop_Customer")
public class Customer {

    @Id
    private String custId;
    private String name;
    private int age;
    private String hp;

    @CreationTimestamp
    private LocalDateTime regDate;

}
