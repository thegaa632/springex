package opz.zerock.springex;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

//SampleService 입장에서는 인터페이스만 바라보므로 실제 객체가 SampleDAOImpl의 인스턴스인지 알 수 없지만, 코드를 작성하는데 아무런 문제가 없습니다.
// 이처럼 객체와 객체의 의존관계의 실제 객체를 몰라도 가능하게 하는 방식을 느슨한 결합(loose coupling)이라고 합니다.
//느슨한 결합을 이용하면 나중에 sampleDAO 타입의 객체를 다른 객체로 변경하더라도 sampleService 타입을 수정할 필요가 없습니다.

public interface SampleDAO {





}
