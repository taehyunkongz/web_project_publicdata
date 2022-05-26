package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.seventySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.SeventySDto;

import java.util.List;

public interface SeventySRepositoryCustom {

    List<Integer> getSeventySConfCase();

    List<Double> getSeventySConfCaseRate();

    List<Integer> getSeventySDeathCnt();

    List<Double> getSeventySDeathRate();

    List<Double> getSeventySCriticalRate();

    List<SeventySDto> getAllCountSeventyS(DateDto date);
}
