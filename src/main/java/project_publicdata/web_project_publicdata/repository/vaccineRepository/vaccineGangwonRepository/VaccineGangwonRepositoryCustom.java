package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGangwonRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGangwonDto;

import java.util.List;

public interface VaccineGangwonRepositoryCustom {

    List<Integer> getGangwonFirstCnt();
    List<Integer> getGangwonSecondCnt();
    List<Integer> getGangwonThirdCnt();

    List<Integer> getGangwonAccFirstCnt();
    List<Integer> getGangwonAccSecondCnt();
    List<Integer> getGangwonAccThirdCnt();

    List<Integer> getGangwonTotalFirstCnt();
    List<Integer> getGangwonTotalSecondCnt();
    List<Integer> getGangwonTotalThirdCnt();

    List<VaccineGangwonDto> getAllVaccineCountGangwon(DateDto date);
}
