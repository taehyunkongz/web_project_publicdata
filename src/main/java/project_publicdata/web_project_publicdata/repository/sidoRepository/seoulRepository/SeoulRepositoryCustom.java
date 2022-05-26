package project_publicdata.web_project_publicdata.repository.sidoRepository.seoulRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.SeoulDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.SeoulDto;

import java.util.List;

public interface SeoulRepositoryCustom {

    List<Integer> countSeoulDefCnt();

    List<Integer> countSeoulDeathCnt();

    List<Integer> countSeoulIncdec();

    List<Integer> countSeoulOverflowCnt();

    List<SeoulDefCountAndGubunDto> getDefCountAndGubunSeoul(DateDto date);

    List<SeoulDto> getAllCountSeoul(DateDto date);
}
