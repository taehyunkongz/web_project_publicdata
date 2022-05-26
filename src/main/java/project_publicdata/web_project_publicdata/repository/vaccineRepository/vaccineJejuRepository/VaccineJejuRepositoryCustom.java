package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJejuRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineJejuDto;

import java.util.List;

public interface VaccineJejuRepositoryCustom {

    List<Integer> getJejuFirstCnt();
    List<Integer> getJejuSecondCnt();
    List<Integer> getJejuThirdCnt();

    List<Integer> getJejuAccFirstCnt();
    List<Integer> getJejuAccSecondCnt();
    List<Integer> getJejuAccThirdCnt();

    List<Integer> getJejuTotalFirstCnt();
    List<Integer> getJejuTotalSecondCnt();
    List<Integer> getJejuTotalThirdCnt();

    List<VaccineJejuDto> getAllVaccineCountJeju(DateDto date);
}
