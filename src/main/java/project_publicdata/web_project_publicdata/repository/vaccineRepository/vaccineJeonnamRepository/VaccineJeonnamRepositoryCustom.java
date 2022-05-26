package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonnamRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineJeonnamDto;

import java.util.List;

public interface  VaccineJeonnamRepositoryCustom {

    List<Integer> getJeonnamFirstCnt();
    List<Integer> getJeonnamSecondCnt();
    List<Integer> getJeonnamThirdCnt();

    List<Integer> getJeonnamAccFirstCnt();
    List<Integer> getJeonnamAccSecondCnt();
    List<Integer> getJeonnamAccThirdCnt();

    List<Integer> getJeonnamTotalFirstCnt();
    List<Integer> getJeonnamTotalSecondCnt();
    List<Integer> getJeonnamTotalThirdCnt();

    List<VaccineJeonnamDto> getAllVaccineCountJeonnam(DateDto date);
}
