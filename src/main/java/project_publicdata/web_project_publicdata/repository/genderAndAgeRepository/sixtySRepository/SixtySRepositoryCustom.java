package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.sixtySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.SixtySDto;

import java.util.List;

public interface SixtySRepositoryCustom {

    List<Integer> getSixtySConfCase();

    List<Double> getSixtySConfCaseRate();

    List<Integer> getSixtySDeathCnt();

    List<Double> getSixtySDeathRate();

    List<Double> getSixtySCriticalRate();

    List<SixtySDto> getAllCountSixtyS(DateDto date);
}
