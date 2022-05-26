package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonbukRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineJeonbukDto;

import java.util.List;

public interface VaccineJeonbukRepositoryCustom {

    List<Integer> getJeonbukFirstCnt();
    List<Integer> getJeonbukSecondCnt();
    List<Integer> getJeonbukThirdCnt();

    List<Integer> getJeonbukAccFirstCnt();
    List<Integer> getJeonbukAccSecondCnt();
    List<Integer> getJeonbukAccThirdCnt();

    List<Integer> getJeonbukTotalFirstCnt();
    List<Integer> getJeonbukTotalSecondCnt();
    List<Integer> getJeonbukTotalThirdCnt();

    List<VaccineJeonbukDto> getAllVaccineCountJeonbuk(DateDto date);
}
