package project_publicdata.web_project_publicdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VaccineDataJsonDto {

    private Integer accFirstCnt;
    private Integer accSecondCnt;
    private Integer accThirdCnt;

    private Integer firstCnt;
    private Integer secondCnt;
    private Integer thirdCnt;

    private Integer totalFirstCnt;
    private Integer totalSecondCnt;
    private Integer totalThirdCnt;

    private String sido;
    private String stdDay;

}
