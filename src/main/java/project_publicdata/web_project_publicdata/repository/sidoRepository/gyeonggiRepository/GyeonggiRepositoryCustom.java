package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeonggiRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GyeonggiDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GyeonggiDto;

import java.util.List;

public interface GyeonggiRepositoryCustom {

    List<Integer> countGyeonggiDefCnt();

    List<Integer> countGyeonggiDeathCnt();

    List<Integer> countGyeonggiIncdec();

    List<Integer> countGyeonggiOverflowCnt();

    List<GyeonggiDefCountAndGubunDto> getDefCountAndGubunGyeonggi(DateDto date);

    List<GyeonggiDto> getAllCountGyeonggi(DateDto date);
}
