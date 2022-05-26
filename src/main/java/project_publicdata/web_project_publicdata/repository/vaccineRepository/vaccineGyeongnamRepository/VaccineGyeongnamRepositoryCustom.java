package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongnamRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGyeongnamDto;

import java.util.List;

public interface VaccineGyeongnamRepositoryCustom {

    List<Integer> getGyeongnamFirstCnt();
    List<Integer> getGyeongnamSecondCnt();
    List<Integer> getGyeongnamThirdCnt();

    List<Integer> getGyeongnamAccFirstCnt();
    List<Integer> getGyeongnamAccSecondCnt();
    List<Integer> getGyeongnamAccThirdCnt();

    List<Integer> getGyeongnamTotalFirstCnt();
    List<Integer> getGyeongnamTotalSecondCnt();
    List<Integer> getGyeongnamTotalThirdCnt();

    List<VaccineGyeongnamDto> getAllVaccineCountGyeongnam(DateDto date);
}
