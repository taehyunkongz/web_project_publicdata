package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.teenagersRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.TeenagersDto;

import java.util.List;

public interface TeenagersRepositoryCustom {

    List<Integer> getTeenagersConfCase();

    List<Double> getTeenagersConfCaseRate();

    List<Integer> getTeenagersDeathCnt();

    List<Double> getTeenagersDeathRate();

    List<Double> getTeenagersCriticalRate();

    List<TeenagersDto> getAllCountTeenagers(DateDto date);
}
