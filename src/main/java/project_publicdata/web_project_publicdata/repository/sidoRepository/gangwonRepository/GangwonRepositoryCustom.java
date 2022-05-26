package project_publicdata.web_project_publicdata.repository.sidoRepository.gangwonRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GangwonDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GangwonDto;

import java.util.List;

public interface GangwonRepositoryCustom {

    List<Integer> countGanwonDefCnt();

    List<Integer> countGangwonDeathCnt();

    List<Integer> countGangwonIncdec();

    List<Integer> countGangwonOverflowCnt();

    List<GangwonDefCountAndGubunDto> getDefCountAndGubunGangwon(DateDto date);

    List<GangwonDto> getAllCountGangwon(DateDto date);
}
