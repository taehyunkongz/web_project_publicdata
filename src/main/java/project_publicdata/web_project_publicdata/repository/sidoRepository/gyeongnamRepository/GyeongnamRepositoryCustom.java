package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongnamRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GyeongnamDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GyeongnamDto;

import java.util.List;

public interface GyeongnamRepositoryCustom {

    List<Integer> countGyeongnamDefCnt();

    List<Integer> countGyeongnamDeathCnt();

    List<Integer> countGyeongnamIncdec();

    List<Integer> countGyeongnamOverflowCnt();

    List<GyeongnamDefCountAndGubunDto> getDefCountAndGubunGyeongnam(DateDto date);

    List<GyeongnamDto> getAllCountGyeongnam(DateDto date);
}
