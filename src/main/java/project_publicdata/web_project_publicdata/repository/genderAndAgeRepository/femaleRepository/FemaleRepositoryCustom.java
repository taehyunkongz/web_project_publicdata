package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.femaleRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.FemaleDto;

import java.util.List;

public interface FemaleRepositoryCustom {

    List<Integer> getFemaleConfCase();

    List<Double> getFemaleConfCaseRate();

    List<Integer> getFemaleDeathCnt();

    List<Double> getFemaleDeathRate();

    List<Double> getFemaleCriticalRate();

    List<FemaleDto> getAllCountFemale(DateDto date);
}
