package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeonggiRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGyeonggiDto;

import java.util.List;

public interface VaccineGyeonggiRepositoryCustom {

    List<Integer> getGyeonggiFirstCnt();
    List<Integer> getGyeonggiSecondCnt();
    List<Integer> getGyeonggiThirdCnt();

    List<Integer> getGyeonggiAccFirstCnt();
    List<Integer> getGyeonggiAccSecondCnt();
    List<Integer> getGyeonggiAccThirdCnt();

    List<Integer> getGyeonggiTotalFirstCnt();
    List<Integer> getGyeonggiTotalSecondCnt();
    List<Integer> getGyeonggiTotalThirdCnt();

    List<VaccineGyeonggiDto> getAllVaccineCountGyeonggi(DateDto date);
}
