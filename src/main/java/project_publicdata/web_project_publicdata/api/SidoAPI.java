package project_publicdata.web_project_publicdata.api;

import lombok.Data;

@Data
public class SidoAPI {

    private static final String apiUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson";
    private static final String key = "4heUg3tErf6IsV0dpCBUlEvFlhkNSTSepLHLzd7X7%2B4CiZwIOJryvJ%2Bvmj9qy0ou52OfqcxrpRQAPSszkMGvrQ%3D%3D";
    private static final String startDate = "20200401";
    public static String urlStr =  apiUrl +
            "?serviceKey=" + key +
            "&pageNo=1&numOfRows=20" +
            "&startCreateDt=" + startDate +
            "&endCreateDt=";
}
