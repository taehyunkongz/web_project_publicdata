package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineTotalRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.TotalVaccineCountDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineTotalDto;

import java.util.List;

public interface VaccineTotalRepositoryCustom {

    List<Integer> getTotalFirstCnt();
    List<Integer> getTotalSecondCnt();
    List<Integer> getTotalThirdCnt();

    List<Integer> getTotalAccFirstCnt();
    List<Integer> getTotalAccSecondCnt();
    List<Integer> getTotalAccThirdCnt();

    List<Integer> getTotalTotalFirstCnt();
    List<Integer> getTotalTotalSecondCnt();
    List<TotalVaccineCountDto> getTotalVaccineCount(DateDto date);

    List<VaccineTotalDto> getAllVaccineCountTotal(DateDto date);
}
