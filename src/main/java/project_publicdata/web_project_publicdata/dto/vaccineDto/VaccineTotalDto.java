package project_publicdata.web_project_publicdata.dto.vaccineDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineTotalDto {

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
}
