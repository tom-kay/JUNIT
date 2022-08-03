package site.metacoding.junitproject.domain;

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
    System.out.println("책등록_test 실행");
  }
}
