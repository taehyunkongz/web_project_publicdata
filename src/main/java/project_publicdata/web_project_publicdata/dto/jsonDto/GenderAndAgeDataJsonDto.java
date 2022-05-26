package project_publicdata.web_project_publicdata.dto.jsonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderAndAgeDataJsonDto {

    private Integer confCase;
    private Double confCaseRate;
    private String createDate;
    private Double criticalRate;
    private Integer deathCnt;
    private Double deathRate;
    private String ageAndGender;
    private Integer seq;

}
