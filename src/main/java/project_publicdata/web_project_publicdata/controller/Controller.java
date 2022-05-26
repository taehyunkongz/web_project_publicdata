package project_publicdata.web_project_publicdata.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project_publicdata.web_project_publicdata.dto.ClientDateDto;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.SparkLineGraphStateAndPercentage;
import project_publicdata.web_project_publicdata.dto.emptyDto.*;
import project_publicdata.web_project_publicdata.dto.renderingDto.RenderingGenderAndAgeDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.RenderingSidoDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.RenderingVaccineDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.TotalVaccineRateDto;
import project_publicdata.web_project_publicdata.service.MainService;

import java.time.LocalDate;

@Slf4j
    @org.springframework.stereotype.Controller
    @RequiredArgsConstructor
    public class Controller {

    private final MainService mainService;

    static int[] allSidoDefCntArr = new int[18];
    static String[] monthAndDayArr = new String[7];
    // line graph
    static int[] defCountArrTotal = new int[7];

    static int[] defCountArrBusan = new int[7];
    static int[] defCountArrChungbuk = new int[7];
    static int[] defCountArrChungnam = new int[7];
    static int[] defCountArrDaegu = new int[7];
    static int[] defCountArrDaejeon = new int[7];
    static int[] defCountArrGangwon = new int[7];
    static int[] defCountArrGwangju = new int[7];
    static int[] defCountArrGyeongbuk = new int[7];
    static int[] defCountArrGyeonggi = new int[7];
    static int[] defCountArrGyeongnam = new int[7];
    static int[] defCountArrIncheon = new int[7];
    static int[] defCountArrJeju = new int[7];
    static int[] defCountArrJeonbuk = new int[7];
    static int[] defCountArrJeonnam = new int[7];
    static int[] defCountArrLazaretto = new int[7];
    static int[] defCountArrSejong = new int[7];
    static int[] defCountArrSeoul = new int[7];
    static int[] defCountArrUlsan = new int[7];

    static Integer defCountSumTotal = 0;
    static Integer defCountSumBusan = 0;
    static Integer defCountSumChungbuk = 0;
    static Integer defCountSumChungnam = 0;
    static Integer defCountSumDaegu = 0;
    static Integer defCountSumDaejeon = 0;
    static Integer defCountSumGangwon = 0;
    static Integer defCountSumGwangju = 0;
    static Integer defCountSumGyeongbuk = 0;
    static Integer defCountSumGyeonggi = 0;
    static Integer defCountSumGyeongnam = 0;
    static Integer defCountSumIncheon = 0;
    static Integer defCountSumJeju = 0;
    static Integer defCountSumJeonbuk = 0;
    static Integer defCountSumJeonnam = 0;
    static Integer defCountSumLazaretto = 0;
    static Integer defCountSumSejong = 0;
    static Integer defCountSumSeoul = 0;
    static Integer defCountSumUlsan = 0;

    // donutgraph
    static int[] incDecCountArrTotal = new int[2];
    static int[] incDecCountArrBusan = new int[2];
    static int[] incDecCountArrChungbuk = new int[2];
    static int[] incDecCountArrChungnam = new int[2];
    static int[] incDecCountArrDaegu = new int[2];
    static int[] incDecCountArrDaejeon = new int[2];
    static int[] incDecCountArrGangwon = new int[2];
    static int[] incDecCountArrGwangju = new int[2];
    static int[] incDecCountArrGyeongbuk = new int[2];
    static int[] incDecCountArrGyeonggi = new int[2];
    static int[] incDecCountArrGyeongnam = new int[2];
    static int[] incDecCountArrIncheon = new int[2];
    static int[] incDecCountArrJeju = new int[2];
    static int[] incDecCountArrJeonbuk = new int[2];
    static int[] incDecCountArrJeonnam = new int[2];
    static int[] incDecCountArrLazaretto = new int[2];
    static int[] incDecCountArrSejong = new int[2];
    static int[] incDecCountArrSeoul = new int[2];
    static int[] incDecCountArrUlsan = new int[2];

    // radialBar chart
    static double[] vaccineDefCountArr = new double[3];

    // bar chart
    static int[] ageIncDecCountArr = new int[9];

    // sparkLine chart
    static int[] sixteenDaysDeathCountArrTotal = new int[16];
    static int[] fifteenDaysDeathCountArrTotal = new int[15];
    static int[] fifteenDaysLocalOccCountArrTotal = new int[15];
    static int[] fifteenDaysOverFlowCountArrTotal = new int[15];
    static int[] fifteenDaysDefCntCountArrTotal = new int[15];

    // column chart

    static int[] MaleAndFemaleColumnChartArr = new int[2];




        @RequestMapping ("/")
        public String home(Model model) {

            ClientDateDto clientDateDto = new ClientDateDto();

            model.addAttribute("clientDateDto", clientDateDto);

            model.addAttribute("dateState", 1);

            LocalDate today = LocalDate.now().minusDays(1);
            LocalDate yesterday = today.minusDays(1);

            model.addAttribute("maxDate", LocalDate.now().minusDays(1));


            model.addAttribute("today", localDateToString1(today));

            model.addAttribute("todayString", localDateToString2(today));

            RenderingSidoDto renderingSidoDto = mainService.setRenderingSidoData(localDateToDateDto(today));
            RenderingSidoDto renderingYesterdaySidoDto = mainService.setRenderingSidoData(localDateToDateDto(yesterday));

            // column chart
            model.addAttribute("monthAndDayArr", getMonthAndDayArr(today, monthAndDayArr));

            model.addAttribute("allSidoDefCntArr",  getAllSidoTodayDefCountArr(renderingSidoDto, allSidoDefCntArr));

            model.addAttribute("sidoData", renderingSidoDto);

            RenderingVaccineDto renderingVaccineDto = mainService.setRenderingVaccineData(localDateToDateDto(today));
            RenderingVaccineDto renderingYesterdayVaccineDto = mainService.setRenderingVaccineData(localDateToDateDto(yesterday));
            model.addAttribute("busanTotalFirstCountDefault", String.format("%.2f", renderingVaccineDto.getVaccineBusanDto().getTotalFirstCnt() / 3254941.0 * 100));
            model.addAttribute("busanTotalSecondCountDefault", String.format("%.2f", renderingVaccineDto.getVaccineBusanDto().getTotalSecondCnt() / 3254941.0 * 100));
            model.addAttribute("busanTotalThirdCountDefault", String.format("%.2f", renderingVaccineDto.getVaccineBusanDto().getTotalThirdCnt() / 3254941.0 * 100));

            model.addAttribute("totalVaccineRateData", accumulateVaccineRate(
                    renderingVaccineDto.getVaccineTotalDto().getTotalFirstCnt(),
                    renderingVaccineDto.getVaccineTotalDto().getTotalSecondCnt(),
                    renderingVaccineDto.getVaccineTotalDto().getTotalThirdCnt()));

            model.addAttribute("vaccineData", renderingVaccineDto);

            RenderingGenderAndAgeDto renderingGenderAndAgeDto = mainService.setRenderingGenderAndAgeData(localDateToDateDto(today));

            model.addAttribute("genderAndAgeData", renderingGenderAndAgeDto);

            // linechart
            int[] defCountArrayBusan = mainService.getDefCountArrBusan(today, defCountArrBusan);

            model.addAttribute("defCountSumBusan", getDefCountSum(defCountArrayBusan, defCountSumBusan));

            model.addAttribute("defCountArrBusan", defCountArrayBusan);

            int[] defCountArrayTotal = mainService.getDefCountArrTotal(today, defCountArrTotal);

            model.addAttribute("defCountSumTotal", getDefCountSum(defCountArrayTotal, defCountSumTotal));

            model.addAttribute("defCountArrTotal", defCountArrayTotal);

            int[] defCountArrayChungbuk = mainService.getDefCountArrChungbuk(today, defCountArrChungbuk);

            model.addAttribute("defCountSumChungbuk", getDefCountSum(defCountArrayChungbuk, defCountSumChungbuk));

            model.addAttribute("defCountArrChungbuk", defCountArrayChungbuk);

            int[] defCountArrayChungnam = mainService.getDefCountArrChungnam(today, defCountArrChungnam);

            model.addAttribute("defCountSumChungnam", getDefCountSum(defCountArrayChungnam, defCountSumChungnam));

            model.addAttribute("defCountArrChungnam", defCountArrayChungnam);

            int[] defCountArrayDaegu = mainService.getDefCountArrDaegu(today, defCountArrDaegu);

            model.addAttribute("defCountSumDaegu", getDefCountSum(defCountArrayDaegu, defCountSumDaegu));

            model.addAttribute("defCountArrDaegu", defCountArrayDaegu);

            int[] defCountArrayDaejeon = mainService.getDefCountArrDaejeon(today, defCountArrDaejeon);

            model.addAttribute("defCountSumDaejeon", getDefCountSum(defCountArrayDaejeon, defCountSumDaejeon));

            model.addAttribute("defCountArrDaejeon", defCountArrayDaejeon);

            int[] defCountArrayGangwon = mainService.getDefCountArrGangwon(today, defCountArrGangwon);

            model.addAttribute("defCountSumGangwon", getDefCountSum(defCountArrayGangwon, defCountSumGangwon));

            model.addAttribute("defCountArrGangwon", defCountArrayGangwon);

            int[] defCountArrayGwangju = mainService.getDefCountArrGwangju(today, defCountArrGwangju);

            model.addAttribute("defCountSumGwangju", getDefCountSum(defCountArrayGwangju, defCountSumGwangju));

            model.addAttribute("defCountArrGwangju", defCountArrayGwangju);

            int[] defCountArrayGyeongbuk = mainService.getDefCountArrGyeongbuk(today, defCountArrGyeongbuk);

            model.addAttribute("defCountSumGyeongbuk", getDefCountSum(defCountArrayGyeongbuk, defCountSumGyeongbuk));

            model.addAttribute("defCountArrGyeongbuk", defCountArrayGyeongbuk);

            int[] defCountArrayGyeonggi = mainService.getDefCountArrGyeonggi(today, defCountArrGyeonggi);

            model.addAttribute("defCountSumGyeonggi", getDefCountSum(defCountArrayGyeonggi, defCountSumGyeonggi));

            model.addAttribute("defCountArrGyeonggi", defCountArrayGyeonggi);

            int[] defCountArrayGyeongnam = mainService.getDefCountArrGyeongnam(today, defCountArrGyeongnam);

            model.addAttribute("defCountSumGyeongnam", getDefCountSum(defCountArrayGyeongnam, defCountSumGyeongnam));

            model.addAttribute("defCountArrGyeongnam", defCountArrayGyeongnam);

            int[] defCountArrayIncheon = mainService.getDefCountArrIncheon(today, defCountArrIncheon);

            model.addAttribute("defCountSumIncheon", getDefCountSum(defCountArrayIncheon, defCountSumIncheon));

            model.addAttribute("defCountArrIncheon", defCountArrayIncheon);

            int[] defCountArrayJeju = mainService.getDefCountArrJeju(today, defCountArrJeju);

            model.addAttribute("defCountSumJeju", getDefCountSum(defCountArrayJeju, defCountSumJeju));

            model.addAttribute("defCountArrJeju", defCountArrayJeju);

            int[] defCountArrayJeonbuk = mainService.getDefCountArrJeonbuk(today, defCountArrJeonbuk);

            model.addAttribute("defCountSumJeonbuk", getDefCountSum(defCountArrayJeonbuk, defCountSumJeonbuk));

            model.addAttribute("defCountArrJeonbuk", defCountArrayJeonbuk);

            int[] defCountArrayJeonnam = mainService.getDefCountArrJeonnam(today, defCountArrJeonnam);

            model.addAttribute("defCountSumJeonnam", getDefCountSum(defCountArrayJeonnam, defCountSumJeonnam));

            model.addAttribute("defCountArrJeonnam", defCountArrayJeonnam);

            int[] defCountArrayLazaretto = mainService.getDefCountArrLazaretto(today, defCountArrLazaretto);

            model.addAttribute("defCountSumLazaretto", getDefCountSum(defCountArrayLazaretto, defCountSumLazaretto));

            model.addAttribute("defCountArrLazaretto", defCountArrayLazaretto);

            int[] defCountArraySejong = mainService.getDefCountArrSejong(today, defCountArrSejong);

            model.addAttribute("defCountSumSejong", getDefCountSum(defCountArraySejong, defCountSumSejong));

            model.addAttribute("defCountArrSejong", defCountArraySejong);

            int[] defCountArraySeoul = mainService.getDefCountArrSeoul(today, defCountArrSeoul);

            model.addAttribute("defCountSumSeoul", getDefCountSum(defCountArraySeoul, defCountSumSeoul));

            model.addAttribute("defCountArrSeoul", defCountArraySeoul);

            int[] defCountArrayUlsan = mainService.getDefCountArrUlsan(today, defCountArrUlsan);

            model.addAttribute("defCountSumUlsan", getDefCountSum(defCountArrayUlsan, defCountSumUlsan));

            model.addAttribute("defCountArrUlsan", defCountArrayUlsan);

            // donutchart

            int totalIncDecCount = mainService.getTodayIncDecCountArrTotal(today);

            model.addAttribute("donutChartArrBusan",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrBusan(today), incDecCountArrBusan));

            model.addAttribute("donutChartArrChungnam",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrChungnam(today), incDecCountArrChungnam));

            model.addAttribute("donutChartArrChungbuk",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrChungbuk(today), incDecCountArrChungbuk));

            model.addAttribute("donutChartArrDaegu",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrDaegu(today), incDecCountArrDaegu));

            model.addAttribute("donutChartArrDaejeon",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrDaejeon(today), incDecCountArrDaejeon));

            model.addAttribute("donutChartArrGangwon",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGangwon(today), incDecCountArrGangwon));

            model.addAttribute("donutChartArrGwangju",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGwangju(today), incDecCountArrGwangju));

            model.addAttribute("donutChartArrGyeongbuk",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeongbuk(today), incDecCountArrGyeongbuk));

            model.addAttribute("donutChartArrGyeonggi",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeonggi(today), incDecCountArrGyeonggi));

            model.addAttribute("donutChartArrGyeongnam",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeongnam(today), incDecCountArrGyeongnam));

            model.addAttribute("donutChartArrIncheon",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrIncheon(today), incDecCountArrIncheon));

            model.addAttribute("donutChartArrJeju",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeju(today), incDecCountArrJeju));

            model.addAttribute("donutChartArrJeonbuk",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeonbuk(today), incDecCountArrJeonbuk));

            model.addAttribute("donutChartArrJeonnam",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeonnam(today), incDecCountArrJeonnam));

            model.addAttribute("donutChartArrLazaretto",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrLazaretto(today), incDecCountArrLazaretto));

            model.addAttribute("donutChartArrSejong",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrSejong(today), incDecCountArrSejong));

            model.addAttribute("donutChartArrSeoul",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrSeoul(today), incDecCountArrSeoul));

            model.addAttribute("donutChartArrUlsan",
                    getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrUlsan(today), incDecCountArrUlsan));

            // donut Sub

            model.addAttribute("busanSubDto", mainService.getBusanSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("chungbukSubDto", mainService.getChungbukSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("chungnamSubDto", mainService.getChungnamSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("daeguSubDto", mainService.getDaeguSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("daejeonSubDto", mainService.getDaejeonSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("gangwonSubDto", mainService.getGangwonSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today) );
            model.addAttribute("gwangjuSubDto", mainService.getGwangjuSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("gyeongbukSubDto", mainService.getGyeongbukSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("gyeonggiSubDto", mainService.getGyeonggiSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("gyeongnamSubDto", mainService.getGyeongnamSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("incheonSubDto", mainService.getIncheonSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("jejuSubDto", mainService.getJejuSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("jeonbukSubDto", mainService.getJeonbukSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("jeonnamSubDto", mainService.getJeonnamSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("lazarettoSubDto", mainService.getLazarettoSubDto1(renderingSidoDto, renderingYesterdaySidoDto));
            model.addAttribute("sejongSubDto", mainService.getSejongSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("seoulSubDto", mainService.getSeoulSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today));
            model.addAttribute("ulsanSubDto",mainService.getUlsanSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                    renderingVaccineDto, renderingYesterdayVaccineDto, today) );


            // radialBar chart
            model.addAttribute("radialBarChartArrTotal", getRadialBarChartArr(renderingVaccineDto, vaccineDefCountArr));

            // pie chart
            model.addAttribute("pieChartArr", getPieChartArr(renderingGenderAndAgeDto, ageIncDecCountArr));

            // sparkline chart
            int[] fifteenDaysDefCntCountArrTotal = mainService.getFifteenDaysDefCntCountArrTotal(today, Controller.fifteenDaysDefCntCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage1", getSparkLineGraphStateAndPercentage(fifteenDaysDefCntCountArrTotal));
            model.addAttribute("defCntSparkLineArrTotal", fifteenDaysDefCntCountArrTotal);

            int[] fifteenDaysLocalOccCountArrTotal = mainService.getFifteenDaysLocalOccCountArrTotal(today, Controller.fifteenDaysLocalOccCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage2", getSparkLineGraphStateAndPercentage(fifteenDaysLocalOccCountArrTotal));
            model.addAttribute("localOccCountSparkLineArrTotal", fifteenDaysLocalOccCountArrTotal);

            int[] fifteenDaysOverFlowCountArrTotal = mainService.getFifteenDaysOverFlowCountArrTotal(today, Controller.fifteenDaysOverFlowCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage3", getSparkLineGraphStateAndPercentage(fifteenDaysOverFlowCountArrTotal));
            model.addAttribute("overFlowCountSparkLineArrTotal", fifteenDaysOverFlowCountArrTotal);

            int[] fifteenDaysDeathCountArrTotal = getFifteenDaysDeathCountArrTotal(mainService.getSixteenDaysDeathCountArrTotal(today, sixteenDaysDeathCountArrTotal), Controller.fifteenDaysDeathCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage4", getSparkLineGraphStateAndPercentage(fifteenDaysDeathCountArrTotal));
            model.addAttribute("deathCountSparkLineArrTotal", fifteenDaysDeathCountArrTotal);

            // column chart
            model.addAttribute("columnChartArr" ,getColumnChartArr(renderingGenderAndAgeDto, MaleAndFemaleColumnChartArr));



            return "index";
        }

        @PostMapping("/")
        public String home2(@ModelAttribute("clientDateDto") ClientDateDto clientDateDto,
                Model model) {

            LocalDate standardDate = LocalDate.parse("2021-03-11");
            LocalDate today = strToLocalDate(clientDateDto.getDateRangePicker());
            LocalDate yesterday = today.minusMonths(1);

            model.addAttribute("maxDate", LocalDate.now().minusDays(1));

            model.addAttribute("today", localDateToString1(today));
            model.addAttribute("todayString", localDateToString2(today));

            if (today.isBefore(standardDate)) {

                model.addAttribute("dateState", 0);
                RenderingSidoDto renderingSidoDto = mainService.setRenderingSidoData(localDateToDateDto(today));
                RenderingSidoDto renderingYesterdaySidoDto = mainService.setRenderingSidoData(localDateToDateDto(yesterday));

                model.addAttribute("monthAndDayArr", getMonthAndDayArr(today, monthAndDayArr));

                model.addAttribute("allSidoDefCntArr",  getAllSidoTodayDefCountArr(renderingSidoDto, allSidoDefCntArr));

                model.addAttribute("sidoData", renderingSidoDto);

                model.addAttribute("totalVaccineRateData",
                        new TotalVaccineRateDto(0.0, 0.0, 0.0, "-", "-", "-") );

                model.addAttribute("vaccineData", getEmptyRenderingVaccineDto());


                model.addAttribute("busanTotalFirstCountDefault", "0.0%");
                model.addAttribute("busanTotalSecondCountDefault", "0.0%");
                model.addAttribute("busanTotalThirdCountDefault", "0.0%");
                RenderingGenderAndAgeDto renderingGenderAndAgeDto = mainService.setRenderingGenderAndAgeData(localDateToDateDto(today));

                model.addAttribute("genderAndAgeData", renderingGenderAndAgeDto);

                // linechart
                int[] defCountArrayBusan = mainService.getDefCountArrBusan(today, defCountArrBusan);

                model.addAttribute("defCountSumBusan", getDefCountSum(defCountArrayBusan, defCountSumBusan));

                model.addAttribute("defCountArrBusan", defCountArrayBusan);

                int[] defCountArrayTotal = mainService.getDefCountArrTotal(today, defCountArrTotal);

                model.addAttribute("defCountSumTotal", getDefCountSum(defCountArrayTotal, defCountSumTotal));

                model.addAttribute("defCountArrTotal", defCountArrayTotal);

                int[] defCountArrayChungbuk = mainService.getDefCountArrChungbuk(today, defCountArrChungbuk);

                model.addAttribute("defCountSumChungbuk", getDefCountSum(defCountArrayChungbuk, defCountSumChungbuk));

                model.addAttribute("defCountArrChungbuk", defCountArrayChungbuk);

                int[] defCountArrayChungnam = mainService.getDefCountArrChungnam(today, defCountArrChungnam);

                model.addAttribute("defCountSumChungnam", getDefCountSum(defCountArrayChungnam, defCountSumChungnam));

                model.addAttribute("defCountArrChungnam", defCountArrayChungnam);

                int[] defCountArrayDaegu = mainService.getDefCountArrDaegu(today, defCountArrDaegu);

                model.addAttribute("defCountSumDaegu", getDefCountSum(defCountArrayDaegu, defCountSumDaegu));

                model.addAttribute("defCountArrDaegu", defCountArrayDaegu);

                int[] defCountArrayDaejeon = mainService.getDefCountArrDaejeon(today, defCountArrDaejeon);

                model.addAttribute("defCountSumDaejeon", getDefCountSum(defCountArrayDaejeon, defCountSumDaejeon));

                model.addAttribute("defCountArrDaejeon", defCountArrayDaejeon);

                int[] defCountArrayGangwon = mainService.getDefCountArrGangwon(today, defCountArrGangwon);

                model.addAttribute("defCountSumGangwon", getDefCountSum(defCountArrayGangwon, defCountSumGangwon));

                model.addAttribute("defCountArrGangwon", defCountArrayGangwon);

                int[] defCountArrayGwangju = mainService.getDefCountArrGwangju(today, defCountArrGwangju);

                model.addAttribute("defCountSumGwangju", getDefCountSum(defCountArrayGwangju, defCountSumGwangju));

                model.addAttribute("defCountArrGwangju", defCountArrayGwangju);

                int[] defCountArrayGyeongbuk = mainService.getDefCountArrGyeongbuk(today, defCountArrGyeongbuk);

                model.addAttribute("defCountSumGyeongbuk", getDefCountSum(defCountArrayGyeongbuk, defCountSumGyeongbuk));

                model.addAttribute("defCountArrGyeongbuk", defCountArrayGyeongbuk);

                int[] defCountArrayGyeonggi = mainService.getDefCountArrGyeonggi(today, defCountArrGyeonggi);

                model.addAttribute("defCountSumGyeonggi", getDefCountSum(defCountArrayGyeonggi, defCountSumGyeonggi));

                model.addAttribute("defCountArrGyeonggi", defCountArrayGyeonggi);

                int[] defCountArrayGyeongnam = mainService.getDefCountArrGyeongnam(today, defCountArrGyeongnam);

                model.addAttribute("defCountSumGyeongnam", getDefCountSum(defCountArrayGyeongnam, defCountSumGyeongnam));

                model.addAttribute("defCountArrGyeongnam", defCountArrayGyeongnam);

                int[] defCountArrayIncheon = mainService.getDefCountArrIncheon(today, defCountArrIncheon);

                model.addAttribute("defCountSumIncheon", getDefCountSum(defCountArrayIncheon, defCountSumIncheon));

                model.addAttribute("defCountArrIncheon", defCountArrayIncheon);

                int[] defCountArrayJeju = mainService.getDefCountArrJeju(today, defCountArrJeju);

                model.addAttribute("defCountSumJeju", getDefCountSum(defCountArrayJeju, defCountSumJeju));

                model.addAttribute("defCountArrJeju", defCountArrayJeju);

                int[] defCountArrayJeonbuk = mainService.getDefCountArrJeonbuk(today, defCountArrJeonbuk);

                model.addAttribute("defCountSumJeonbuk", getDefCountSum(defCountArrayJeonbuk, defCountSumJeonbuk));

                model.addAttribute("defCountArrJeonbuk", defCountArrayJeonbuk);

                int[] defCountArrayJeonnam = mainService.getDefCountArrJeonnam(today, defCountArrJeonnam);

                model.addAttribute("defCountSumJeonnam", getDefCountSum(defCountArrayJeonnam, defCountSumJeonnam));

                model.addAttribute("defCountArrJeonnam", defCountArrayJeonnam);

                int[] defCountArrayLazaretto = mainService.getDefCountArrLazaretto(today, defCountArrLazaretto);

                model.addAttribute("defCountSumLazaretto", getDefCountSum(defCountArrayLazaretto, defCountSumLazaretto));

                model.addAttribute("defCountArrLazaretto", defCountArrayLazaretto);

                int[] defCountArraySejong = mainService.getDefCountArrSejong(today, defCountArrSejong);

                model.addAttribute("defCountSumSejong", getDefCountSum(defCountArraySejong, defCountSumSejong));

                model.addAttribute("defCountArrSejong", defCountArraySejong);

                int[] defCountArraySeoul = mainService.getDefCountArrSeoul(today, defCountArrSeoul);

                model.addAttribute("defCountSumSeoul", getDefCountSum(defCountArraySeoul, defCountSumSeoul));

                model.addAttribute("defCountArrSeoul", defCountArraySeoul);

                int[] defCountArrayUlsan = mainService.getDefCountArrUlsan(today, defCountArrUlsan);

                model.addAttribute("defCountSumUlsan", getDefCountSum(defCountArrayUlsan, defCountSumUlsan));

                model.addAttribute("defCountArrUlsan", defCountArrayUlsan);

                // donutchart

                int totalIncDecCount = mainService.getTodayIncDecCountArrTotal(today);

                model.addAttribute("donutChartArrBusan",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrBusan(today), incDecCountArrBusan));

                model.addAttribute("donutChartArrChungnam",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrChungnam(today), incDecCountArrChungnam));

                model.addAttribute("donutChartArrChungbuk",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrChungbuk(today), incDecCountArrChungbuk));

                model.addAttribute("donutChartArrDaegu",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrDaegu(today), incDecCountArrDaegu));

                model.addAttribute("donutChartArrDaejeon",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrDaejeon(today), incDecCountArrDaejeon));

                model.addAttribute("donutChartArrGangwon",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGangwon(today), incDecCountArrGangwon));

                model.addAttribute("donutChartArrGwangju",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGwangju(today), incDecCountArrGwangju));

                model.addAttribute("donutChartArrGyeongbuk",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeongbuk(today), incDecCountArrGyeongbuk));

                model.addAttribute("donutChartArrGyeonggi",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeonggi(today), incDecCountArrGyeonggi));

                model.addAttribute("donutChartArrGyeongnam",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeongnam(today), incDecCountArrGyeongnam));

                model.addAttribute("donutChartArrIncheon",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrIncheon(today), incDecCountArrIncheon));

                model.addAttribute("donutChartArrJeju",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeju(today), incDecCountArrJeju));

                model.addAttribute("donutChartArrJeonbuk",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeonbuk(today), incDecCountArrJeonbuk));

                model.addAttribute("donutChartArrJeonnam",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeonnam(today), incDecCountArrJeonnam));

                model.addAttribute("donutChartArrLazaretto",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrLazaretto(today), incDecCountArrLazaretto));

                model.addAttribute("donutChartArrSejong",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrSejong(today), incDecCountArrSejong));

                model.addAttribute("donutChartArrSeoul",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrSeoul(today), incDecCountArrSeoul));

                model.addAttribute("donutChartArrUlsan",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrUlsan(today), incDecCountArrUlsan));

                // donut Sub

                model.addAttribute("busanSubDto", mainService.getBusanSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("chungbukSubDto", mainService.getChungbukSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("chungnamSubDto", mainService.getChungnamSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("daeguSubDto", mainService.getDaeguSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("daejeonSubDto", mainService.getDaejeonSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("gangwonSubDto", mainService.getGangwonSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("gwangjuSubDto", mainService.getGwangjuSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("gyeongbukSubDto", mainService.getGyeongbukSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("gyeonggiSubDto", mainService.getGyeonggiSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("gyeongnamSubDto", mainService.getGyeongnamSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("incheonSubDto", mainService.getIncheonSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("jejuSubDto", mainService.getJejuSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("jeonbukSubDto", mainService.getJeonbukSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("jeonnamSubDto", mainService.getJeonnamSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("lazarettoSubDto", mainService.getLazarettoSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("sejongSubDto", mainService.getSejongSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("seoulSubDto", mainService.getSeoulSubDto0(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("ulsanSubDto",mainService.getUlsanSubDto0(renderingSidoDto, renderingYesterdaySidoDto));

                // radialBar chart
                int[] radialBarChartEmptyArr = {0, 0, 0};
                model.addAttribute("radialBarChartArrTotal", radialBarChartEmptyArr);

                // pie chart
                model.addAttribute("pieChartArr", getPieChartArr(renderingGenderAndAgeDto, ageIncDecCountArr));

                // column chart
                model.addAttribute("columnChartArr" ,getColumnChartArr(renderingGenderAndAgeDto, MaleAndFemaleColumnChartArr));

            }

            else {

                model.addAttribute("dateState", 1);

                RenderingSidoDto renderingSidoDto = mainService.setRenderingSidoData(localDateToDateDto(today));
                RenderingSidoDto renderingYesterdaySidoDto = mainService.setRenderingSidoData(localDateToDateDto(yesterday));
            // column chart
                model.addAttribute("monthAndDayArr", getMonthAndDayArr(today, monthAndDayArr));

                model.addAttribute("allSidoDefCntArr",  getAllSidoTodayDefCountArr(renderingSidoDto, allSidoDefCntArr));

                model.addAttribute("sidoData", renderingSidoDto);

                RenderingVaccineDto renderingVaccineDto = mainService.setRenderingVaccineData(localDateToDateDto(today));
                RenderingVaccineDto renderingYesterdayVaccineDto = mainService.setRenderingVaccineData(localDateToDateDto(yesterday));

                model.addAttribute("busanTotalFirstCountDefault", String.format("%.2f", renderingVaccineDto.getVaccineBusanDto().getTotalFirstCnt() / 3254941.0 * 100));
                model.addAttribute("busanTotalSecondCountDefault", String.format("%.2f", renderingVaccineDto.getVaccineBusanDto().getTotalSecondCnt() / 3254941.0 * 100));
                model.addAttribute("busanTotalThirdCountDefault", String.format("%.2f", renderingVaccineDto.getVaccineBusanDto().getTotalThirdCnt() / 3254941.0 * 100));

                model.addAttribute("totalVaccineRateData", accumulateVaccineRate(
                        renderingVaccineDto.getVaccineTotalDto().getTotalFirstCnt(),
                        renderingVaccineDto.getVaccineTotalDto().getTotalSecondCnt(),
                        renderingVaccineDto.getVaccineTotalDto().getTotalThirdCnt()));

                model.addAttribute("vaccineData", renderingVaccineDto);

                RenderingGenderAndAgeDto renderingGenderAndAgeDto = mainService.setRenderingGenderAndAgeData(localDateToDateDto(today));

                model.addAttribute("genderAndAgeData", renderingGenderAndAgeDto);

                // linechart
                int[] defCountArrayBusan = mainService.getDefCountArrBusan(today, defCountArrBusan);

                model.addAttribute("defCountSumBusan", getDefCountSum(defCountArrayBusan, defCountSumBusan));

                model.addAttribute("defCountArrBusan", defCountArrayBusan);

                int[] defCountArrayTotal = mainService.getDefCountArrTotal(today, defCountArrTotal);

                model.addAttribute("defCountSumTotal", getDefCountSum(defCountArrayTotal, defCountSumTotal));

                model.addAttribute("defCountArrTotal", defCountArrayTotal);

                int[] defCountArrayChungbuk = mainService.getDefCountArrChungbuk(today, defCountArrChungbuk);

                model.addAttribute("defCountSumChungbuk", getDefCountSum(defCountArrayChungbuk, defCountSumChungbuk));

                model.addAttribute("defCountArrChungbuk", defCountArrayChungbuk);

                int[] defCountArrayChungnam = mainService.getDefCountArrChungnam(today, defCountArrChungnam);

                model.addAttribute("defCountSumChungnam", getDefCountSum(defCountArrayChungnam, defCountSumChungnam));

                model.addAttribute("defCountArrChungnam", defCountArrayChungnam);

                int[] defCountArrayDaegu = mainService.getDefCountArrDaegu(today, defCountArrDaegu);

                model.addAttribute("defCountSumDaegu", getDefCountSum(defCountArrayDaegu, defCountSumDaegu));

                model.addAttribute("defCountArrDaegu", defCountArrayDaegu);

                int[] defCountArrayDaejeon = mainService.getDefCountArrDaejeon(today, defCountArrDaejeon);

                model.addAttribute("defCountSumDaejeon", getDefCountSum(defCountArrayDaejeon, defCountSumDaejeon));

                model.addAttribute("defCountArrDaejeon", defCountArrayDaejeon);

                int[] defCountArrayGangwon = mainService.getDefCountArrGangwon(today, defCountArrGangwon);

                model.addAttribute("defCountSumGangwon", getDefCountSum(defCountArrayGangwon, defCountSumGangwon));

                model.addAttribute("defCountArrGangwon", defCountArrayGangwon);

                int[] defCountArrayGwangju = mainService.getDefCountArrGwangju(today, defCountArrGwangju);

                model.addAttribute("defCountSumGwangju", getDefCountSum(defCountArrayGwangju, defCountSumGwangju));

                model.addAttribute("defCountArrGwangju", defCountArrayGwangju);

                int[] defCountArrayGyeongbuk = mainService.getDefCountArrGyeongbuk(today, defCountArrGyeongbuk);

                model.addAttribute("defCountSumGyeongbuk", getDefCountSum(defCountArrayGyeongbuk, defCountSumGyeongbuk));

                model.addAttribute("defCountArrGyeongbuk", defCountArrayGyeongbuk);

                int[] defCountArrayGyeonggi = mainService.getDefCountArrGyeonggi(today, defCountArrGyeonggi);

                model.addAttribute("defCountSumGyeonggi", getDefCountSum(defCountArrayGyeonggi, defCountSumGyeonggi));

                model.addAttribute("defCountArrGyeonggi", defCountArrayGyeonggi);

                int[] defCountArrayGyeongnam = mainService.getDefCountArrGyeongnam(today, defCountArrGyeongnam);

                model.addAttribute("defCountSumGyeongnam", getDefCountSum(defCountArrayGyeongnam, defCountSumGyeongnam));

                model.addAttribute("defCountArrGyeongnam", defCountArrayGyeongnam);

                int[] defCountArrayIncheon = mainService.getDefCountArrIncheon(today, defCountArrIncheon);

                model.addAttribute("defCountSumIncheon", getDefCountSum(defCountArrayIncheon, defCountSumIncheon));

                model.addAttribute("defCountArrIncheon", defCountArrayIncheon);

                int[] defCountArrayJeju = mainService.getDefCountArrJeju(today, defCountArrJeju);

                model.addAttribute("defCountSumJeju", getDefCountSum(defCountArrayJeju, defCountSumJeju));

                model.addAttribute("defCountArrJeju", defCountArrayJeju);

                int[] defCountArrayJeonbuk = mainService.getDefCountArrJeonbuk(today, defCountArrJeonbuk);

                model.addAttribute("defCountSumJeonbuk", getDefCountSum(defCountArrayJeonbuk, defCountSumJeonbuk));

                model.addAttribute("defCountArrJeonbuk", defCountArrayJeonbuk);

                int[] defCountArrayJeonnam = mainService.getDefCountArrJeonnam(today, defCountArrJeonnam);

                model.addAttribute("defCountSumJeonnam", getDefCountSum(defCountArrayJeonnam, defCountSumJeonnam));

                model.addAttribute("defCountArrJeonnam", defCountArrayJeonnam);

                int[] defCountArrayLazaretto = mainService.getDefCountArrLazaretto(today, defCountArrLazaretto);

                model.addAttribute("defCountSumLazaretto", getDefCountSum(defCountArrayLazaretto, defCountSumLazaretto));

                model.addAttribute("defCountArrLazaretto", defCountArrayLazaretto);

                int[] defCountArraySejong = mainService.getDefCountArrSejong(today, defCountArrSejong);

                model.addAttribute("defCountSumSejong", getDefCountSum(defCountArraySejong, defCountSumSejong));

                model.addAttribute("defCountArrSejong", defCountArraySejong);

                int[] defCountArraySeoul = mainService.getDefCountArrSeoul(today, defCountArrSeoul);

                model.addAttribute("defCountSumSeoul", getDefCountSum(defCountArraySeoul, defCountSumSeoul));

                model.addAttribute("defCountArrSeoul", defCountArraySeoul);

                int[] defCountArrayUlsan = mainService.getDefCountArrUlsan(today, defCountArrUlsan);

                model.addAttribute("defCountSumUlsan", getDefCountSum(defCountArrayUlsan, defCountSumUlsan));

                model.addAttribute("defCountArrUlsan", defCountArrayUlsan);

                // donutchart

                int totalIncDecCount = mainService.getTodayIncDecCountArrTotal(today);

                model.addAttribute("donutChartArrBusan",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrBusan(today), incDecCountArrBusan));

                model.addAttribute("donutChartArrChungnam",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrChungnam(today), incDecCountArrChungnam));

                model.addAttribute("donutChartArrChungbuk",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrChungbuk(today), incDecCountArrChungbuk));

                model.addAttribute("donutChartArrDaegu",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrDaegu(today), incDecCountArrDaegu));

                model.addAttribute("donutChartArrDaejeon",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrDaejeon(today), incDecCountArrDaejeon));

                model.addAttribute("donutChartArrGangwon",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGangwon(today), incDecCountArrGangwon));

                model.addAttribute("donutChartArrGwangju",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGwangju(today), incDecCountArrGwangju));

                model.addAttribute("donutChartArrGyeongbuk",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeongbuk(today), incDecCountArrGyeongbuk));

                model.addAttribute("donutChartArrGyeonggi",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeonggi(today), incDecCountArrGyeonggi));

                model.addAttribute("donutChartArrGyeongnam",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrGyeongnam(today), incDecCountArrGyeongnam));

                model.addAttribute("donutChartArrIncheon",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrIncheon(today), incDecCountArrIncheon));

                model.addAttribute("donutChartArrJeju",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeju(today), incDecCountArrJeju));

                model.addAttribute("donutChartArrJeonbuk",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeonbuk(today), incDecCountArrJeonbuk));

                model.addAttribute("donutChartArrJeonnam",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrJeonnam(today), incDecCountArrJeonnam));

                model.addAttribute("donutChartArrLazaretto",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrLazaretto(today), incDecCountArrLazaretto));

                model.addAttribute("donutChartArrSejong",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrSejong(today), incDecCountArrSejong));

                model.addAttribute("donutChartArrSeoul",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrSeoul(today), incDecCountArrSeoul));

                model.addAttribute("donutChartArrUlsan",
                        getDonutChartArr(totalIncDecCount, mainService.getTodayIncDecCountArrUlsan(today), incDecCountArrUlsan));

                // donut Sub

                model.addAttribute("busanSubDto", mainService.getBusanSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("chungbukSubDto", mainService.getChungbukSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("chungnamSubDto", mainService.getChungnamSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("daeguSubDto", mainService.getDaeguSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("daejeonSubDto", mainService.getDaejeonSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("gangwonSubDto", mainService.getGangwonSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today) );
                model.addAttribute("gwangjuSubDto", mainService.getGwangjuSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("gyeongbukSubDto", mainService.getGyeongbukSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("gyeonggiSubDto", mainService.getGyeonggiSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("gyeongnamSubDto", mainService.getGyeongnamSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("incheonSubDto", mainService.getIncheonSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("jejuSubDto", mainService.getJejuSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("jeonbukSubDto", mainService.getJeonbukSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("jeonnamSubDto", mainService.getJeonnamSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("lazarettoSubDto", mainService.getLazarettoSubDto1(renderingSidoDto, renderingYesterdaySidoDto));
                model.addAttribute("sejongSubDto", mainService.getSejongSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("seoulSubDto", mainService.getSeoulSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));
                model.addAttribute("ulsanSubDto",mainService.getUlsanSubDto1(renderingSidoDto, renderingYesterdaySidoDto,
                        renderingVaccineDto, renderingYesterdayVaccineDto, today));


                // radialBar chart
                model.addAttribute("radialBarChartArrTotal", getRadialBarChartArr(renderingVaccineDto, vaccineDefCountArr));

                // pie chart
                model.addAttribute("pieChartArr", getPieChartArr(renderingGenderAndAgeDto, ageIncDecCountArr));

                // column chart
                model.addAttribute("columnChartArr" ,getColumnChartArr(renderingGenderAndAgeDto, MaleAndFemaleColumnChartArr));

            }



            // sparkline chart
            int[] fifteenDaysDefCntCountArrTotal = mainService.getFifteenDaysDefCntCountArrTotal(today, Controller.fifteenDaysDefCntCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage1", getSparkLineGraphStateAndPercentage(fifteenDaysDefCntCountArrTotal));
            model.addAttribute("defCntSparkLineArrTotal", fifteenDaysDefCntCountArrTotal);

            int[] fifteenDaysLocalOccCountArrTotal = mainService.getFifteenDaysLocalOccCountArrTotal(today, Controller.fifteenDaysLocalOccCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage2", getSparkLineGraphStateAndPercentage(fifteenDaysLocalOccCountArrTotal));
            model.addAttribute("localOccCountSparkLineArrTotal", fifteenDaysLocalOccCountArrTotal);

            int[] fifteenDaysOverFlowCountArrTotal = mainService.getFifteenDaysOverFlowCountArrTotal(today, Controller.fifteenDaysOverFlowCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage3", getSparkLineGraphStateAndPercentage(fifteenDaysOverFlowCountArrTotal));
            model.addAttribute("overFlowCountSparkLineArrTotal", fifteenDaysOverFlowCountArrTotal);

            int[] fifteenDaysDeathCountArrTotal = getFifteenDaysDeathCountArrTotal(mainService.getSixteenDaysDeathCountArrTotal(today, sixteenDaysDeathCountArrTotal), Controller.fifteenDaysDeathCountArrTotal);
            model.addAttribute("sparkLineStateAndPercentage4", getSparkLineGraphStateAndPercentage(fifteenDaysDeathCountArrTotal));
            model.addAttribute("deathCountSparkLineArrTotal", fifteenDaysDeathCountArrTotal);




            return "index";
        }



        private static SparkLineGraphStateAndPercentage getSparkLineGraphStateAndPercentage(int[] arr) {
            Integer today = Integer.valueOf(arr[14]);
            Integer yesterday = Integer.valueOf(arr[13]);
                //12(오늘)      10(어제) 20% 증가
            if (today > yesterday) {
                double percentage = (today.doubleValue() - yesterday.doubleValue()) / yesterday.doubleValue() * 100.0;
                log.info(String.format("%.2f", percentage) + "%");
                return new SparkLineGraphStateAndPercentage(1, String.format("%.2f", percentage) + "%", today - yesterday);

                //        10        20 50% 감소
            } else if (today < yesterday) {
                double percentage = (yesterday.doubleValue() - today.doubleValue()) / yesterday.doubleValue() * 100.0;
                log.info(String.format("%.2f", percentage) + "%");
                return new SparkLineGraphStateAndPercentage(-1, String.format("%.2f", percentage) + "%", yesterday - today);
            }
            // 같을때
            return new SparkLineGraphStateAndPercentage(0, "0.0%", 0);
        }

        private static EmptyRenderingVaccineDto getEmptyRenderingVaccineDto() {

            return new EmptyRenderingVaccineDto(
                    new EmptyVaccineBusanDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineChungbukDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineChungnamDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineDaeguDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineDaejeonDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineGangwonDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineGwangjuDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineGyeongbukDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineGyeonggiDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineGyeongnamDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineIncheonDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineJejuDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineJeonbukDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineJeonnamDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineSejongDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineSeoulDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineTotalDto("0.0", "0.0", "0.0"),
                    new EmptyVaccineUlsanDto("0.0", "0.0", "0.0"));
        }

        private static DateDto localDateToDateDto(LocalDate localDate) {
            String str = String.valueOf(localDate);
            String year = str.substring(0, 4);
            String month = str.substring(5, 7);
            String day = str.substring(8);

            return new DateDto(year, month, day);
        }

        private static String localDateToString1(LocalDate localDate) {

            String str = String.valueOf(localDate);
            String year = str.substring(0, 4);
            String month = str.substring(5, 7);
            String day = str.substring(8);

            return year + "/" + month + "/" + day;
        }

    private static String localDateToString2(LocalDate localDate) {

        String str = String.valueOf(localDate);
        String year = str.substring(0, 4);
        String month = str.substring(5, 7);
        String day = str.substring(8);

        return year + "년 " + month + "월 " + day + "일 기준 현황";
    }

        private static int[] getPieChartArr(RenderingGenderAndAgeDto renderingGenderAndAgeDto, int[] arr) {
            arr[0] =renderingGenderAndAgeDto.getEightySDto().getConfCase();
            arr[1] =renderingGenderAndAgeDto.getSeventySDto().getConfCase();
            arr[2] =renderingGenderAndAgeDto.getSixtySDto().getConfCase();
            arr[3] =renderingGenderAndAgeDto.getFiftySDto().getConfCase();
            arr[4] =renderingGenderAndAgeDto.getFortySDto().getConfCase();
            arr[5] =renderingGenderAndAgeDto.getThirtySDto().getConfCase();
            arr[6] =renderingGenderAndAgeDto.getTwentySDto().getConfCase();
            arr[7] =renderingGenderAndAgeDto.getTeenagersDto().getConfCase();
            arr[8] =renderingGenderAndAgeDto.getKidsDto().getConfCase();

            return arr;

        }

    private static int[] getColumnChartArr(RenderingGenderAndAgeDto renderingGenderAndAgeDto, int[] arr) {
        arr[0] =renderingGenderAndAgeDto.getMaleDto().getConfCase();
        arr[1] =renderingGenderAndAgeDto.getFemaleDto().getConfCase();

        return arr;

    }
        private static double[] getRadialBarChartArr(RenderingVaccineDto renderingVaccineDto, double[] arr) {
            double koreanPopulation = 51592660;

            double firstCount = renderingVaccineDto.getVaccineTotalDto().getTotalFirstCnt().doubleValue() / koreanPopulation * 100.0;
            arr[0] = Double.parseDouble(String.format("%.2f", firstCount));

            double secondCount = renderingVaccineDto.getVaccineTotalDto().getTotalSecondCnt().doubleValue() / koreanPopulation * 100.0;
            arr[1] = Double.parseDouble(String.format("%.2f", secondCount));

            double thirdCount = renderingVaccineDto.getVaccineTotalDto().getTotalThirdCnt().doubleValue() / koreanPopulation * 100.0;
            arr[2] = Double.parseDouble(String.format("%.2f", thirdCount));

            return arr;

        }

        private static int[] getFifteenDaysDeathCountArrTotal(int[] inputArr, int[] outputArr) {
            for (int i = 0; i < outputArr.length; i++) {
                outputArr[i] = inputArr[i + 1] - inputArr[i];
            }
            return outputArr;

        }

    private static Integer getDefCountSum(int[] arr, Integer defCountSum) {

        for (int i = 0; i < arr.length; i++)
            defCountSum += arr[i];

        return defCountSum;
    }


    private static LocalDate strToLocalDate(String dateRangePicker) {

        return LocalDate.parse(dateRangePicker);
    }

    private static TotalVaccineRateDto accumulateVaccineRate(Integer firstCount, Integer secondCount, Integer thirdCount) {
        double koreanPopulation = 51592660.0;

        Double firstRate = firstCount.doubleValue() / koreanPopulation * 100.0;
        Double secondRate = secondCount.doubleValue() / koreanPopulation * 100.0;
        Double thirdRate = thirdCount.doubleValue() / koreanPopulation * 100.0;

        String firstRateStr = String.format("%.2f", firstRate) + "%";

        String secondRateStr = String.format("%.2f", secondRate) + "%";

        String thirdRateStr = String.format("%.2f", thirdRate) + "%";

        return new TotalVaccineRateDto(firstRate, secondRate, thirdRate, firstRateStr, secondRateStr, thirdRateStr);
    }

    private static int[] getDonutChartArr(int totalIncDecCount, int incDecCountint, int[] arr) {
        arr[0] = (totalIncDecCount - incDecCountint);
        arr[1] = incDecCountint;
        return arr;
    }

    private static int[] getAllSidoTodayDefCountArr(RenderingSidoDto renderingSidoDto, int[] arr) {

        arr[0] = renderingSidoDto.getSeoulDto().getIncDec();
        arr[1] = renderingSidoDto.getGyeonggiDto().getIncDec();
        arr[2] = renderingSidoDto.getIncheonDto().getIncDec();
        arr[3] = renderingSidoDto.getSejongDto().getIncDec();
        arr[4] = renderingSidoDto.getBusanDto().getIncDec();
        arr[5] = renderingSidoDto.getUlsanDto().getIncDec();
        arr[6] = renderingSidoDto.getDaeguDto().getIncDec();
        arr[7] = renderingSidoDto.getGyeongbukDto().getIncDec();
        arr[8] = renderingSidoDto.getGyeongnamDto().getIncDec();
        arr[9] = renderingSidoDto.getDaejeonDto().getIncDec();
        arr[10] = renderingSidoDto.getChungbukDto().getIncDec();
        arr[11] = renderingSidoDto.getChungnamDto().getIncDec();
        arr[12] = renderingSidoDto.getGangwonDto().getIncDec();
        arr[13] = renderingSidoDto.getGwangjuDto().getIncDec();
        arr[14] = renderingSidoDto.getJeonbukDto().getIncDec();
        arr[15] = renderingSidoDto.getJeonnamDto().getIncDec();
        arr[16] = renderingSidoDto.getJejuDto().getIncDec();
        arr[17] = renderingSidoDto.getLazarettoDto().getIncDec();

        return arr;
    }

    private static String[] getMonthAndDayArr(LocalDate localDate, String[] arr) {

        for (int i = 0,  j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = customSubString(localDate.minusDays(j));
        }

        return arr;
    }

    private static String customSubString(LocalDate localDate) {
        return String.valueOf(localDate).substring(5);

    }


}










