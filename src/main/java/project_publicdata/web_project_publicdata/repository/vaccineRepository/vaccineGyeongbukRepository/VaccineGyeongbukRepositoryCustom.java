package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongbukRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGyeongbukDto;

import java.util.List;

public interface VaccineGyeongbukRepositoryCustom {

    List<Integer> getGyeongbukFirstCnt();
    List<Integer> getGyeongbukSecondCnt();
    List<Integer> getGyeongbukThirdCnt();

    List<Integer> getGyeongbukAccFirstCnt();
    List<Integer> getGyeongbukAccSecondCnt();
    List<Integer> getGyeongbukAccThirdCnt();

    List<Integer> getGyeongbukTotalFirstCnt();
    List<Integer> getGyeongbukTotalSecondCnt();
    List<Integer> getGyeongbukTotalThirdCnt();

    List<VaccineGyeongbukDto> getAllVaccineCountGyeongbuk(DateDto date);
}
