package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.eightySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.EightySDto;

import java.util.List;

public interface EightySRepositoryCustom {

    List<Integer> getEightySConfCase();

    List<Double> getEightySConfCaseRate();

    List<Integer> getEightySDeathCnt();

    List<Double> getEightySDeathRate();

    List<Double> getEightySCriticalRate();

    List<EightySDto> getAllCountEightyS(DateDto date);


}
