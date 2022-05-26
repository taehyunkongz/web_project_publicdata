package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineIncheonRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineIncheonDto;

import java.util.List;


public interface VaccineIncheonRepositoryCustom {

    List<Integer> getIncheonFirstCnt();
    List<Integer> getIncheonSecondCnt();
    List<Integer> getIncheonThirdCnt();

    List<Integer> getIncheonAccFirstCnt();
    List<Integer> getIncheonAccSecondCnt();
    List<Integer> getIncheonAccThirdCnt();

    List<Integer> getIncheonTotalFirstCnt();
    List<Integer> getIncheonTotalSecondCnt();
    List<Integer> getIncheonTotalThirdCnt();

    List<VaccineIncheonDto> getAllVaccineCountIncheon(DateDto date);
}
