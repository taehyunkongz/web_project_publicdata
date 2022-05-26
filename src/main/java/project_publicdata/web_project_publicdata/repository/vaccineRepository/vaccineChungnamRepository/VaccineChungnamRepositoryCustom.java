package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungnamRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineChungnamDto;

import java.util.List;

public interface VaccineChungnamRepositoryCustom {

    List<Integer> getChungnamFirstCnt();
    List<Integer> getChungnamSecondCnt();
    List<Integer> getChungnamThirdCnt();

    List<Integer> getChungnamAccFirstCnt();
    List<Integer> getChungnamAccSecondCnt();
    List<Integer> getChungnamAccThirdCnt();

    List<Integer> getChungnamTotalFirstCnt();
    List<Integer> getChungnamTotalSecondCnt();
    List<Integer> getChungnamTotalThirdCnt();

    List<VaccineChungnamDto> getAllVaccineCountChungnam(DateDto date);
}
