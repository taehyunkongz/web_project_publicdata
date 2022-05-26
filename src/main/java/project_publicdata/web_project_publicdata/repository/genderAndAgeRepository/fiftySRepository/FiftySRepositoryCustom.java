package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fiftySRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.FiftySDto;

import java.util.List;

public interface FiftySRepositoryCustom {

    List<Integer> getFiftySConfCase();

    List<Double> getFiftySConfCaseRate();

    List<Integer> getFiftySDeathCnt();

    List<Double> getFiftySDeathRate();

    List<Double> getFiftySCriticalRate();

    List<FiftySDto> getAllCountFiftyS(DateDto date);
}
