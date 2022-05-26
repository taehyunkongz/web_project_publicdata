package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.kidsRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.KidsDto;

import java.util.List;

public interface KidsRepositoryCustom {

    List<Integer> getKidsConfCase();

    List<Double> getKidsConfCaseRate();

    List<Integer> getKidsDeathCnt();

    List<Double> getKidsDeathRate();

    List<Double> getKidsCriticalRate();

    List<KidsDto> getAllCountKids(DateDto date);
}
