package project_publicdata.web_project_publicdata.repository.sidoRepository.jeonnamRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.JeonnamDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.JeonnamDto;

import java.util.List;

public interface JeonnamRepositoryCustom {

    List<Integer> countJeonnamDefCnt();

    List<Integer> countJeonnamDeathCnt();

    List<Integer> countJeonnamIncdec();

    List<Integer> countJeonnamOverflowCnt();

    List<JeonnamDefCountAndGubunDto> getDefCountAndGubunJeonnam(DateDto date);

    List<JeonnamDto> getAllCountJeonnam(DateDto date);
}
