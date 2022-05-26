package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineUlsanRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineUlsanDto;

import java.util.List;

public interface VaccineUlsanRepositoryCustom {

    List<Integer> getUlsanFirstCnt();
    List<Integer> getUlsanSecondCnt();
    List<Integer> getUlsanThirdCnt();

    List<Integer> getUlsanAccFirstCnt();
    List<Integer> getUlsanAccSecondCnt();
    List<Integer> getUlsanAccThirdCnt();

    List<Integer> getUlsanTotalFirstCnt();
    List<Integer> getUlsanTotalSecondCnt();
    List<Integer> getUlsanTotalThirdCnt();

    List<VaccineUlsanDto> getAllVaccineCountUlsan(DateDto date);
}
