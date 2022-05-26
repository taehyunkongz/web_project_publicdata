package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaejeonRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineDaejeonDto;

import java.util.List;

public interface VaccineDaejeonRepositoryCustom {

    List<Integer> getDaejeonFirstCnt();
    List<Integer> getDaejeonSecondCnt();
    List<Integer> getDaejeonThirdCnt();

    List<Integer> getDaejeonAccFirstCnt();
    List<Integer> getDaejeonAccSecondCnt();
    List<Integer> getDaejeonAccThirdCnt();

    List<Integer> getDaejeonTotalFirstCnt();
    List<Integer> getDaejeonTotalSecondCnt();
    List<Integer> getDaejeonTotalThirdCnt();

    List<VaccineDaejeonDto> getAllVaccineCountDaejeon(DateDto date);
}
