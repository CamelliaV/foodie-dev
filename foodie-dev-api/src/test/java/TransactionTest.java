import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.Application;
import com.learn.entity.Users;
import com.learn.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransactionTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    @Transactional(propagation = Propagation.SUPPORTS)
    public void testReadFailed() {
        List<Users> users = usersMapper.selectList(new QueryWrapper<Users>().ne("username", "a"));
        System.out.println(">>>> [Output]: " + users);
        throw new RuntimeException();
    }
}
