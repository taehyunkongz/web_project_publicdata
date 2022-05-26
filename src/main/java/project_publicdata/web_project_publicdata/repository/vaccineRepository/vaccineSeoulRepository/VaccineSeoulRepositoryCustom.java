package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSeoulRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineSeoulDto;

import java.util.List;

public interface VaccineSeoulRepositoryCustom {

    List<Integer> getSeoulFirstCnt();
    List<Integer> getSeoulSecondCnt();
    List<Integer> getSeoulThirdCnt();

    List<Integer> getSeoulAccFirstCnt();
    List<Integer> getSeoulAccSecondCnt();
    List<Integer> getSeoulAccThirdCnt();

    List<Integer> getSeoulTotalFirstCnt();
    List<Integer> getSeoulTotalSecondCnt();
    List<Integer> getSeoulTotalThirdCnt();

    List<VaccineSeoulDto> getAllVaccineCountSeoul(DateDto date);
}
