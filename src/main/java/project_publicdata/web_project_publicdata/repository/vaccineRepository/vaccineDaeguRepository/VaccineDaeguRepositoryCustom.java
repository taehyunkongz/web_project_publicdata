package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaeguRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineDaeguDto;

import java.util.List;

public interface VaccineDaeguRepositoryCustom {

    List<Integer> getDaeguFirstCnt();
    List<Integer> getDaeguSecondCnt();
    List<Integer> getDaeguThirdCnt();

    List<Integer> getDaeguAccFirstCnt();
    List<Integer> getDaeguAccSecondCnt();
    List<Integer> getDaeguAccThirdCnt();

    List<Integer> getDaeguTotalFirstCnt();
    List<Integer> getDaeguTotalSecondCnt();
    List<Integer> getDaeguTotalThirdCnt();

    List<VaccineDaeguDto> getAllVaccineCountDaegu(DateDto date);
}
