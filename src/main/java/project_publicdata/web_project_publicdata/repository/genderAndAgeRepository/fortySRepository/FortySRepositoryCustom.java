package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fortySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.FortySDto;

import java.util.List;

public interface FortySRepositoryCustom {

    List<Integer> getFortySConfCase();

    List<Double> getFortySConfCaseRate();

    List<Integer> getFortySDeathCnt();

    List<Double> getFortySDeathRate();

    List<Double> getFortySCriticalRate();

    List<FortySDto> getAllCountFortyS(DateDto date);
}
