package project_publicdata.web_project_publicdata.dto.renderingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalVaccineCountDto {
    private Integer firstCnt;
    private Integer secondCnt;
    private Integer thirdCnt;

}
