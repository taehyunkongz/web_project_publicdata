package project_publicdata.web_project_publicdata.entity.sido;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import project_publicdata.web_project_publicdata.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

import static org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "BUSAN_SEQ_GN",
        sequenceName = "BUSAN_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Busan extends BaseTimeEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BUSAN_SEQ_GN")
    @Column(name = "busan_id")
    private Long id;

    private Integer defCnt;
    private Integer isolClearCnt;
    private Integer localOccCnt;
    private Integer incDec;
    private String gubun;
    private String gubunEn;
    private Integer deathCnt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime stdDay;

    private String qurRate;
    private Integer overFlowCnt;
    private String gubunCn;
    private Integer seq;

    public Busan(Integer defCnt, Integer isolClearCnt, Integer localOccCnt, Integer incDec, String gubun, String gubunEn,
                 Integer deathCnt, LocalDateTime stdDay, String qurRate, Integer overFlowCnt, String gubunCn, Integer seq) {
        this.defCnt = defCnt;
        this.isolClearCnt = isolClearCnt;
        this.localOccCnt = localOccCnt;
        this.incDec = incDec;
        this.gubun = gubun;
        this.gubunEn = gubunEn;
        this.deathCnt = deathCnt;
        this.stdDay = stdDay;
        this.qurRate = qurRate;
        this.overFlowCnt = overFlowCnt;
        this.gubunCn = gubunCn;
        this.seq = seq;
    }

}
