package project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeventySDto {

    private Integer confCase;
    private Double confCaseRate;

    private Double criticalRate;

    private Integer deathCnt;
    private Double deathRate;

    private String ageAndGender;
}
