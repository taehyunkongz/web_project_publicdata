package project_publicdata.web_project_publicdata.repository.sidoRepository.busanRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.BusanDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.BusanDto;

import java.util.List;


public interface BusanRepositoryCustom {

    List<Integer> countBusanDefcnt(); // 확진자 수

    List<Integer> countBusanDeathcnt(); // 사망자수

    List<Integer> countBusanIncDec(); // 전일대비 증감수

    List<Integer> countBusanOverflowCnt(); // 해외 유입수

    List<BusanDefCountAndGubunDto> getDefCountAndGubunBusan(DateDto date); // 지역발생 수

    List<BusanDto> getAllCountBusan(DateDto date); // 지역발생 수

}





