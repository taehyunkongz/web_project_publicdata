package project_publicdata.web_project_publicdata.dto.sidoDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GangwonDto {

    private Integer defCnt;
    private Integer isolClearCnt;
    private Integer localOccCnt;
    private Integer deathCnt;
    private Integer overFlowCnt;

    private Integer incDec;

    private String gubun;
    private String gubunEn;

    private String qurRate;
}
