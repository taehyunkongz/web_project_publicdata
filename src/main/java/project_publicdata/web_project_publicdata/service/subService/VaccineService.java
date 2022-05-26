package project_publicdata.web_project_publicdata.service.subService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.TotalVaccineCountDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.*;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineBusanRepository.VaccineBusanRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungbukRepository.VaccineChungbukRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungnamRepository.VaccineChungnamRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaeguRepository.VaccineDaeguRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaejeonRepository.VaccineDaejeonRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGangwonRepository.VaccineGangwonRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGwangjuRepository.VaccineGwangjuRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongbukRepository.VaccineGyeongbukRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeonggiRepository.VaccineGyeonggiRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongnamRepository.VaccineGyeongnamRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineIncheonRepository.VaccineIncheonRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJejuRepository.VaccineJejuRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonbukRepository.VaccineJeonbukRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonnamRepository.VaccineJeonnamRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSejongRepository.VaccineSejongRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSeoulRepository.VaccineSeoulRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineTotalRepository.VaccineTotalRepository;
import project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineUlsanRepository.VaccineUlsanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VaccineService {

    private final VaccineBusanRepository vaccineBusanRepository;

    private final VaccineChungbukRepository vaccineChungbukRepository;

    private final VaccineChungnamRepository vaccineChungnamRepository;

    private final VaccineDaeguRepository vaccineDaeguRepository;

    private final VaccineDaejeonRepository vaccineDaejeonRepository;

    private final VaccineGangwonRepository vaccineGangwonRepository;

    private final VaccineGwangjuRepository vaccineGwangjuRepository;

    private final VaccineGyeongbukRepository vaccineGyeongbukRepository;

    private final VaccineGyeonggiRepository vaccineGyeonggiRepository;

    private final VaccineGyeongnamRepository vaccineGyeongnamRepository;

    private final VaccineIncheonRepository vaccineIncheonRepository;

    private final VaccineJejuRepository vaccineJejuRepository;

    private final VaccineJeonbukRepository vaccineJeonbukRepository;

    private final VaccineJeonnamRepository vaccineJeonnamRepository;

    private final VaccineSejongRepository vaccineSejongRepository;

    private final VaccineSeoulRepository vaccineSeoulRepository;

    private final VaccineTotalRepository vaccineTotalRepository;

    private final VaccineUlsanRepository vaccineUlsanRepository;

    public List<VaccineBusanDto> getAllVaccineCountBusan(DateDto dateDto) {
        return vaccineBusanRepository.getAllVaccineCountBusan(dateDto);
    }

    public List<VaccineChungbukDto> getAllVaccineCountChungbuk(DateDto dateDto) {
        return vaccineChungbukRepository.getAllVaccineCountChungbuk(dateDto);
    }

    public List<VaccineChungnamDto> getAllVaccineCountChungnam(DateDto dateDto) {
        return vaccineChungnamRepository.getAllVaccineCountChungnam(dateDto);
    }

    public List<VaccineDaeguDto> getAllVaccineCountDaegu(DateDto dateDto) {
        return vaccineDaeguRepository.getAllVaccineCountDaegu(dateDto);
    }

    public List<VaccineDaejeonDto> getAllVaccineCountDaejeon(DateDto dateDto) {
        return vaccineDaejeonRepository.getAllVaccineCountDaejeon(dateDto);
    }

    public List<VaccineGangwonDto> getAllVaccineCountGangwon(DateDto dateDto) {
        return vaccineGangwonRepository.getAllVaccineCountGangwon(dateDto);
    }

    public List<VaccineGwangjuDto> getAllVaccineCountGwangju(DateDto dateDto) {
        return vaccineGwangjuRepository.getAllVaccineCountGwangju(dateDto);
    }

    public List<VaccineGyeongbukDto> getAllVaccineCountGyeongbuk(DateDto dateDto) {
        return vaccineGyeongbukRepository.getAllVaccineCountGyeongbuk(dateDto);
    }

    public List<VaccineGyeonggiDto> getAllVaccineCountGyeonggi(DateDto dateDto) {
        return vaccineGyeonggiRepository.getAllVaccineCountGyeonggi(dateDto);
    }

    public List<VaccineGyeongnamDto> getAllVaccineCountGyeongnam(DateDto dateDto) {
        return vaccineGyeongnamRepository.getAllVaccineCountGyeongnam(dateDto);
    }

    public List<VaccineIncheonDto> getAllVaccineCountIncheon(DateDto dateDto) {
        return vaccineIncheonRepository.getAllVaccineCountIncheon(dateDto);
    }

    public List<VaccineJejuDto> getAllVaccineCountJeju(DateDto dateDto) {
        return vaccineJejuRepository.getAllVaccineCountJeju(dateDto);
    }

    public List<VaccineJeonbukDto> getAllVaccineCountJeonbuk(DateDto dateDto) {
        return vaccineJeonbukRepository.getAllVaccineCountJeonbuk(dateDto);
    }

    public List<VaccineJeonnamDto> getAllVaccineCountJeonnam(DateDto dateDto) {
        return vaccineJeonnamRepository.getAllVaccineCountJeonnam(dateDto);
    }

    public List<VaccineSejongDto> getAllVaccineCountSejong(DateDto dateDto) {
        return vaccineSejongRepository.getAllVaccineCountSejong(dateDto);
    }

    public List<VaccineSeoulDto> getAllVaccineCountSeoul(DateDto dateDto) {
        return vaccineSeoulRepository.getAllVaccineCountSeoul(dateDto);
    }

    public List<VaccineTotalDto> getAllVaccineCountTotal(DateDto dateDto) {
        return vaccineTotalRepository.getAllVaccineCountTotal(dateDto);
    }

    public List<VaccineUlsanDto> getAllVaccineCountUlsan(DateDto dateDto) {
        return vaccineUlsanRepository.getAllVaccineCountUlsan(dateDto);
    }

    public List<TotalVaccineCountDto> getTotalVaccineCount(DateDto dateDto) {
        return vaccineTotalRepository.getTotalVaccineCount(dateDto);
    }

}
