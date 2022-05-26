package project_publicdata.web_project_publicdata.dto.renderingDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalVaccineRateDto {
    private Double totalVaccineFirstRate;
    private Double totalVaccineSecondRate;
    private Double totalVaccineThirdRate;

    private String totalVaccineFirstRateStr;
    private String totalVaccineSecondRateStr;
    private String totalVaccineThirdRateStr;

}
