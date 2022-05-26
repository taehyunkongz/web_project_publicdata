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
import project_publicdata.web_project_publicdata.api.GenderAndAgeAPI;
import project_publicdata.web_project_publicdata.dto.jsonDto.GenderAndAgeDataJsonDto;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.*;
import project_publicdata.web_project_publicdata.entity.genderAndAge.gender.Female;
import project_publicdata.web_project_publicdata.entity.genderAndAge.gender.Male;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InitGenderAndAgeService {

    private final MaleRepository maleRepository;

    private final FemaleRepository femaleRepository;

    private final EightySRepository eightySRepository;

    private final SeventySRepository seventySRepository;

    private final SixtySRepository sixtySRepository;

    private final FiftySRepository fiftySRepository;

    private final FortySRepository fortySRepository;

    private final ThirtySRepository thirtySRepository;

    private final TwentySRepository twentySRepository;

    private final TeenagersRepository teenagersRepository;

    private final KidsRepository kidsRepository;

    private static String getGenderAndAgeAPIUrlStr() {

        String str = String.valueOf(LocalDate.now().minusDays(1));

        String year = str.substring(0, 4);
        String month = str.substring(5, 7);
        String day = str.substring(8);

        String today = year + month + day;

        return GenderAndAgeAPI.urlStr + today;
    }

    @Transactional
    public void initSidoService() throws ParseException, IOException {

        String genderJsonString = getGenderAndAgeJsonString(getGenderAndAgeAPIUrlStr());
        JSONArray genderJsonArray = getGenderJsonArray(genderJsonString);

        for (int i = 0; i < genderJsonArray.size(); i++) {
            JSONObject tmp = (JSONObject) genderJsonArray.get(i);
            GenderAndAgeDataJsonDto genderDataJsonDto = getGenderDataJsonDto(tmp); // 굳이 전체 데이터를 Dto에 저장할 필요가 있읅까? getAgeAndGender에 필요한 데이터만 있어도 되지 않을까?
            String ageAndGender = genderDataJsonDto.getAgeAndGender();

            saveGenderAndAgeEntity(tmp, ageAndGender);
        }
    }

    public static String getGenderAndAgeJsonString(String urlStr) throws IOException {
        String result;
        URL url = new URL(urlStr);
        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        result = bf.readLine();
        String jsonString = xmlGenderAndAgeToJson(result);

        return jsonString;
    }

    public static String xmlGenderAndAgeToJson(String str) throws JsonProcessingException {
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

    private GenderAndAgeDataJsonDto getGenderDataJsonDto(JSONObject tmp) {
        return new GenderAndAgeDataJsonDto(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                String.valueOf(tmp.get("createDt")),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq")))
        );
    }

    private static JSONArray getGenderJsonArray(String jsonString) throws ParseException {
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

    private void saveGenderAndAgeEntity(JSONObject tmp, String ageAndGender) {
        if (ageAndGender.equals("남성")) {
            saveMaleEntity(tmp);

        } else if (ageAndGender.equals("여성")) {
            saveFemaleEntity(tmp);

        } else if (ageAndGender.equals("80 이상")) {
            saveEightySEntity(tmp);

        } else if (ageAndGender.equals("70-79")) {
            saveSeventySEntity(tmp);

        } else if (ageAndGender.equals("60-69")) {
            saveSixtySEntity(tmp);

        } else if (ageAndGender.equals("50-59")) {
            saveFiftySEntity(tmp);

        } else if (ageAndGender.equals("40-49")) {
            saveFortySEntity(tmp);

        } else if (ageAndGender.equals("30-39")) {
            saveThirtySEntity(tmp);

        } else if (ageAndGender.equals("20-29")) {
            saveTwentySEntity(tmp);

        } else if (ageAndGender.equals("10-19")) {
            saveTeenagersEntity(tmp);

        } else if (ageAndGender.equals("0-9")) {
            saveKidsEntity(tmp);
        }
    }

    private Male getMale(JSONObject tmp) {
        return new Male(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveMaleEntity(JSONObject tmp) {
        maleRepository.save(getMale(tmp));
    }

    private Female getFemale(JSONObject tmp) {
        return new Female(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveFemaleEntity(JSONObject tmp) {
        femaleRepository.save(getFemale(tmp));
    }

    private EightyS getEightyS(JSONObject tmp) {
        return new EightyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveEightySEntity(JSONObject tmp) {
        eightySRepository.save(getEightyS(tmp));
    }

    private SeventyS getSeventyS(JSONObject tmp) {
        return new SeventyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveSeventySEntity(JSONObject tmp) {
        seventySRepository.save(getSeventyS(tmp));
    }

    private SixtyS getSixtyS(JSONObject tmp) {
        return new SixtyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveSixtySEntity(JSONObject tmp) {
        sixtySRepository.save(getSixtyS(tmp));
    }

    private FiftyS getFiftyS(JSONObject tmp) {
        return new FiftyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveFiftySEntity(JSONObject tmp) {
        fiftySRepository.save(getFiftyS(tmp));
    }

    private FortyS getFortyS(JSONObject tmp) {
        return new FortyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveFortySEntity(JSONObject tmp) {
        fortySRepository.save(getFortyS(tmp));
    }

    private ThirtyS getThirtyS(JSONObject tmp) {
        return new ThirtyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveThirtySEntity(JSONObject tmp) {
        thirtySRepository.save(getThirtyS(tmp));
    }

    private TwentyS getTwentyS(JSONObject tmp) {
        return new TwentyS(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveTwentySEntity(JSONObject tmp) {
        twentySRepository.save(getTwentyS(tmp));
    }

    private Teenagers getTeenagers(JSONObject tmp) {
        return new Teenagers(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveTeenagersEntity(JSONObject tmp) {
        teenagersRepository.save(getTeenagers(tmp));
    }

    private Kids getKids(JSONObject tmp) {
        return new Kids(
                Integer.parseInt(String.valueOf(tmp.get("confCase"))),
                Double.parseDouble(String.valueOf(tmp.get("confCaseRate"))),
                LocalDate.parse(subStringCustom(String.valueOf(tmp.get("createDt")).substring(0, 10))),
                Double.parseDouble(String.valueOf(tmp.get("criticalRate"))),
                Integer.parseInt(String.valueOf(tmp.get("death"))),
                Double.parseDouble(String.valueOf(tmp.get("deathRate"))),
                String.valueOf(tmp.get("gubun")),
                Integer.parseInt(String.valueOf(tmp.get("seq"))));
    }

    @Transactional
    public void saveKidsEntity(JSONObject tmp) {
        kidsRepository.save(getKids(tmp));

    }

    private static String subStringCustom(String str) {
        String year = str.substring(0, 4);
        String month = str.substring(5, 7);
        String day = str.substring(8, 10);

        return year + "-" + month + "-" + day;
    }


}
