package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.maleRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.MaleDto;

import java.util.List;

public interface MaleRepositoryCustom {

    List<Integer> getMaleConfCase();

    List<Double> getMaleConfCaseRate();

    List<Integer> getMaleDeathCnt();

    List<Double> getMaleDeathRate();

    List<Double> getMaleCriticalRate();

    List<MaleDto> getAllCountMale(DateDto date);
}
