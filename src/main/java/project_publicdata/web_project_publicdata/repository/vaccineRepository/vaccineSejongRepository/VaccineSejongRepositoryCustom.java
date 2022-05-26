package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSejongRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineSejongDto;

import java.util.List;

public interface VaccineSejongRepositoryCustom {

    List<Integer> getSejongFirstCnt();
    List<Integer> getSejongSecondCnt();
    List<Integer> getSejongThirdCnt();

    List<Integer> getSejongAccFirstCnt();
    List<Integer> getSejongAccSecondCnt();
    List<Integer> getSejongAccThirdCnt();

    List<Integer> getSejongTotalFirstCnt();
    List<Integer> getSejongTotalSecondCnt();
    List<Integer> getSejongTotalThirdCnt();

    List<VaccineSejongDto> getAllVaccineCountSejong(DateDto date);
}
