package project_publicdata.web_project_publicdata.repository.sidoRepository.daejeonRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.DaejeonDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.DaejeonDto;

import java.util.List;

public interface DaejeonRepositoryCustom {

    List<Integer> countDaejeonDefCnt();

    List<Integer> countDaejeonDeathCnt();

    List<Integer> countDaejeonIncdec();

    List<Integer> countDaejeonOverflowCnt();

    List<DaejeonDefCountAndGubunDto> getDefCountAndGubunDaejeon(DateDto date);

    List<DaejeonDto> getAllCountDaejeon(DateDto date);

}
