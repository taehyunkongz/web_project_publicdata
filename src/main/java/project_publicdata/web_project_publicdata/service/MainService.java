package project_publicdata.web_project_publicdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.RenderingSubDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.FemaleDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.MaleDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.*;
import project_publicdata.web_project_publicdata.dto.renderingDto.RenderingGenderAndAgeDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.RenderingSidoDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.RenderingVaccineDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.*;
import project_publicdata.web_project_publicdata.dto.vaccineDto.*;
import project_publicdata.web_project_publicdata.service.subService.GenderAndAgeService;
import project_publicdata.web_project_publicdata.service.subService.SidoService;
import project_publicdata.web_project_publicdata.service.subService.VaccineService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final SidoService sidoService;

    private final VaccineService vaccineService;

    private final GenderAndAgeService genderAndAgeService;

    public RenderingSidoDto setRenderingSidoData(DateDto dateDto) {
        return new RenderingSidoDto(
                getBusanDto(dateDto),
                getChungbukDto(dateDto),
                getChungnamDto(dateDto),
                getDaeguDto(dateDto),
                getDaejeonDto(dateDto),
                getGangwonDto(dateDto),
                getGwangjuDto(dateDto),
                getGyeongbukDto(dateDto),
                getGyeonggiDto(dateDto),
                getGyeongnamDto(dateDto),
                getIncheonDto(dateDto),
                getJejuDto(dateDto),
                getJeonbukDto(dateDto),
                getJeonnamDto(dateDto),
                getLazarettoDto(dateDto),
                getSejongDto(dateDto),
                getSeoulDto(dateDto),
                getTotalDto(dateDto),
                getUlsanDto(dateDto));
    }

    private UlsanDto getUlsanDto(DateDto dateDto) {
        return sidoService.getAllCountUlsan(dateDto).get(0);
    }

    private TotalDto getTotalDto(DateDto dateDto) {
        return sidoService.getAllCountTotal(dateDto).get(0);
    }

    private SeoulDto getSeoulDto(DateDto dateDto) {
        return sidoService.getAllCountSeoul(dateDto).get(0);
    }

    private SejongDto getSejongDto(DateDto dateDto) {
        return sidoService.getAllCountSejong(dateDto).get(0);
    }

    private LazarettoDto getLazarettoDto(DateDto dateDto) {
        return sidoService.getAllCountLazaretto(dateDto).get(0);
    }

    private JeonnamDto getJeonnamDto(DateDto dateDto) {
        return sidoService.getAllCountJeonnam(dateDto).get(0);
    }

    private JeonbukDto getJeonbukDto(DateDto dateDto) {
        return sidoService.getAllCountJeonbuk(dateDto).get(0);
    }

    private JejuDto getJejuDto(DateDto dateDto) {
        return sidoService.getAllCountJeju(dateDto).get(0);
    }

    private IncheonDto getIncheonDto(DateDto dateDto) {
        return sidoService.getAllCountIncheon(dateDto).get(0);
    }

    private GyeongnamDto getGyeongnamDto(DateDto dateDto) {
        return sidoService.getAllCountGyeongnam(dateDto).get(0);
    }

    private GyeonggiDto getGyeonggiDto(DateDto dateDto) {
        return sidoService.getAllCountGyeonggi(dateDto).get(0);
    }

    private GyeongbukDto getGyeongbukDto(DateDto dateDto) {
        return sidoService.getAllCountGyeongbuk(dateDto).get(0);
    }

    private GwangjuDto getGwangjuDto(DateDto dateDto) {
        return sidoService.getAllCountGwangju(dateDto).get(0);
    }

    private GangwonDto getGangwonDto(DateDto dateDto) {
        return sidoService.getAllCountGangwon(dateDto).get(0);
    }

    private DaejeonDto getDaejeonDto(DateDto dateDto) {
        return sidoService.getAllCountDaeJeon(dateDto).get(0);
    }

    private DaeguDto getDaeguDto(DateDto dateDto) {
        return sidoService.getAllCountDaegu(dateDto).get(0);
    }

    private ChungnamDto getChungnamDto(DateDto dateDto) {
        return sidoService.getAllCountChungnam(dateDto).get(0);
    }

    private ChungbukDto getChungbukDto(DateDto dateDto) {
        return sidoService.getAllCountChungbuk(dateDto).get(0);
    }

    private BusanDto getBusanDto(DateDto dateDto) {
        return sidoService.getAllCountBusan(dateDto).get(0);
    }

    public RenderingVaccineDto setRenderingVaccineData(DateDto dateDto) {
        return new RenderingVaccineDto(
                getVaccineBusanDto(dateDto),
                getVaccineChungbukDto(dateDto),
                getVaccineChungnamDto(dateDto),
                getVaccineDaeguDto(dateDto),
                getVaccineDaejeonDto(dateDto),
                getVaccineGangwonDto(dateDto),
                getVaccineGwangjuDto(dateDto),
                getVaccineGyeongbukDto(dateDto),
                getVaccineGyeonggiDto(dateDto),
                getVaccineGyeongnamDto(dateDto),
                getVaccineIncheonDto(dateDto),
                getVaccineJejuDto(dateDto),
                getVaccineJeonbukDto(dateDto),
                getVaccineJeonnamDto(dateDto),
                getVaccineSejongDto(dateDto),
                getVaccineSeoulDto(dateDto),
                getVaccineTotalDto(dateDto),
                getVaccineUlsanDto(dateDto)
        );
    }

    private VaccineUlsanDto getVaccineUlsanDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountUlsan(dateDto).get(0);
    }

    private VaccineTotalDto getVaccineTotalDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountTotal(dateDto).get(0);
    }

    private VaccineSeoulDto getVaccineSeoulDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountSeoul(dateDto).get(0);
    }

    private VaccineSejongDto getVaccineSejongDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountSejong(dateDto).get(0);
    }

    private VaccineJeonnamDto getVaccineJeonnamDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountJeonnam(dateDto).get(0);
    }

    private VaccineJeonbukDto getVaccineJeonbukDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountJeonbuk(dateDto).get(0);
    }

    private VaccineJejuDto getVaccineJejuDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountJeju(dateDto).get(0);
    }

    private VaccineIncheonDto getVaccineIncheonDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountIncheon(dateDto).get(0);
    }

    private VaccineGyeongnamDto getVaccineGyeongnamDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountGyeongnam(dateDto).get(0);
    }

    private VaccineGyeonggiDto getVaccineGyeonggiDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountGyeonggi(dateDto).get(0);
    }

    private VaccineGyeongbukDto getVaccineGyeongbukDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountGyeongbuk(dateDto).get(0);
    }

    private VaccineGwangjuDto getVaccineGwangjuDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountGwangju(dateDto).get(0);
    }

    private VaccineGangwonDto getVaccineGangwonDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountGangwon(dateDto).get(0);
    }

    private VaccineDaejeonDto getVaccineDaejeonDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountDaejeon(dateDto).get(0);
    }

    private VaccineDaeguDto getVaccineDaeguDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountDaegu(dateDto).get(0);
    }

    private VaccineChungnamDto getVaccineChungnamDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountChungnam(dateDto).get(0);
    }

    private VaccineChungbukDto getVaccineChungbukDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountChungbuk(dateDto).get(0);
    }

    private VaccineBusanDto getVaccineBusanDto(DateDto dateDto) {
        return vaccineService.getAllVaccineCountBusan(dateDto).get(0);
    }

    public RenderingGenderAndAgeDto setRenderingGenderAndAgeData(DateDto dateDto) {
        return new RenderingGenderAndAgeDto(
                getEightySDto(dateDto),
                getFiftySDto(dateDto),
                getFortySDto(dateDto),
                getKidsDto(dateDto),
                getSeventySDto(dateDto),
                getSixtySDto(dateDto),
                getTeenagersDto(dateDto),
                getThirtySDto(dateDto),
                getTwentySDto(dateDto),
                getFemaleDto(dateDto),
                getMaleDto(dateDto)
        );
    }

    private MaleDto getMaleDto(DateDto dateDto) {
        return genderAndAgeService.getAllcountMale(dateDto).get(0);
    }

    private FemaleDto getFemaleDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountFemale(dateDto).get(0);
    }

    private TwentySDto getTwentySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountTwentyS(dateDto).get(0);
    }

    private ThirtySDto getThirtySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountThrityS(dateDto).get(0);
    }

    private TeenagersDto getTeenagersDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountTeenagers(dateDto).get(0);
    }

    private SixtySDto getSixtySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountSixtyS(dateDto).get(0);
    }

    private SeventySDto getSeventySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountSeventyS(dateDto).get(0);
    }

    private KidsDto getKidsDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountKids(dateDto).get(0);
    }

    private FortySDto getFortySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountFortyS(dateDto).get(0);
    }

    private FiftySDto getFiftySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountFiftyS(dateDto).get(0);
    }

    private EightySDto getEightySDto(DateDto dateDto) {
        return genderAndAgeService.getAllCountEightyS(dateDto).get(0);
    }

    public int[] getDefCountArrBusan(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunBusan(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrChungbuk(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunChungbuk(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrChungnam(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunChungnam(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrDaegu(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunDaegu(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrDaejeon(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunDaejeon(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }
    public int[] getDefCountArrGangwon(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunGangwon(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }
    public int[] getDefCountArrGwangju(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunGwangju(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrGyeongbuk(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunGyeongbuk(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrGyeonggi(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunGyeonggi(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrGyeongnam(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunGyeongnam(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }
    public int[] getDefCountArrIncheon(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunIncheon(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrJeju(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunJeju(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrJeonbuk(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunJeonbuk(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }
    public int[] getDefCountArrJeonnam(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunJeonnam(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrLazaretto(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunLazaretto(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }
    public int[] getDefCountArrSejong(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunSejong(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrSeoul(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunSeoul(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrTotal(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getDefCountArrUlsan(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunUlsan(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }

        return arr;
    }

    public int[] getFifteenDaysOverFlowCountArrTotal(LocalDate localDate, int[] arr) {
        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate.minusDays(j))).get(0).getOverFlowCnt();
        }
        return arr;
    }

    public int[] getFifteenDaysLocalOccCountArrTotal(LocalDate localDate, int[] arr) {
        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate.minusDays(j))).get(0).getLocalOccCnt();
        }
        return arr;
    }

    public int[] getSixteenDaysDeathCountArrTotal(LocalDate localDate, int[] arr) {
        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate.minusDays(j))).get(0).getDeathCnt();
        }
        return arr;

    }

    public int[] getFifteenDaysIncDecCountArrTotal(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate.minusDays(j))).get(0).getIncDec();
        }
        return arr;
    }

    public int[] getFifteenDaysDefCntCountArrTotal(LocalDate localDate, int[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate.minusDays(j))).get(0).getDefCnt();
        }
        return arr;
    }

    public int[] getTotalThirdCountArr(LocalDate localDate, int[] arr) {
        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = vaccineService.getTotalVaccineCount(
                    localDateToDateDto(localDate.minusDays(j))).get(0).getThirdCnt();
        }
        return arr;
    }

    public int[] getTotalSecondCountArr(LocalDate localDate, int[] arr) {
        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = vaccineService.getTotalVaccineCount(
                    localDateToDateDto(localDate.minusDays(j))).get(0).getSecondCnt();
        }
        return arr;
    }

    public int[] getTotalFirstCountArr(LocalDate localDate, int[] arr) {
        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = vaccineService.getTotalVaccineCount(
                    localDateToDateDto(localDate.minusDays(j))).get(0).getFirstCnt();
        }
        return arr;
    }

    public RenderingSubDto getBusanSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                          RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                          LocalDate today) {
        String incDecCntSub = getValue(todaySido.getBusanDto().getIncDec(), yesterdaySido.getBusanDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getBusanDto().getLocalOccCnt(), yesterdaySido.getBusanDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getBusanDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getBusanDto().getOverFlowCnt(), yesterdaySido.getBusanDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getBusanDto().getDeathCnt(), yesterdaySido.getBusanDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }
    public RenderingSubDto getBusanSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido)
            {
        String incDecCntSub = getValue(todaySido.getBusanDto().getIncDec(), yesterdaySido.getBusanDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getBusanDto().getLocalOccCnt(), yesterdaySido.getBusanDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getBusanDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getBusanDto().getOverFlowCnt(), yesterdaySido.getBusanDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getBusanDto().getDeathCnt(), yesterdaySido.getBusanDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";



        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getChungnamSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                          RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                             LocalDate today) {
        String incDecCntSub = getValue(todaySido.getChungnamDto().getIncDec(), yesterdaySido.getChungnamDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getChungnamDto().getLocalOccCnt(), yesterdaySido.getChungnamDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getChungnamDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getChungnamDto().getOverFlowCnt(), yesterdaySido.getChungnamDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getChungnamDto().getDeathCnt(), yesterdaySido.getChungnamDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getChungnamSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getChungnamDto().getIncDec(), yesterdaySido.getChungnamDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getChungnamDto().getLocalOccCnt(), yesterdaySido.getChungnamDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getChungnamDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getChungnamDto().getOverFlowCnt(), yesterdaySido.getChungnamDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getChungnamDto().getDeathCnt(), yesterdaySido.getChungnamDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getChungbukSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                             RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                             LocalDate today) {
        String incDecCntSub = getValue(todaySido.getChungbukDto().getIncDec(), yesterdaySido.getChungbukDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getChungbukDto().getLocalOccCnt(), yesterdaySido.getChungbukDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getChungbukDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getChungbukDto().getOverFlowCnt(), yesterdaySido.getChungbukDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getChungbukDto().getDeathCnt(), yesterdaySido.getChungbukDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getChungbukSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getChungbukDto().getIncDec(), yesterdaySido.getChungbukDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getChungbukDto().getLocalOccCnt(), yesterdaySido.getChungbukDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getChungbukDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getChungbukDto().getOverFlowCnt(), yesterdaySido.getChungbukDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getChungbukDto().getDeathCnt(), yesterdaySido.getChungbukDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getDaeguSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                             RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                          LocalDate today) {
        String incDecCntSub = getValue(todaySido.getDaeguDto().getIncDec(), yesterdaySido.getDaeguDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getDaeguDto().getLocalOccCnt(), yesterdaySido.getDaeguDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getDaeguDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getDaeguDto().getOverFlowCnt(), yesterdaySido.getDaeguDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getDaeguDto().getDeathCnt(), yesterdaySido.getDaeguDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getDaeguSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getDaeguDto().getIncDec(), yesterdaySido.getDaeguDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getDaeguDto().getLocalOccCnt(), yesterdaySido.getDaeguDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getDaeguDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getDaeguDto().getOverFlowCnt(), yesterdaySido.getDaeguDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getDaeguDto().getDeathCnt(), yesterdaySido.getDaeguDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getDaejeonSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                          RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                            LocalDate today) {
        String incDecCntSub = getValue(todaySido.getDaejeonDto().getIncDec(), yesterdaySido.getDaejeonDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getDaejeonDto().getLocalOccCnt(), yesterdaySido.getDaejeonDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getDaejeonDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getDaejeonDto().getOverFlowCnt(), yesterdaySido.getDaejeonDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getDaejeonDto().getDeathCnt(), yesterdaySido.getDaejeonDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getDaejeonSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getDaejeonDto().getIncDec(), yesterdaySido.getDaejeonDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getDaejeonDto().getLocalOccCnt(), yesterdaySido.getDaejeonDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getDaejeonDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getDaejeonDto().getOverFlowCnt(), yesterdaySido.getDaejeonDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getDaejeonDto().getDeathCnt(), yesterdaySido.getDaejeonDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGangwonSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                            RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                            LocalDate today) {
        String incDecCntSub = getValue(todaySido.getGangwonDto().getIncDec(), yesterdaySido.getGangwonDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGangwonDto().getLocalOccCnt(), yesterdaySido.getGangwonDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGangwonDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGangwonDto().getOverFlowCnt(), yesterdaySido.getGangwonDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGangwonDto().getDeathCnt(), yesterdaySido.getGangwonDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGangwonSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getGangwonDto().getIncDec(), yesterdaySido.getGangwonDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGangwonDto().getLocalOccCnt(), yesterdaySido.getGangwonDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGangwonDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGangwonDto().getOverFlowCnt(), yesterdaySido.getGangwonDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGangwonDto().getDeathCnt(), yesterdaySido.getGangwonDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGwangjuSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                            RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                            LocalDate today) {
        String incDecCntSub = getValue(todaySido.getGwangjuDto().getIncDec(), yesterdaySido.getGwangjuDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGwangjuDto().getLocalOccCnt(), yesterdaySido.getGwangjuDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGwangjuDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGwangjuDto().getOverFlowCnt(), yesterdaySido.getGwangjuDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGwangjuDto().getDeathCnt(), yesterdaySido.getGwangjuDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGwangjuSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getGwangjuDto().getIncDec(), yesterdaySido.getGwangjuDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGwangjuDto().getLocalOccCnt(), yesterdaySido.getGwangjuDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGwangjuDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGwangjuDto().getOverFlowCnt(), yesterdaySido.getGwangjuDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGwangjuDto().getDeathCnt(), yesterdaySido.getGwangjuDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGyeongbukSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                            RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                              LocalDate today) {
        String incDecCntSub = getValue(todaySido.getGyeongbukDto().getIncDec(), yesterdaySido.getGyeongbukDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGyeongbukDto().getLocalOccCnt(), yesterdaySido.getGyeongbukDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGyeongbukDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGyeongbukDto().getOverFlowCnt(), yesterdaySido.getGyeongbukDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGyeongbukDto().getDeathCnt(), yesterdaySido.getGyeongbukDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGyeongbukSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getGyeongbukDto().getIncDec(), yesterdaySido.getGyeongbukDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGyeongbukDto().getLocalOccCnt(), yesterdaySido.getGyeongbukDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGyeongbukDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGyeongbukDto().getOverFlowCnt(), yesterdaySido.getGyeongbukDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGyeongbukDto().getDeathCnt(), yesterdaySido.getGyeongbukDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGyeonggiSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                              RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                             LocalDate today) {
        String incDecCntSub = getValue(todaySido.getGyeonggiDto().getIncDec(), yesterdaySido.getGyeonggiDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGyeonggiDto().getLocalOccCnt(), yesterdaySido.getGyeonggiDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGyeonggiDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGyeonggiDto().getOverFlowCnt(), yesterdaySido.getGyeonggiDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGyeonggiDto().getDeathCnt(), yesterdaySido.getGyeonggiDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGyeonggiSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getGyeonggiDto().getIncDec(), yesterdaySido.getGyeonggiDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGyeonggiDto().getLocalOccCnt(), yesterdaySido.getGyeonggiDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGyeonggiDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGyeonggiDto().getOverFlowCnt(), yesterdaySido.getGyeonggiDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGyeonggiDto().getDeathCnt(), yesterdaySido.getGyeonggiDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGyeongnamSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                             RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                              LocalDate today) {
        String incDecCntSub = getValue(todaySido.getGyeongnamDto().getIncDec(), yesterdaySido.getGyeongnamDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGyeongnamDto().getLocalOccCnt(), yesterdaySido.getGyeongnamDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGyeongnamDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGyeongnamDto().getOverFlowCnt(), yesterdaySido.getGyeongnamDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGyeongnamDto().getDeathCnt(), yesterdaySido.getGyeongnamDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getGyeongnamSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getGyeongnamDto().getIncDec(), yesterdaySido.getGyeongnamDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getGyeongnamDto().getLocalOccCnt(), yesterdaySido.getGyeongnamDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getGyeongnamDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getGyeongnamDto().getOverFlowCnt(), yesterdaySido.getGyeongnamDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getGyeongnamDto().getDeathCnt(), yesterdaySido.getGyeongnamDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getIncheonSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                              RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                            LocalDate today) {
        String incDecCntSub = getValue(todaySido.getIncheonDto().getIncDec(), yesterdaySido.getIncheonDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getIncheonDto().getLocalOccCnt(), yesterdaySido.getIncheonDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getIncheonDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getIncheonDto().getOverFlowCnt(), yesterdaySido.getIncheonDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getIncheonDto().getDeathCnt(), yesterdaySido.getIncheonDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getIncheonSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getIncheonDto().getIncDec(), yesterdaySido.getIncheonDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getIncheonDto().getLocalOccCnt(), yesterdaySido.getIncheonDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getIncheonDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getIncheonDto().getOverFlowCnt(), yesterdaySido.getIncheonDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getIncheonDto().getDeathCnt(), yesterdaySido.getIncheonDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getJejuSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                            RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                         LocalDate today) {
        String incDecCntSub = getValue(todaySido.getJejuDto().getIncDec(), yesterdaySido.getJejuDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getJejuDto().getLocalOccCnt(), yesterdaySido.getJejuDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getJejuDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getJejuDto().getOverFlowCnt(), yesterdaySido.getJejuDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getJejuDto().getDeathCnt(), yesterdaySido.getJejuDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))) {
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        } else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getJejuSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getJejuDto().getIncDec(), yesterdaySido.getJejuDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getJejuDto().getLocalOccCnt(), yesterdaySido.getJejuDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getJejuDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getJejuDto().getOverFlowCnt(), yesterdaySido.getJejuDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getJejuDto().getDeathCnt(), yesterdaySido.getJejuDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }
    public RenderingSubDto getJeonbukSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                         RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                            LocalDate today) {
        String incDecCntSub = getValue(todaySido.getJeonbukDto().getIncDec(), yesterdaySido.getJeonbukDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getJeonbukDto().getLocalOccCnt(), yesterdaySido.getJeonbukDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getJeonbukDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getJeonbukDto().getOverFlowCnt(), yesterdaySido.getJeonbukDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getJeonbukDto().getDeathCnt(), yesterdaySido.getJeonbukDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getJeonbukSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getJeonbukDto().getIncDec(), yesterdaySido.getJeonbukDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getJeonbukDto().getLocalOccCnt(), yesterdaySido.getJeonbukDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getJeonbukDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getJeonbukDto().getOverFlowCnt(), yesterdaySido.getJeonbukDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getJeonbukDto().getDeathCnt(), yesterdaySido.getJeonbukDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getJeonnamSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                            RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                            LocalDate today) {
        String incDecCntSub = getValue(todaySido.getJeonnamDto().getIncDec(), yesterdaySido.getJeonnamDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getJeonnamDto().getLocalOccCnt(), yesterdaySido.getJeonnamDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getJeonnamDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getJeonnamDto().getOverFlowCnt(), yesterdaySido.getJeonnamDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getJeonnamDto().getDeathCnt(), yesterdaySido.getJeonnamDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getJeonnamSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getJeonnamDto().getIncDec(), yesterdaySido.getJeonnamDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getJeonnamDto().getLocalOccCnt(), yesterdaySido.getJeonnamDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getJeonnamDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getJeonnamDto().getOverFlowCnt(), yesterdaySido.getJeonnamDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getJeonnamDto().getDeathCnt(), yesterdaySido.getJeonnamDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getLazarettoSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getLazarettoDto().getIncDec(), yesterdaySido.getLazarettoDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getLazarettoDto().getLocalOccCnt(), yesterdaySido.getLazarettoDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getLazarettoDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getLazarettoDto().getOverFlowCnt(), yesterdaySido.getLazarettoDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getLazarettoDto().getDeathCnt(), yesterdaySido.getLazarettoDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }
    public RenderingSubDto getLazarettoSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getLazarettoDto().getIncDec(), yesterdaySido.getLazarettoDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getLazarettoDto().getLocalOccCnt(), yesterdaySido.getLazarettoDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getLazarettoDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getLazarettoDto().getOverFlowCnt(), yesterdaySido.getLazarettoDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getLazarettoDto().getDeathCnt(), yesterdaySido.getLazarettoDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }


    public RenderingSubDto getSejongSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                            RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                           LocalDate today) {
        String incDecCntSub = getValue(todaySido.getSejongDto().getIncDec(), yesterdaySido.getSejongDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getSejongDto().getLocalOccCnt(), yesterdaySido.getSejongDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getSejongDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getSejongDto().getOverFlowCnt(), yesterdaySido.getSejongDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getSejongDto().getDeathCnt(), yesterdaySido.getSejongDto().getDeathCnt());
        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getSejongSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getSejongDto().getIncDec(), yesterdaySido.getSejongDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getSejongDto().getLocalOccCnt(), yesterdaySido.getSejongDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getSejongDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getSejongDto().getOverFlowCnt(), yesterdaySido.getSejongDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getSejongDto().getDeathCnt(), yesterdaySido.getSejongDto().getDeathCnt());

        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getSeoulSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                           RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                          LocalDate today) {
        String incDecCntSub = getValue(todaySido.getSeoulDto().getIncDec(), yesterdaySido.getSeoulDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getSeoulDto().getLocalOccCnt(), yesterdaySido.getSeoulDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getSeoulDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getSeoulDto().getOverFlowCnt(), yesterdaySido.getSeoulDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getSeoulDto().getDeathCnt(), yesterdaySido.getSeoulDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getSeoulSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getSeoulDto().getIncDec(), yesterdaySido.getSeoulDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getSeoulDto().getLocalOccCnt(), yesterdaySido.getSeoulDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getSeoulDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getSeoulDto().getOverFlowCnt(), yesterdaySido.getSeoulDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getSeoulDto().getDeathCnt(), yesterdaySido.getSeoulDto().getDeathCnt());


        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";


        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getUlsanSubDto1(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido,
                                          RenderingVaccineDto todayVaccine, RenderingVaccineDto yesterdayVaccine,
                                          LocalDate today) {
        String incDecCntSub = getValue(todaySido.getUlsanDto().getIncDec(), yesterdaySido.getUlsanDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getUlsanDto().getLocalOccCnt(), yesterdaySido.getUlsanDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getUlsanDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getUlsanDto().getOverFlowCnt(), yesterdaySido.getUlsanDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getUlsanDto().getDeathCnt(), yesterdaySido.getUlsanDto().getDeathCnt());

        String firstCntSub;
        String secondCntSub;
        String thirdCntSub;

        if (today.isBefore(LocalDate.parse("2021-03-12"))){
            firstCntSub = " ";
            secondCntSub = " ";
            thirdCntSub = " ";

        }
        else {
            firstCntSub = getValue(todayVaccine.getVaccineBusanDto().getFirstCnt(), yesterdayVaccine.getVaccineBusanDto().getFirstCnt());
            secondCntSub = getValue(todayVaccine.getVaccineBusanDto().getSecondCnt(), yesterdayVaccine.getVaccineBusanDto().getSecondCnt());
            thirdCntSub = getValue(todayVaccine.getVaccineBusanDto().getThirdCnt(), yesterdayVaccine.getVaccineBusanDto().getThirdCnt());
        }
        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }

    public RenderingSubDto getUlsanSubDto0(RenderingSidoDto todaySido, RenderingSidoDto yesterdaySido) {
        String incDecCntSub = getValue(todaySido.getUlsanDto().getIncDec(), yesterdaySido.getUlsanDto().getIncDec());
        String locOccCntSub = getValue(todaySido.getUlsanDto().getLocalOccCnt(), yesterdaySido.getUlsanDto().getLocalOccCnt());
        String defCntSub = "(+" + String.valueOf(todaySido.getUlsanDto().getIncDec()) + ") ";
        String overFlowCntSub = getValue(todaySido.getUlsanDto().getOverFlowCnt(), yesterdaySido.getUlsanDto().getOverFlowCnt());
        String deathCntSub = getValue(todaySido.getUlsanDto().getDeathCnt(), yesterdaySido.getUlsanDto().getDeathCnt());


        String firstCntSub = " ";
        String secondCntSub = " ";
        String thirdCntSub = " ";

        return new RenderingSubDto(incDecCntSub, locOccCntSub, defCntSub, overFlowCntSub, deathCntSub, firstCntSub, secondCntSub, thirdCntSub);
    }



    private String getValue(Integer today, Integer yesterday) {
        if (today > yesterday) {
            Integer value = today - yesterday;

            return String.valueOf("(+" + value + ") ");

            //        10        20 50% 감소
        } else if (today < yesterday) {
            Integer value = yesterday - today;

            return String.valueOf("(-" + value + ") ");
        }
        else return "(동일) ";
    }


    public int getTodayIncDecCountArrBusan(LocalDate localDate) {
        return sidoService.getDefCountAndGubunBusan(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrChungbuk(LocalDate localDate) {
        return sidoService.getDefCountAndGubunChungbuk(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrChungnam(LocalDate localDate) {
        return sidoService.getDefCountAndGubunChungnam(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrDaegu(LocalDate localDate) {
        return sidoService.getDefCountAndGubunDaegu(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrDaejeon(LocalDate localDate) {
        return sidoService.getDefCountAndGubunDaejeon(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrGangwon(LocalDate localDate) {
        return sidoService.getDefCountAndGubunGangwon(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrGwangju(LocalDate localDate) {
        return sidoService.getDefCountAndGubunGwangju(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrGyeongbuk(LocalDate localDate) {
        return sidoService.getDefCountAndGubunGyeongbuk(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrGyeonggi(LocalDate localDate) {
        return sidoService.getDefCountAndGubunGyeonggi(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrGyeongnam(LocalDate localDate) {
        return sidoService.getDefCountAndGubunGyeongnam(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrIncheon(LocalDate localDate) {
        return sidoService.getDefCountAndGubunIncheon(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrJeju(LocalDate localDate) {
        return sidoService.getDefCountAndGubunJeju(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrJeonbuk(LocalDate localDate) {
        return sidoService.getDefCountAndGubunJeonbuk(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrJeonnam(LocalDate localDate) {
        return sidoService.getDefCountAndGubunJeonnam(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrLazaretto(LocalDate localDate) {
        return sidoService.getDefCountAndGubunLazaretto(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrSejong(LocalDate localDate) {
        return sidoService.getDefCountAndGubunSejong(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrSeoul(LocalDate localDate) {
        return sidoService.getDefCountAndGubunSeoul(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrTotal(LocalDate localDate) {
        return sidoService.getDefCountAndGubunTotal(localDateToDateDto(localDate)).get(0).getIncDec();
    }

    public int getTodayIncDecCountArrUlsan(LocalDate localDate) {
        return sidoService.getDefCountAndGubunUlsan(localDateToDateDto(localDate)).get(0).getIncDec();
    }















    private static DateDto localDateToDateDto(LocalDate localDate) {
        String str = String.valueOf(localDate);
        String year = str.substring(0, 4);
        String month = str.substring(5, 7);
        String day = str.substring(8);

        return new DateDto(year, month, day);
    }
}
