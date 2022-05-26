package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.thirtySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.ThirtySDto;

import java.util.List;

public interface ThirtySRepositoryCustom {

    List<Integer> getThirtySConfCase();

    List<Double> getThirtySConfCaseRate();

    List<Integer> getThirtySDeathCnt();

    List<Double> getThirtySDeathRate();

    List<Double> getThirtySCriticalRate();

    List<ThirtySDto> getAllCountThirtyS(DateDto date);
}
