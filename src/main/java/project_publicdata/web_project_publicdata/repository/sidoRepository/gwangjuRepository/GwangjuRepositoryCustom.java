package project_publicdata.web_project_publicdata.repository.sidoRepository.gwangjuRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GwangjuDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GwangjuDto;

import java.util.List;

public interface GwangjuRepositoryCustom {

    List<Integer> countGwangjuDefCnt();

    List<Integer> countGwangjuDeathCnt();

    List<Integer> countGwangjuIncdec();

    List<Integer> countGwangjuOverflowCnt();

    List<GwangjuDefCountAndGubunDto> getDefCountAndGubunGwangju(DateDto date);

    List<GwangjuDto> getAllCountGwangju(DateDto date);

}
