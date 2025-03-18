package kr.co.ch07.repository;

import kr.co.ch07.entity.board.Article;
import kr.co.ch07.entity.board.Comment;
import kr.co.ch07.entity.board.File;
import kr.co.ch07.entity.board.User;
import kr.co.ch07.repository.board.ArticleRepository;
import kr.co.ch07.repository.board.CommentRepository;
import kr.co.ch07.repository.board.FileRepository;
import kr.co.ch07.repository.board.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired private ArticleRepository articleRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CommentRepository commentRepository;


    // 테스트 1 - 사용자 등록
    @Test
    public void test1(){

        // given
        User user = User.builder()
                .uid("a102")
                .name("김춘추")
                .hp("010-1237-4567")
                .build();

        // when
        User savedUser = userRepository.save(user); // 등록

        // then
        System.out.println(savedUser);

    }

    // 테스트 2 - 글 등록
    @Test
    public void test2(){

        User user = User.builder()
                .uid("a101")
                .build();


        Article article = Article.builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .user(user)
                .build();

        Article savedarticle = articleRepository.save(article);

        System.out.println(savedarticle);
    }

    // 테스트 3 - 댓글 등록
    @Test
    public void test3(){
        User user = User.builder()
                .uid("a101")
                .build();


        Article article = Article.builder()
                .no(3)
                .build();

        Comment comment = Comment.builder()
                .article(article)
                .content("댓글2 입니다.")
                .user(user)
                .build();

        Comment savedComment = commentRepository.save(comment);

        System.out.println(savedComment);

    }

    // 테스트 4 - 파일 등록
    @Test
    public void test4(){

        Article article = Article.builder()
                .no(3)
                .build();

        File file = File.builder()
                .oname("abc.txt")
                .sname("asd.txt")
                .build();



    }

    // 테스트 5 - 전체 글 조회
    @Transactional
    @Test
    public void test5(){

        /*
         엔티티 관계설정으로 되어있을 경우에 해당 엔티티를 조회할 때
         관계가 맺어진 다른 엔티티도 함께 조회되기 때문에
         단일 트랜잭션으로 처리해야 된다.
        */
        List<Article> articleList = articleRepository.findAll();

        /*
            양방향 엔티티 관계에서 @ToString 어노테이션으로 생성되는 toString 메서드에서
            엔티티간 toString 재귀 호출로 인해 stackOverflow 에러 발생 => @ToString에서 exclude 속성으로
            순환참조 되는 엔티티를 제외
        */

        // System.out.println(articleList);


        for(Article aritcle : articleList){
            System.out.println(aritcle);

            List<Comment> commentList = aritcle.getComment();
            for(Comment comment : commentList){
                System.out.println(comment);
            }


        }


    }

    // 테스트 6 - 글 조회
    @Transactional
    @Test
    public void test6(){

        Optional<Article> opt = articleRepository.findById(3L);

        if(opt.isPresent()){
            Article article = opt.get();
            System.out.println(article);
        }

    }

}
