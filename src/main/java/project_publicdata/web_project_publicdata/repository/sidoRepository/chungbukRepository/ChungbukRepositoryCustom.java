package project_publicdata.web_project_publicdata.repository.sidoRepository.chungbukRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.ChungbukDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.ChungbukDto;

import java.util.List;

public interface ChungbukRepositoryCustom {

    List<Integer> countChungbukDefCnt();

    List<Integer> countChungbukdeathCnt();

    List<Integer> countChungbukIncDec();

    List<Integer> countChungbukoverFlowCnt();

    List<ChungbukDefCountAndGubunDto> getDefCountAndGubunChungbuk(DateDto date);

    List<ChungbukDto> getAllCountChungbuk(DateDto date);




}
