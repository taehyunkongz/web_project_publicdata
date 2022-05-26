package project_publicdata.web_project_publicdata.dto.jsonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SidoDataJsonDto {

    private Integer defCnt;
    private Integer localOccCnt;
    private Integer incDec;
    private String gubun;
    private String gubunEn;
    private Integer deathCnt;
    private LocalDateTime stdDay;
    private String qurRate;
    private Integer overFlowCnt;
    private String gubunCn;
    private Integer seq;

}
