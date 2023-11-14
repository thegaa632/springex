package opz.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import opz.zerock.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {


    @RequestMapping("/list1")
    public void list() {
        log.info("todo list....");
    }

    @GetMapping(value = "/register1")
    public void registerGet() {
        log.info("todo registerGet....");
    }

    @PostMapping(value = "/register1")
    public void registerPost(TodoDTO todoDTO) {log.info("todo registerPost....");
    log.info("매개변수로 들어온 todoDTO : " + todoDTO);
    }
}
