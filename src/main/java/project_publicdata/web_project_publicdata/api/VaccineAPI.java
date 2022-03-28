package project_publicdata.web_project_publicdata.api;

import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class VaccineAPI {

    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String apiUrl = "https://api.odcloud.kr/api/15077756/v1/vaccine-stat";
    private static final String key = "4heUg3tErf6IsV0dpCBUlEvFlhkNSTSepLHLzd7X7%2B4CiZwIOJryvJ%2Bvmj9qy0ou52OfqcxrpRQAPSszkMGvrQ%3D%3D";
    public static String urlStr =  apiUrl +
            "?page=1&perPage=8000" +
            "&serviceKey=" + key;


}
