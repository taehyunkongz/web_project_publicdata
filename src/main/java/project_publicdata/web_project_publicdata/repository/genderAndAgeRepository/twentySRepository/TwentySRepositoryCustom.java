package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.twentySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.TwentySDto;

import java.util.List;
public interface TwentySRepositoryCustom {

    List<Integer> getTwentySConfCase();

    List<Double> getTwentySConfCaseRate();

    List<Integer> getTwentySDeathCnt();

    List<Double> getTwentySDeathRate();

    List<Double> getTwentySCriticalRate();

    List<TwentySDto> getAllCountTwentyS(DateDto date);
}
