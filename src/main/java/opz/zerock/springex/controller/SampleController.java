package opz.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import opz.zerock.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/todo")
public class SampleController {

    //스프링 mvc 컨트롤러의 특징 1) 상속이나 인터페이스를 구현하는 방식을 사용하지 않고 어노테이션으로 처리 가능, 2) 오러라이드 없이 필요한 메서드들 정의
    //                       3) 메소드의 파라미터를 기본 자료형이나 객체 자료형으로 마음대로 지정가능, 4) 메소드의 리턴타입도 void, string 객체 등 다양한 타입을 사용할 수 있음
    //                       5) 서블릿 중심의 mvc의 경우 Servlet을 상속받아 doget/dopost와 같은 제한적인 메소드를 오버라이드 해서 사용했지만 스프링mvc의 경우 하나의 컨트롤러를 이용해서 여러경로의 호출을 모두 처리
    @GetMapping(value = "/hello") // 스프링 4 버전 이후 추가
    public void hello() {
        log.info("hello...");
    }

    @RequestMapping("/list")
    public void list() {
        log.info("todo list....");
    }

    //    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public void register() {
//        log.info("todo register....");
//    }
    @GetMapping(value = "/register") //위의 메소드와 같음
    public void registerGet() {
        log.info("todo registerGet....");
    }

    //@RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping(value = "/register")
    public void registerPost() {
        log.info("todo registerPost....");
    }

    //스프링mvc 특징
    //1) 단순 파라미터 자동 수집
    //2) 기본 자료형의 경우에는 자동으로 형변환 가능
    //3) 객체 자료형의 경우는 setxxx()의 동작을 통해서 처리
    //4) 객체 자료형의 경우 생성자가 없거나 파라미터가 없는 생성자가 필요(java beans)
    @GetMapping("/ex1")
    public void ex1(String name, int age) {

        log.info("ex1--------------");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    //스프링 mvc의 파라미터는 기본적으로 요청에 전달된 파라미터 이름을 기준으로 동작하지만 간혹 파라미터가 전달되지 않으면 문제가 발생 할 수 있다.
    //이런 경우라면 @RequestParam을 고려
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name, @RequestParam(name = "age", defaultValue = "23") int age) {

        log.info("ex1--------------");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    //Formatter를 이용한 파라미터의 커스텀 처리
    // 기본적으로 http는 문자열로 데이터를 전달하기 때문에 컨트롤러는 문자열을 기준으로 특정한 클래스의 객체로 처리하는 작업이 진행됨, 그래서 문제는 날짜관련 타입
    // 브라우저에서 '2023-11-14'와 같은 형태의 문자열을 date나 localDate, LocaldateTime 등으로 반환하는 작업이 많이 필요하지만 이에 대한 파라미터 수집은 에러가 발생한다.
    // 그럴경우 formatter를 사용해서 문자열을 객체로 객체를 문자열로 변환해준다.

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {

        log.info("ex3--------------");
        log.info("dueDate : " + dueDate);
    }

    //초기 스프링 mvc에서는 ModelAndView 객체를 생성하는 방식으로 사용했지만
    //스프링 mvc3 버전이후로 Model(org.springframework.ui.Model)이라는 파라미터만 추가하면 된다.
    //
//    @GetMapping("/ex4")
//    public void  ex4(Model model) {
//        log.info("ex4--------------");
//        model.addAttribute("menu","noodle");
//    }

    //기존 ModelAndView 방식
//    @GetMapping("/ex5")
//    public ModelAndView ex5(Model model) {
//        log.info("ex5--------------");
//        model.addAttribute("menu","noodle");
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("ex5");
//        return mav;
//    }

    //java Beans와 @ModelAttribute
    // 스프링 MVC의 컨트롤러는 특이하게도 파라미터로 getter/setter를 이용하는 java Bean의 형식의 사용자정의 클래스가
    // 파라미터인 경우에는 자동으로 화면까지 객체를 전달합니다.

    @GetMapping("/ex4_2")
    public void ex4_2(TodoDTO todoDTO) { //JSP화면에서 TodoDTO의 첫글자를 소문자로 변경되어 처리 %{todoDTO}
        log.info("ex4_2--------------");
        log.info(todoDTO);
    }

    @GetMapping("/ex4_3") //만일 자동으로 생성된 변수명 todoDTO라는 이름 외에 다른 이름을 사용하고 싶을 경우
    public void ex4_3(@ModelAttribute("dto") TodoDTO todoDTO) {
        log.info("ex4_3--------------");
        log.info(todoDTO);
    }

    //RedirectAttribute와 리다이렉션
    //PRG 패턴을 처리하기 위해서 스프링MVc에서는  RedirectAttribute라는 특별한 타입을 제공,RedirectAttributes 역시 Model과 마찬가지로 파라미터로 추가하기만 하면 자동으로
    //생성되는 방식으로 개발할 때 사용할 수 있습니다.
    //addAttribute(키, 값) : 리다이렉트 시 쿼리스트림이 되는 값을 지정
    //addFlashAttribute(키, 값) : 일회용으로만 데이터를 전달하고 삭제되는 값을 지정

    @GetMapping("/ex5") //만일 자동으로 생성된 변수명 todoDTO라는 이름 외에 다른 이름을 사용하고 싶을 경우
    public String ex5(RedirectAttributes redirectAttributes) {
        log.info("ex5--------------");
        redirectAttributes.addAttribute("name", "hong1");
        redirectAttributes.addFlashAttribute("message", "리다이렉트 성공");
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {
    }


    //3) 스프링 mvc에서 컨트롤로 클래스 안의 메소드의 리턴타입
    // -void : 컨트롤러ㅓ의 @requestMapping 값과 @GetMapping 등 메소드에서 선언된 값을 그대로 뷰(view)이름으로 사용하게 되고, void는 주로 상황에 관계없이 동일한 화면을 보여주는 경우에 사용
    // -문자열 : 문자열은 상항에 따라서(redirect:) 다른 화면을 보여주는 경우에 사용
    // -객체나 배열, 기본 자료형
    // - ResponseEntity
    // 앞의 항목중에 일반적으로 화면이 따로있는 경우에 
    // JSON 타입을 활용할때는 객체나 ResponseEntity를 사용
    //  HTTP 응답을 보다 세밀하게 제어하고자 할 때 사용됩니다. 주로 응답의 상태 코드, 헤더 및 본문을 커스터마이징하고 싶을 때 활용

    //스프링 mvc 컨트롤러 예외 처리
    @GetMapping("/ex7")
    public void ex7(String name, int age) {
        log.info("name : " + name);
        log.info("age : " + age);

    }
}
