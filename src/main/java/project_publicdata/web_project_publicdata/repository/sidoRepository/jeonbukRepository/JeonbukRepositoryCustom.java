package project_publicdata.web_project_publicdata.repository.sidoRepository.jeonbukRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.JeonbukDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.JeonbukDto;

import java.util.List;

public interface JeonbukRepositoryCustom {

    List<Integer> countJeonbukDefCnt();

    List<Integer> countJeonbukDeathCnt();

    List<Integer> countJeonbukIncdec();

    List<Integer> countJeonbukOverflowCnt();

    List<JeonbukDefCountAndGubunDto> getDefCountAndGubunJeonbuk(DateDto date);

    List<JeonbukDto> getAllCountJeonbuk(DateDto date);
}
