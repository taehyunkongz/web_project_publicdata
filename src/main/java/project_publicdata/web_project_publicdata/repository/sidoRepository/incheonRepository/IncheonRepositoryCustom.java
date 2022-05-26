package project_publicdata.web_project_publicdata.repository.sidoRepository.incheonRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.IncheonDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.IncheonDto;

import java.util.List;

public interface IncheonRepositoryCustom {

    List<Integer> countIncheonDefCnt();

    List<Integer> countIncheonDeathCnt();

    List<Integer> countIncheonIncdec();

    List<Integer> countIncheonOverflowCnt();

    List<IncheonDefCountAndGubunDto> getDefCountAndGubunIncheon(DateDto date);

    List<IncheonDto> getAllCountIncheon(DateDto date);
}
