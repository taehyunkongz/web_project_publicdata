package project_publicdata.web_project_publicdata.repository.sidoRepository.jejuRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.JejuDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.JejuDto;

import java.util.List;

public interface JejuRepositoryCustom {

    List<Integer> countJejuDefCnt();

    List<Integer> countJejuDeathCnt();

    List<Integer> countJejuIncdec();

    List<Integer> countJejuOverflowCnt();

    List<JejuDefCountAndGubunDto> getDefCountAndGubunJeju(DateDto date);

    List<JejuDto> getAllCountJeju(DateDto date);
}
