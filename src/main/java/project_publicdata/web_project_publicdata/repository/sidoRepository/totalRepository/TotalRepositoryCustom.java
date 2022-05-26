package project_publicdata.web_project_publicdata.repository.sidoRepository.totalRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.TotalDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.TotalDto;

import java.util.List;

public interface TotalRepositoryCustom {

    List<Integer> countTotalDefCnt();

    List<Integer> countTotalDeathCnt();

    List<Integer> countTotalIncdec();

    List<Integer> countTotalOverflowCnt();

    List<TotalDefCountAndGubunDto> getDefCountAndGubunTotal(DateDto date);

    List<TotalDto> getAllCountTotal(DateDto date);
}
