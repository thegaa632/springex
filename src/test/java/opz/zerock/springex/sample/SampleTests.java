package opz.zerock.springex.sample;

import lombok.extern.log4j.Log4j2;
import opz.zerock.springex.SampleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    //의존성 주입 자동 처리
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;
    @Test
    public void testService() {
        log.info("샘플서비스 객체 주입 확인 : " + sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testConnection() throws Exception {

        Connection connection = dataSource.getConnection();
        log.info("커낵션 객체 : " + connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }
}
