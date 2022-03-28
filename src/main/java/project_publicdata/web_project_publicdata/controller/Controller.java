package project_publicdata.web_project_publicdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class Controller {


    @RequestMapping("/api")
    public String load_save() throws IOException, ParseException {

        return "데이터베이스 저장 성공";
    }

   }







