package project_publicdata.web_project_publicdata.service.init;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.api.VaccineAPI;
import project_publicdata.web_project_publicdata.dto.jsonDto.VaccineDataJsonDto;
import project_publicdata.web_project_publicdata.entity.vaccine.*;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InitVaccineService {

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

    @Transactional
    public void initVaccineService() throws ParseException, IOException {

        String vaccineJsonString = getVaccineJsonString(VaccineAPI.urlStr);
        JSONArray vaccineJsonArray = getVaccineJsonArray(vaccineJsonString);

        for (int i = 0; i < vaccineJsonArray.size(); i++) {
            JSONObject tmp = (JSONObject) vaccineJsonArray.get(i);
            VaccineDataJsonDto vaccineDataJsonDto = getVaccineDataJsonDto(tmp);
            String sido = vaccineDataJsonDto.getSido();

            saveVaccineEntity(tmp, sido);
        }

    }

    private void saveVaccineEntity(JSONObject tmp, String sido) {
        if (sido.equals("부산광역시")) {
            saveVaccineBusanEntity(tmp);

        } else if (sido.equals("충청북도")) {
            saveVaccineChungbukEntity(tmp);

        } else if (sido.equals("충청남도")) {
            saveVaccineChungnamEntity(tmp);

        } else if (sido.equals("대구광역시")) {
            saveVaccineDaeguEntity(tmp);

        } else if (sido.equals("대전광역시")) {
            saveVaccineDaejeonEntity(tmp);

        } else if (sido.equals("강원도")) {
            saveVaccineGangwonEntity(tmp);

        } else if (sido.equals("광주광역시")) {
            saveVaccineGwangjuEntity(tmp);

        } else if (sido.equals("경기도")) {
            saveVaccineGyeonggiEntity(tmp);

        } else if (sido.equals("경상북도")) {
            saveVaccineGyeongbukEntity(tmp);

        } else if (sido.equals("경상남도")) {
            saveVaccineGyeongnamEntity(tmp);

        } else if (sido.equals("인천광역시")) {
            saveVaccineIncheonEntity(tmp);

        } else if (sido.equals("제주특별자치도")) {
            saveVaccineJejuEntity(tmp);

        } else if (sido.equals("전라북도")) {
            saveVaccineJeonbukEntity(tmp);

        } else if (sido.equals("전라남도")) {
            saveVaccineJeonnamEntity(tmp);

        } else if (sido.equals("세종특별자치시")) {
            saveVaccineSejongEntity(tmp);

        } else if (sido.equals("서울특별시")) {
            saveVaccineSeoulEntity(tmp);

        } else if (sido.equals("전국")) {
            saveVaccineTotalEntity(tmp);

        } else if (sido.equals("울산광역시")) {
            saveVaccineUlsanEntity(tmp);
        }
    }



    private VaccineBusan getVaccineBusan(JSONObject tmp) {
        return new VaccineBusan(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineBusanEntity(JSONObject tmp) {
        vaccineBusanRepository.save(getVaccineBusan(tmp));
    }


    private VaccineChungbuk getVaccineChungbuk(JSONObject tmp) {
        return new VaccineChungbuk(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineChungbukEntity(JSONObject tmp) {
        vaccineChungbukRepository.save(getVaccineChungbuk(tmp));
    }

    private VaccineChungnam getVaccineChungnam(JSONObject tmp) {
        return new VaccineChungnam(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineChungnamEntity(JSONObject tmp) {
        vaccineChungnamRepository.save(getVaccineChungnam(tmp));
    }

    private VaccineDaegu getVaccineDaegu(JSONObject tmp) {
        return new VaccineDaegu(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineDaeguEntity(JSONObject tmp) {
        vaccineDaeguRepository.save(getVaccineDaegu(tmp));
    }

    private VaccineDaejeon getVaccineDaejeon(JSONObject tmp) {
        return new VaccineDaejeon(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineDaejeonEntity(JSONObject tmp) {
        vaccineDaejeonRepository.save(getVaccineDaejeon(tmp));
    }

    private VaccineGangwon getVaccineGangwon(JSONObject tmp) {
        return new VaccineGangwon(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineGangwonEntity(JSONObject tmp) {
        vaccineGangwonRepository.save(getVaccineGangwon(tmp));
    }

    private VaccineGwangju getVaccineGwangju(JSONObject tmp) {
        return new VaccineGwangju(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineGwangjuEntity(JSONObject tmp) {
        vaccineGwangjuRepository.save(getVaccineGwangju(tmp));
    }

    private VaccineGyeongbuk getVaccineGyeongbuk(JSONObject tmp) {
        return new VaccineGyeongbuk(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineGyeongbukEntity(JSONObject tmp) {
        vaccineGyeongbukRepository.save(getVaccineGyeongbuk(tmp));
    }

    private VaccineGyeonggi getVaccineGyeonggi(JSONObject tmp) {
        return new VaccineGyeonggi(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineGyeonggiEntity(JSONObject tmp) {
        vaccineGyeonggiRepository.save(getVaccineGyeonggi(tmp));
    }

    private VaccineGyeongnam getVaccineGyeongnam(JSONObject tmp) {
        return new VaccineGyeongnam(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineGyeongnamEntity(JSONObject tmp) {
        vaccineGyeongnamRepository.save(getVaccineGyeongnam(tmp));
    }

    private VaccineIncheon getVaccineIncheon(JSONObject tmp) {
        return new VaccineIncheon(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineIncheonEntity(JSONObject tmp) {
        vaccineIncheonRepository.save(getVaccineIncheon(tmp));
    }

    private VaccineJeju getVaccineJeju(JSONObject tmp) {
        return new VaccineJeju(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineJejuEntity(JSONObject tmp) {
        vaccineJejuRepository.save(getVaccineJeju(tmp));
    }

    private VaccineJeonbuk getVaccineJeonbuk(JSONObject tmp) {
        return new VaccineJeonbuk(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineJeonbukEntity(JSONObject tmp) {
        vaccineJeonbukRepository.save(getVaccineJeonbuk(tmp));
    }

    private VaccineJeonnam getVaccineJeonnam(JSONObject tmp) {
        return new VaccineJeonnam(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineJeonnamEntity(JSONObject tmp) {
        vaccineJeonnamRepository.save(getVaccineJeonnam(tmp));
    }

    private VaccineSejong getVaccineSejong(JSONObject tmp) {
        return new VaccineSejong(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineSejongEntity(JSONObject tmp) {
        vaccineSejongRepository.save(getVaccineSejong(tmp));
    }

    private VaccineSeoul getVaccineSeoul(JSONObject tmp) {
        return new VaccineSeoul(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineSeoulEntity(JSONObject tmp) {
        vaccineSeoulRepository.save(getVaccineSeoul(tmp));
    }

    private VaccineTotal getVaccineTotal(JSONObject tmp) {
        return new VaccineTotal(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));
    }

    @Transactional
    public void saveVaccineTotalEntity(JSONObject tmp) {
        vaccineTotalRepository.save(getVaccineTotal(tmp));
    }

    private VaccineUlsan getVaccineUlsan(JSONObject tmp) {
        return new VaccineUlsan(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("baseDate")).substring(0, 10))));

    }

    @Transactional
    public void saveVaccineUlsanEntity(JSONObject tmp) {
        vaccineUlsanRepository.save(getVaccineUlsan(tmp));
    }


    private static JSONArray getVaccineJsonArray(String jsonString) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
        Long pageNo = (Long) jsonObject.get("page");
        Long totalCount = (Long) jsonObject.get("totalCount");
        Long matchCount = (Long) jsonObject.get("matchCount");
        Long perPage = (Long) jsonObject.get("perPage");
        Long currentCount = (Long) jsonObject.get("currentCount");
        JSONArray data = (JSONArray) jsonObject.get("data");

        return data;
    }

    private VaccineDataJsonDto getVaccineDataJsonDto(JSONObject tmp) {
        return new VaccineDataJsonDto(
                Integer.parseInt(String.valueOf(tmp.get("accumulatedFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("accumulatedThirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("firstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("secondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("thirdCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalFirstCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalSecondCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("totalThirdCnt"))),

                String.valueOf(tmp.get("sido")),
                String.valueOf(tmp.get("baseDate")));
    }

    public static String getVaccineJsonString(String urlStr) throws IOException {
        String result;
        URL url = new URL(urlStr);
        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        result = bf.readLine();

        return result;
    }

    private static String subStringCustom(String str) {
        String year = str.substring(0, 4);
        String month = str.substring(5, 7);
        String day = str.substring(8, 10);

        return year + "-" + month + "-" + day;
    }
}
