package site.metacoding.junitproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.*;

@DataJpaTest
public class BookRepositoryTest {
  
  @Autowired
  private BookRepository bookRepository;

  @BeforeEach
  public void 데이터준비(){
    String title = "junit";
    String author = "겟인데어";

    Book book = Book.builder()
      .title(title)
      .author(author)
      .build();

    bookRepository.save(book);
  }

  // 1. 책등록
  @Test
  public void 책등록_test(){
    String title = "junit5";
    String author = "메타코딩";

    Book book = Book.builder()
      .title(title)
      .author(author)
      .build();

    Book bookPS = bookRepository.save(book);

    assertEquals(title, bookPS.getTitle());
    assertEquals(author, bookPS.getAuthor());
  }

  @Test
  public void 책목록보기_test(){
    
    List<Book> books = bookRepository.findAll();
    
    System.out.println(books.size());
  }

  @Sql("classpath:db/tableInit.sql")
  @Test
  public void 책한건보기_test(){
    String title = "junit";
    String author = "겟인데어";

    Book book = bookRepository.findById(1L).get();

    assertEquals(title, book.getTitle());
    assertEquals(author, book.getAuthor());
  }
  
  //책 삭제
  @Sql("classpath:db/tableInit.sql")
  @Test
  public void 책삭제_test(){
    //given
    Long id = 1L;

    //when
    bookRepository.deleteById(id);

    //then
    assertFalse(bookRepository.findById(id).isPresent());

  }

}
