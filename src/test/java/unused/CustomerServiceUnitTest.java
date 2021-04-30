package unused;

import net.toscalecz.test.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerServiceUnitTest {

    //@Autowired
    //private CustomerService customerService;

    //@Test
    //public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
    //    List<Customer> customers = customerService.list();

    //    Assert.assertEquals(customers.size(), 0);
    //}
}
