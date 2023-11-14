package opz.zerock.springex;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary // 단일 값 종속성을 자동 연결하기위해 여러 후보가 자격을 가지는 경우 Bean에 우선순위를 부여해야함을 나타냄
@Qualifier("event")
public class EventSampleDAOlmpl implements SampleDAO{
}
