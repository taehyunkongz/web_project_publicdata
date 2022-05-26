package project_publicdata.web_project_publicdata.repository.sidoRepository.ulsanRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.UlsanDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.UlsanDto;

import java.util.List;

public interface UlsanRepositoryCustom {

    List<Integer> countUlsanDefCnt();

    List<Integer> countUlsanDeathCnt();

    List<Integer> countUlsanIncdec();

    List<Integer> countUlsanOverflowCnt();

    List<UlsanDefCountAndGubunDto> getDefCountAndGubunUlsan(DateDto date);

    List<UlsanDto> getAllCountUlsan(DateDto date);

}
