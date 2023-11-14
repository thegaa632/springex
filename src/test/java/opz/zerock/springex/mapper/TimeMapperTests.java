package opz.zerock.springex.mapper;

import lombok.extern.log4j.Log4j2;
import opz.zerock.springex.mapper.TimeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

    @Autowired(required = false) // required = false로 하면 해당 객체를 주입받지 못하더라도 예외가 발생하지 않음
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {

        //마이바티스롸 스프링을 연동하고 메퍼 인터페이스를 황용하는 방식은 개발자가 실제동작하는클래스와
        //객체를 생성하지 않고, 스프릥에서 자동으로 생성되는 방식을 이용
        //스프링에서 자도으로 생성된 객체들을 이용하기 때문에 개발자가 직접 코드를 수정항 수 없다는 단점이 있기는 하지만
        // 인터페이스만으로도 개발을 완료할수 있다는 장점이 있다.
        log.info("스프링 - 마이바티스 db 설정 후 가져온 시간 : " + timeMapper.getNow());
    }
}
