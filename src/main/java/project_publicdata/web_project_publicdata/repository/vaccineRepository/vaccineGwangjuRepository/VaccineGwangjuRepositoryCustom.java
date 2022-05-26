package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGwangjuRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGwangjuDto;

import java.util.List;

public interface VaccineGwangjuRepositoryCustom {

    List<Integer> getGwangjuFirstCnt();
    List<Integer> getGwangjuSecondCnt();
    List<Integer> getGwangjuThirdCnt();

    List<Integer> getGwangjuAccFirstCnt();
    List<Integer> getGwangjuAccSecondCnt();
    List<Integer> getGwangjuAccThirdCnt();

    List<Integer> getGwangjuTotalFirstCnt();
    List<Integer> getGwangjuTotalSecondCnt();
    List<Integer> getGwangjuTotalThirdCnt();

    List<VaccineGwangjuDto> getAllVaccineCountGwangju(DateDto date);
}
