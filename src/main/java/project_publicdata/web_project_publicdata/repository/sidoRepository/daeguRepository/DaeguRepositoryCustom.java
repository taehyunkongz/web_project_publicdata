package project_publicdata.web_project_publicdata.repository.sidoRepository.daeguRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.DaeguDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.DaeguDto;

import java.util.List;

public interface DaeguRepositoryCustom {

    List<Integer> countDaeguDefCnt();

    List<Integer> countDaeguDeathCnt();

    List<Integer> countDaeguIncdec();

    List<Integer> countDaeguOverflowCnt();

    List<DaeguDefCountAndGubunDto> getDefCountAndGubunDaegu(DateDto date);

    List<DaeguDto> getAllCountDaegu(DateDto date);

}

