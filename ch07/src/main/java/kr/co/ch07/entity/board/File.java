package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString(exclude = "article")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Board_File")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ano")
    private Article article; // 글번호

    private String oname;
    private String sname;

}
