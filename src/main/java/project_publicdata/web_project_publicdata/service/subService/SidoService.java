package project_publicdata.web_project_publicdata.service.subService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.*;
import project_publicdata.web_project_publicdata.dto.sidoDto.*;
import project_publicdata.web_project_publicdata.repository.sidoRepository.busanRepository.BusanRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.chungbukRepository.ChungbukRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.chungnamRepository.ChungnamRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.daeguRepository.DaeguRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.daejeonRepository.DaejeonRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.gangwonRepository.GangwonRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.gwangjuRepository.GwangjuRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongbukRepository.GyeongbukRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.gyeonggiRepository.GyeonggiRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongnamRepository.GyeongnamRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.incheonRepository.IncheonRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.jejuRepository.JejuRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.jeonbukRepository.JeonbukRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.jeonnamRepository.JeonnamRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.lazarettoRepository.LazarettoRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.sejongRepository.SejongRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.seoulRepository.SeoulRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.totalRepository.TotalRepository;
import project_publicdata.web_project_publicdata.repository.sidoRepository.ulsanRepository.UlsanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SidoService {

    private final BusanRepository busanRepository;

    private final ChungbukRepository chungbukRepository;

    private final ChungnamRepository chungnamRepository;

    private final DaeguRepository daeguRepository;

    private final DaejeonRepository daejeonRepository;

    private final GangwonRepository gangwonRepository;

    private final GwangjuRepository gwangjuRepository;

    private final GyeongbukRepository gyeongbukRepository;

    private final GyeonggiRepository gyeonggiRepository;

    private final GyeongnamRepository gyeongnamRepository;

    private final IncheonRepository incheonRepository;

    private final JejuRepository jejuRepository;

    private final JeonbukRepository jeonbukRepository;

    private final JeonnamRepository jeonnamRepository;

    private final LazarettoRepository lazarettoRepository;

    private final SejongRepository sejongRepository;

    private final SeoulRepository seoulRepository;

    private final TotalRepository totalRepository;

    private final UlsanRepository ulsanRepository;

    public List<BusanDto> getAllCountBusan(DateDto dateDto) {
        return busanRepository.getAllCountBusan(dateDto);
    }

    public List<ChungbukDto> getAllCountChungbuk(DateDto dateDto) {
        return chungbukRepository.getAllCountChungbuk(dateDto);
    }

    public List<ChungnamDto> getAllCountChungnam(DateDto dateDto) {
        return chungnamRepository.getAllCountChungnam(dateDto);
    }

    public List<DaeguDto> getAllCountDaegu(DateDto dateDto) {
        return daeguRepository.getAllCountDaegu(dateDto);
    }

    public List<DaejeonDto> getAllCountDaeJeon(DateDto dateDto) {
        return daejeonRepository.getAllCountDaejeon(dateDto);
    }

    public List<GangwonDto> getAllCountGangwon(DateDto dateDto) {
        return gangwonRepository.getAllCountGangwon(dateDto);
    }

    public List<GwangjuDto> getAllCountGwangju(DateDto dateDto) {
        return gwangjuRepository.getAllCountGwangju(dateDto);
    }

    public List<GyeongbukDto> getAllCountGyeongbuk(DateDto dateDto) {
        return gyeongbukRepository.getAllCountGyeongbuk(dateDto);
    }

    public List<GyeonggiDto> getAllCountGyeonggi(DateDto dateDto) {
        return gyeonggiRepository.getAllCountGyeonggi(dateDto);
    }

    public List<GyeongnamDto> getAllCountGyeongnam(DateDto dateDto) {
        return gyeongnamRepository.getAllCountGyeongnam(dateDto);
    }

    public List<IncheonDto> getAllCountIncheon(DateDto dateDto) {
        return incheonRepository.getAllCountIncheon(dateDto);
    }

    public List<JejuDto> getAllCountJeju(DateDto dateDto) {
        return jejuRepository.getAllCountJeju(dateDto);
    }

    public List<JeonbukDto> getAllCountJeonbuk(DateDto dateDto) {
        return jeonbukRepository.getAllCountJeonbuk(dateDto);
    }

    public List<JeonnamDto> getAllCountJeonnam(DateDto dateDto) {
        return jeonnamRepository.getAllCountJeonnam(dateDto);
    }

    public List<LazarettoDto> getAllCountLazaretto(DateDto dateDto) {
        return lazarettoRepository.getAllCountLazaretto(dateDto);
    }

    public List<SejongDto> getAllCountSejong(DateDto dateDto) {
        return sejongRepository.getAllCountSejong(dateDto);
    }

    public List<SeoulDto> getAllCountSeoul(DateDto dateDto) {
        return seoulRepository.getAllCountSeoul(dateDto);
    }

    public List<TotalDto> getAllCountTotal(DateDto dateDto) {
        return totalRepository.getAllCountTotal(dateDto);
    }

    public List<UlsanDto> getAllCountUlsan(DateDto dateDto) {
        return ulsanRepository.getAllCountUlsan(dateDto);
    }

    public List<BusanDefCountAndGubunDto> getDefCountAndGubunBusan(DateDto dateDto) {
        return busanRepository.getDefCountAndGubunBusan(dateDto);
    }

    public List<ChungbukDefCountAndGubunDto> getDefCountAndGubunChungbuk(DateDto dateDto) {
        return chungbukRepository.getDefCountAndGubunChungbuk(dateDto);
    }

    public List<ChungnamDefCountAndGubunDto> getDefCountAndGubunChungnam(DateDto dateDto) {
        return chungnamRepository.getDefCountAndGubunChungnam(dateDto);
    }

    public List<DaeguDefCountAndGubunDto> getDefCountAndGubunDaegu(DateDto dateDto) {
        return daeguRepository.getDefCountAndGubunDaegu(dateDto);
    }

    public List<DaejeonDefCountAndGubunDto> getDefCountAndGubunDaejeon(DateDto dateDto) {
        return daejeonRepository.getDefCountAndGubunDaejeon(dateDto);
    }

    public List<GangwonDefCountAndGubunDto> getDefCountAndGubunGangwon(DateDto dateDto) {
        return gangwonRepository.getDefCountAndGubunGangwon(dateDto);
    }

    public List<GwangjuDefCountAndGubunDto> getDefCountAndGubunGwangju(DateDto dateDto) {
        return gwangjuRepository.getDefCountAndGubunGwangju(dateDto);
    }

    public List<GyeongbukDefCountAndGubunDto> getDefCountAndGubunGyeongbuk(DateDto dateDto) {
        return gyeongbukRepository.getDefCountAndGubunGyeongbuk(dateDto);
    }

    public List<GyeonggiDefCountAndGubunDto> getDefCountAndGubunGyeonggi(DateDto dateDto) {
        return gyeonggiRepository.getDefCountAndGubunGyeonggi(dateDto);
    }

    public List<GyeongnamDefCountAndGubunDto> getDefCountAndGubunGyeongnam(DateDto dateDto) {
        return gyeongnamRepository.getDefCountAndGubunGyeongnam(dateDto);
    }

    public List<IncheonDefCountAndGubunDto> getDefCountAndGubunIncheon(DateDto dateDto) {
        return incheonRepository.getDefCountAndGubunIncheon(dateDto);
    }

    public List<JejuDefCountAndGubunDto> getDefCountAndGubunJeju(DateDto dateDto) {
        return jejuRepository.getDefCountAndGubunJeju(dateDto);
    }

    public List<JeonbukDefCountAndGubunDto> getDefCountAndGubunJeonbuk(DateDto dateDto) {
        return jeonbukRepository.getDefCountAndGubunJeonbuk(dateDto);
    }

    public List<JeonnamDefCountAndGubunDto> getDefCountAndGubunJeonnam(DateDto dateDto) {
        return jeonnamRepository.getDefCountAndGubunJeonnam(dateDto);
    }

    public List<LazarettoDefCountAndGubunDto> getDefCountAndGubunLazaretto(DateDto dateDto) {
        return lazarettoRepository.getDefCountAndGubunLazaretto(dateDto);
    }

    public List<SejongDefCountAndGubunDto> getDefCountAndGubunSejong(DateDto dateDto) {
        return sejongRepository.getDefCountAndGubunSejong(dateDto);
    }

    public List<SeoulDefCountAndGubunDto> getDefCountAndGubunSeoul(DateDto dateDto) {
        return seoulRepository.getDefCountAndGubunSeoul(dateDto);
    }

    public List<TotalDefCountAndGubunDto> getDefCountAndGubunTotal(DateDto dateDto) {
        return totalRepository.getDefCountAndGubunTotal(dateDto);
    }

    public List<UlsanDefCountAndGubunDto> getDefCountAndGubunUlsan(DateDto dateDto) {
        return ulsanRepository.getDefCountAndGubunUlsan(dateDto);
    }








}
