package kr.co.sboard.repository.custom;


import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepositoryCustom {

    public Page<Tuple> selectAllForList(Pageable pageable);

}
