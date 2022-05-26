package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungbukRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineChungbukDto;

import java.util.List;

public interface VaccineChungbukRepositoryCustom {
    List<Integer> getChungbukFirstCnt();
    List<Integer> getChungbukSecondCnt();
    List<Integer> getChungbukThirdCnt();

    List<Integer> getChungbukAccFirstCnt();
    List<Integer> getChungbukAccSecondCnt();
    List<Integer> getChungbukAccThirdCnt();

    List<Integer> getChungbukTotalFirstCnt();
    List<Integer> getChungbukTotalSecondCnt();
    List<Integer> getChungbukTotalThirdCnt();

    List<VaccineChungbukDto> getAllVaccineCountChungbuk(DateDto date);
}
