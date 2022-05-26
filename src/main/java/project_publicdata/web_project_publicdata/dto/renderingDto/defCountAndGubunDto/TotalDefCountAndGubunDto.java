package project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalDefCountAndGubunDto {
    private Integer incDec;
    private String gubun;
    private Integer deathCnt;
    private Integer localOccCnt;
    private Integer overFlowCnt;
    private Integer defCnt;
}
