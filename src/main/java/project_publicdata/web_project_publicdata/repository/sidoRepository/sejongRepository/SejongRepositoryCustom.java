package project_publicdata.web_project_publicdata.repository.sidoRepository.sejongRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.SejongDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.SejongDto;

import java.util.List;

public interface SejongRepositoryCustom {

    List<Integer> countSejongDefCnt();

    List<Integer> countSejongDeathCnt();

    List<Integer> countSejongIncdec();

    List<Integer> countSejongOverflowCnt();

    List<SejongDefCountAndGubunDto> getDefCountAndGubunSejong(DateDto date);

    List<SejongDto> getAllCountSejong(DateDto date);
}
