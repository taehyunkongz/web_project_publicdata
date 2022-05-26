package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineBusanRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineBusanDto;

import java.util.List;

public interface VaccineBusanRepositoryCustom {

    List<Integer> getBusanFirstCnt();
    List<Integer> getBusanSecondCnt();
    List<Integer> getBusanThirdCnt();

    List<Integer> getBusanAccFirstCnt();
    List<Integer> getBusanAccSecondCnt();
    List<Integer> getBusanAccThirdCnt();

    List<Integer> getBusanTotalFirstCnt();
    List<Integer> getBusanTotalSecondCnt();
    List<Integer> getBusanTotalThirdCnt();

    List<VaccineBusanDto> getAllVaccineCountBusan(DateDto date);

}
