package project_publicdata.web_project_publicdata.service.init;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_publicdata.web_project_publicdata.api.SidoAPI;
import project_publicdata.web_project_publicdata.dto.jsonDto.SidoDataJsonDto;
import project_publicdata.web_project_publicdata.entity.sido.*;
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

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InitSidoService {

    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시");

    private final EntityManager em;

    private final BusanRepository busanRepository;

    private final ChungbukRepository chungbukRepository;

    private final ChungnamRepository chungnamRepository;

    private final DaeguRepository daeguRepository;

    private final DaejeonRepository daejeonRepository;

    private final GangwonRepository gangwonRepository;

    private final GwangjuRepository gwangjuRepository;

    private final GyeonggiRepository gyeonggiRepository;

    private final GyeongbukRepository gyeongbukRepository;

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

    private static String getSidoAPIUrlStr() {

        String str = String.valueOf(LocalDate.now().minusDays(1));

        String year = str.substring(0, 4);
        String month = str.substring(5, 7);
        String day = str.substring(8);

        String today = year + month + day;

        return SidoAPI.urlStr + today;
    }


    @Transactional
    public void initSidoService() throws ParseException, IOException {

        String sidoJsonString = getSidoJsonString(getSidoAPIUrlStr());
        JSONArray sidoJsonArray = getSidoJsonArray(sidoJsonString);

        for (int i = 0; i < sidoJsonArray.size(); i++) {
            JSONObject tmp = (JSONObject) sidoJsonArray.get(i);
            SidoDataJsonDto sidoDataJsonDto = getSidoDataJsonDto(tmp);
            String gubunEn = sidoDataJsonDto.getGubunEn();

            saveSidoEntity(tmp, gubunEn);
        }

    }

    private void saveSidoEntity(JSONObject tmp, String gubunEn) {
        if (gubunEn.equals("Busan")) {
            saveBusanEntity(tmp);

        } else if (gubunEn.equals("Chungcheongbuk-do")) {
            saveChungbukEntity(tmp);

        } else if (gubunEn.equals("Chungcheongnam-do")) {
            saveChungnamEntity(tmp);

        } else if (gubunEn.equals("Daegu")) {
            saveDaeguEntity(tmp);

        } else if (gubunEn.equals("Daejeon")) {
            saveDaejeonEntity(tmp);

        } else if (gubunEn.equals("Gangwon-do")) {
            saveGangwonEntity(tmp);

        } else if (gubunEn.equals("Gwangju")) {
            saveGwangjuEntity(tmp);

        } else if (gubunEn.equals("Gyeonggi-do")) {
            saveGyeonggiEntity(tmp);

        } else if (gubunEn.equals("Gyeongsangbuk-do")) {
            saveGyeongbukEntity(tmp);

        } else if (gubunEn.equals("Gyeongsangnam-do")) {
            saveGyeongnamEntity(tmp);

        } else if (gubunEn.equals("Incheon")) {
            saveIncheonEntity(tmp);

        } else if (gubunEn.equals("Jeju")) {
            saveJejuEntity(tmp);

        } else if (gubunEn.equals("Jeollabuk-do")) {
            saveJeonbukEntity(tmp);

        } else if (gubunEn.equals("Jeollanam-do")) {
            saveJeonnamEntity(tmp);

        } else if (gubunEn.equals("Lazaretto")) {
            saveLazarettoEntity(tmp);

        } else if (gubunEn.equals("Sejong")) {
            saveSejongEntity(tmp);

        } else if (gubunEn.equals("Seoul")) {
            saveSeoulEntity(tmp);

        } else if (gubunEn.equals("Total")) {
            saveTotalEntity(tmp);

        } else if (gubunEn.equals("Ulsan")) {
            saveUlsanEntity(tmp);
        }
    }

    public static String getSidoJsonString(String urlStr) throws IOException {
        String result;
        URL url = new URL(urlStr);
        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        result = bf.readLine();
        String jsonString = xmlSidoToJson(result);
        return jsonString;
    }

    public static String xmlSidoToJson(String str) throws JsonProcessingException {
        try {
            String xml = str;
            org.json.JSONObject jsonObject = XML.toJSONObject(xml);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            Object json = mapper.readValue(jsonObject.toString(), Object.class);
            String output = mapper.writeValueAsString(json);
            return output;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Transactional
    public void saveUlsanEntity(JSONObject tmp) {
        ulsanRepository.save(getUlsan(tmp));
    }

    private Ulsan getUlsan(JSONObject tmp) {
        return new Ulsan(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveTotalEntity(JSONObject tmp) {
        totalRepository.save(getTotal(tmp));
    }

    private Total getTotal(JSONObject tmp) {
        return new Total(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveSeoulEntity(JSONObject tmp) {
        seoulRepository.save(getSeoul(tmp));
    }

    private Seoul getSeoul(JSONObject tmp) {
        return new Seoul(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    public void saveSejongEntity(JSONObject tmp) {
        sejongRepository.save(getSejong(tmp));
    }

    private Sejong getSejong(JSONObject tmp) {
        return new Sejong(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveLazarettoEntity(JSONObject tmp) {
        lazarettoRepository.save(getLazaretto(tmp));
    }

    private Lazaretto getLazaretto(JSONObject tmp) {
        return new Lazaretto(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveJeonnamEntity(JSONObject tmp) {
        jeonnamRepository.save(getJeonnam(tmp));
    }

    private Jeonnam getJeonnam(JSONObject tmp) {
        return new Jeonnam(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveJeonbukEntity(JSONObject tmp) {
        jeonbukRepository.save(getJeonbuk(tmp));
    }

    private Jeonbuk getJeonbuk(JSONObject tmp) {
        return new Jeonbuk(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveJejuEntity(JSONObject tmp) {
        jejuRepository.save(getJeju(tmp));
    }

    private Jeju getJeju(JSONObject tmp) {
        return new Jeju(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveIncheonEntity(JSONObject tmp) {
        incheonRepository.save(getIncheon(tmp));
    }

    private Incheon getIncheon(JSONObject tmp) {
        return new Incheon(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveGyeongnamEntity(JSONObject tmp) {
        gyeongnamRepository.save(getGyeongnam(tmp));
    }

    private Gyeongnam getGyeongnam(JSONObject tmp) {
        return new Gyeongnam(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveGyeongbukEntity(JSONObject tmp) {
        gyeongbukRepository.save(getGyeongbuk(tmp));
    }

    private Gyeongbuk getGyeongbuk(JSONObject tmp) {
        return new Gyeongbuk(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveGyeonggiEntity(JSONObject tmp) {
        gyeonggiRepository.save(getGyeonggi(tmp));
    }

    private Gyeonggi getGyeonggi(JSONObject tmp) {
        return new Gyeonggi(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveGwangjuEntity(JSONObject tmp) {
        gwangjuRepository.save(getGwangju(tmp));
    }

    private Gwangju getGwangju(JSONObject tmp) {
        return new Gwangju(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveGangwonEntity(JSONObject tmp) {
        gangwonRepository.save(getGangwon(tmp));
    }

    private Gangwon getGangwon(JSONObject tmp) {
        return new Gangwon(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveDaejeonEntity(JSONObject tmp) {
        daejeonRepository.save(getDaejeon(tmp));
    }

    private Daejeon getDaejeon(JSONObject tmp) {
        return new Daejeon(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveDaeguEntity(JSONObject tmp) {
        daeguRepository.save(getDaegu(tmp));
    }

    private Daegu getDaegu(JSONObject tmp) {
        return new Daegu(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveChungnamEntity(JSONObject tmp) {
        chungnamRepository.save(getChungnam(tmp));
    }

    private Chungnam getChungnam(JSONObject tmp) {
        return new Chungnam(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveChungbukEntity(JSONObject tmp) {
        chungbukRepository.save(getChungbuk(tmp));
    }

    private Chungbuk getChungbuk(JSONObject tmp) {
        return new Chungbuk(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveBusanEntity(JSONObject tmp) {
        busanRepository.save(getBusan(tmp));
    }

    private Busan getBusan(JSONObject tmp) {
        return new Busan(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("stdDay")).substring(0, 13))),
                String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))),
                String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }


    private SidoDataJsonDto getSidoDataJsonDto(JSONObject tmp) {
        return new SidoDataJsonDto(
                Integer.parseInt(String.valueOf(tmp.get("defCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("localOccCnt"))),
                Integer.parseInt(String.valueOf(tmp.get("incDec"))),
                String.valueOf(tmp.get("gubun")),
                String.valueOf(tmp.get("gubunEn")),
                Integer.parseInt(String.valueOf(tmp.get("deathCnt"))),
                LocalDateTime.parse(String.valueOf(tmp.get("stdDay")), formatter2), String.valueOf(tmp.get("qurRate")),
                Integer.parseInt(String.valueOf(tmp.get("overFlowCnt"))), String.valueOf(tmp.get("gubunCn")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }



    private static JSONArray getSidoJsonArray(String jsonString) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONObject body = (JSONObject) response.get("body");
        Long pageNo = (Long) body.get("pageNo");
        Long totalCount = (Long) body.get("totalCount");
        JSONObject items = (JSONObject) body.get("items");
        JSONArray item = (JSONArray) items.get("item");
        return item;
    }

    private static String subStringCustom(String str) {
        String year = str.substring(0, 4);
        String month = str.substring(6, 8);
        String day = str.substring(10, 12);

        return year + "-" + month + "-" + day;
    }

}
