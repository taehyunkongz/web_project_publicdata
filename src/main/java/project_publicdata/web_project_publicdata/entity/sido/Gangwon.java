package project_publicdata.web_project_publicdata.entity.sido;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import project_publicdata.web_project_publicdata.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "GANGWON_SEQ_GN",
        sequenceName = "GANGWON_SEQ",
        initialValue = 1,
        allocationSize = 1
)

public class Gangwon extends BaseTimeEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "GANGWON_SEQ_GN"
    )
    @Column(name = "gangwon_id")
    private Long id;
    private Integer defCnt;
    private Integer localOccCnt;
    private Integer incDec;
    private String gubun;
    private String gubunEn;
    private Integer deathCnt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String qurRate;
    private Integer overFlowCnt;
    private String gubunCn;
    private Integer seq;

    public Gangwon(Integer defCnt, Integer localOccCnt, Integer incDec, String gubun, String gubunEn,
                   Integer deathCnt, LocalDate date, String qurRate, Integer overFlowCnt, String gubunCn, Integer seq) {
        this.defCnt = defCnt;
        this.localOccCnt = localOccCnt;
        this.incDec = incDec;
        this.gubun = gubun;
        this.gubunEn = gubunEn;
        this.deathCnt = deathCnt;
        this.date = date;
        this.qurRate = qurRate;
        this.overFlowCnt = overFlowCnt;
        this.gubunCn = gubunCn;
        this.seq = seq;
    }

}
