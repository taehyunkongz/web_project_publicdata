package project_publicdata.web_project_publicdata;

import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import project_publicdata.web_project_publicdata.service.init.InitGenderAndAgeService;
import project_publicdata.web_project_publicdata.service.init.InitSidoService;
import project_publicdata.web_project_publicdata.service.init.InitVaccineService;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Profile("local")
@Component
@RequiredArgsConstructor
public class Init {

    private final InitSidoService initSidoService;
    private final InitGenderAndAgeService initGenderAndAgeService;
    private final InitVaccineService initVaccineService;

    @PostConstruct
    public void init() throws ParseException, IOException {
        initSidoService.initSidoService();
        initGenderAndAgeService.initSidoService();
        initVaccineService.initVaccineService();

    }
}
