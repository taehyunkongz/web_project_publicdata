package project_publicdata.web_project_publicdata.service.subService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.FemaleDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.MaleDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.*;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.eightySRepository.EightySRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.femaleRepository.FemaleRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fiftySRepository.FiftySRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fortySRepository.FortySRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.kidsRepository.KidsRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.maleRepository.MaleRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.seventySRepository.SeventySRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.sixtySRepository.SixtySRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.teenagersRepository.TeenagersRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.thirtySRepository.ThirtySRepository;
import project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.twentySRepository.TwentySRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenderAndAgeService {

    private final EightySRepository eightySRepository;

    private final FiftySRepository fiftySRepository;

    private final FortySRepository fortySRepository;

    private final KidsRepository kidsRepository;

    private final SeventySRepository seventySRepository;

    private final SixtySRepository sixtySRepository;

    private final TeenagersRepository teenagersRepository;

    private final ThirtySRepository thirtySRepository;

    private final TwentySRepository twentySRepository;

    private final FemaleRepository femaleRepository;

    private final MaleRepository maleRepository;

    public List<EightySDto> getAllCountEightyS(DateDto dateDto) {
        return eightySRepository.getAllCountEightyS(dateDto);
    }

    public List<FiftySDto> getAllCountFiftyS(DateDto dateDto) {
        return fiftySRepository.getAllCountFiftyS(dateDto);
    }

    public List<FortySDto> getAllCountFortyS(DateDto dateDto) {
        return fortySRepository.getAllCountFortyS(dateDto);
    }

    public List<KidsDto> getAllCountKids(DateDto dateDto) {
        return kidsRepository.getAllCountKids(dateDto);
    }

    public List<SeventySDto> getAllCountSeventyS(DateDto dateDto) {
        return seventySRepository.getAllCountSeventyS(dateDto);
    }

    public List<SixtySDto> getAllCountSixtyS(DateDto dateDto) {
        return sixtySRepository.getAllCountSixtyS(dateDto);
    }

    public List<TeenagersDto> getAllCountTeenagers(DateDto dateDto) {
        return teenagersRepository.getAllCountTeenagers(dateDto);
    }

    public List<ThirtySDto> getAllCountThrityS(DateDto dateDto) {
        return thirtySRepository.getAllCountThirtyS(dateDto);
    }

    public List<TwentySDto> getAllCountTwentyS(DateDto dateDto) {
        return twentySRepository.getAllCountTwentyS(dateDto);
    }

    public List<FemaleDto> getAllCountFemale(DateDto dateDto) {
        return femaleRepository.getAllCountFemale(dateDto);
    }

    public List<MaleDto> getAllcountMale(DateDto dateDto) {
        return maleRepository.getAllCountMale(dateDto);
    }
}
