package project_publicdata.web_project_publicdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SparkLineGraphStateAndPercentage {
    Integer incAndDecState;
    String percentage;
    Integer subValue;

}
