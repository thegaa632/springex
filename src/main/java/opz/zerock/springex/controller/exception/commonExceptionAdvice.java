package opz.zerock.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;

@ControllerAdvice // 컨트롤러에서 발생하는 예외에 맞게 처리될수 있는 기능들을 제공, @ControllerAdvice가 선언된 클래스역시 스프링 빈으로 처리됨
@Log4j2
public class commonExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException) {
        log.error("--------------------------------------------");
        log.error(numberFormatException.getMessage());
        return "NUMBER FORMAT EXCEPTION";
    }

    //범용적인 예외 처리

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String ExceptCommon(Exception e) {
        log.error("--------------------------------------");
        log.error("에러 : " + e.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + e.getMessage() + "</li>");

        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> {
                    buffer.append("<li>" + stackTraceElement + "</li>");
                }
        );
        buffer.append("</ul>");
        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
}
