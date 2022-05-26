package project_publicdata.web_project_publicdata.repository.sidoRepository.lazarettoRepository;

import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.LazarettoDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.LazarettoDto;

import java.util.List;

public interface LazarettoRepositoryCustom {

    List<Integer> countLazarettoDefCnt();

    List<Integer> countLazarettoDeathCnt();

    List<Integer> countLazarettoIncdec();

    List<Integer> countLazarettoOverflowCnt();

    List<LazarettoDefCountAndGubunDto> getDefCountAndGubunLazaretto(DateDto date);

    List<LazarettoDto> getAllCountLazaretto(DateDto date);
}
