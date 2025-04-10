package kr.co.sboard.service;

import com.querydsl.core.Tuple;
import kr.co.sboard.dao.ArticleMapper;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private ArticleMapper articleMapper;

    public void register(ArticleDTO articleDTO) {

        // 엔티티 변환
        Article article = modelMapper.map(articleDTO, Article.class);

        // JPA
        // articleRepository.save(article);


        // Mybatis 저장
        articleMapper.insertArticle(articleDTO);

    }

    public PageResponseDTO findAll(PageRequestDTO pageRequestDTO) {

        // 페이징 처리를 위한 pageable 객체 생성
        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Tuple> pageArticle = articleRepository.selectAllForList(pageable);
        log.info("pageArticle : {}", pageArticle);

        // Article Entity 리스트를 ArticleDTO 리스트로 변환
        List<ArticleDTO> articleDTOList = pageArticle.getContent().stream().map(tuple -> {

            Article article = tuple.get(0, Article.class);
            String nick = tuple.get(1, String.class);

            ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
            articleDTO.setNick(nick);

            return articleDTO;

        }).toList();

        int total = (int) pageArticle.getTotalElements();

        return PageResponseDTO
                .builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(articleDTOList)
                .total(total)
                .build();
    }


}
