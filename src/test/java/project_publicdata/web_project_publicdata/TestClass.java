package project_publicdata.web_project_publicdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.repository.sidoRepository.busanRepository.BusanRepository;
import project_publicdata.web_project_publicdata.service.MainService;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class TestClass {

    private final EntityManager em;

    private final MainService mainService;

    private final BusanRepository busanRepository;

//    @Test
//    public void test() {
//        Busan busan = new Busan(100, 100, 100, 100, "ddd", "000", 100, LocalDate.now(),
//                "ddd", 100, "str", 100);
//
//        busanRepository.save(busan);
//        busanRepository.getAllCountBusan(new DateDto("2022")).get(0);
//
//    }

}
