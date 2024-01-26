import com.lessons.config.SpringConfig;
import com.lessons.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class test {


    @Resource
    BookService bookService;
    @Test
    public void  test1(){
        System.out.println(bookService.getAll());
    }
}
