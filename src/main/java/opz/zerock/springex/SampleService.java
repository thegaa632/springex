package opz.zerock.springex;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {
    //1. 필드 주입방식
//    @Autowired
//    private SampleDAO sampleDAO;

    //2. 생성자 주입방식
    // 주입 받아야 하는 객체의 변수는 Final로 작성합니다.

    private final SampleDAO sampleDAO;

//    public SampleService(SampleDAO sampleDAO) {
//        this.sampleDAO = sampleDAO;
//    }
}
