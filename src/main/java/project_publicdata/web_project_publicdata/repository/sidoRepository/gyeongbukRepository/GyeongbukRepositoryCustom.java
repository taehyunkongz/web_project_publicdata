package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongbukRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GyeongbukDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GyeongbukDto;

import java.util.List;

public interface GyeongbukRepositoryCustom {

    List<Integer> countGyeongbukDefCnt();

    List<Integer> countGyeongbukDeathCnt();

    List<Integer> countGyeongbukIncdec();

    List<Integer> countGyeongbukOverflowCnt();

    List<GyeongbukDefCountAndGubunDto> getDefCountAndGubunGyeongbuk(DateDto date);

    List<GyeongbukDto> getAllCountGyeongbuk(DateDto date);
}
