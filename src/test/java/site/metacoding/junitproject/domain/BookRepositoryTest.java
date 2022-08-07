package site.metacoding.junitproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTest {
  
  @Autowired
  private BookRepository bookRepository;

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
}
