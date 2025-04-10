package kr.co.sboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO { // 매번 모델 참조 하지 않을려고 만듦

    // 페이징 관련
    @Builder.Default
    private int no = 1;

    @Builder.Default
    private String cate = "free";
    
    // 페이지 번호 (0부터 시작)
    @Builder.Default
    private int pg = 0;
    
    
    // 한페이지에 표시할 항목 수
    @Builder.Default
    private int size = 10;

    // 검색
    private String type;
    private String keyword;
    private String searchType;


    // 글목록 페이징 처리를 위한 pageable 객체생성 메서드
    public Pageable getPageable(String sort) {
        return PageRequest.of(this.pg, this.size, Sort.by(sort).descending()); // 내림차순 정렬
    }

}
