package project_publicdata.web_project_publicdata.repository.sidoRepository.chungnamRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.ChungnamDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.ChungnamDto;

import java.util.List;

public interface ChungnamRepositoryCustom {

    List<Integer> countChungnamDefCnt();

    List<Integer> countChungnamDeathCnt();

    List<Integer> countChungnamIncdec();

    List<Integer> countChungnamOverflowCnt();

    List<ChungnamDefCountAndGubunDto> getDefCountAndGubunChungnam(DateDto date);

    List<ChungnamDto> getAllCountChungnam(DateDto date);
}
