package project_publicdata.web_project_publicdata.entity.vaccine;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "VACCINE_GYEONGNAM_SEQ_GN",
        sequenceName = "VACCINE_GYEONGNAM_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class VaccineGyeongnam {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "VACCINE_GYEONGNAM_SEQ_GN"
    )
    @Column(name = "vaccine_gyeongnam_id")
    private Long id;

    private Integer accFirstCnt;
    private Integer accSecondCnt;
    private Integer accThirdCnt;

    private Integer firstCnt;
    private Integer secondCnt;
    private Integer thirdCnt;

    private Integer totalFirstCnt;
    private Integer totalSecondCnt;
    private Integer totalThirdCnt;

    private String sido;
    private String stdDay;

    public VaccineGyeongnam(Integer accFirstCnt, Integer accSecondCnt, Integer accThirdCnt, Integer firstCnt, Integer secondCnt,
                            Integer thirdCnt, Integer totalFirstCnt, Integer totalSecondCnt, Integer totalThirdCnt, String sido, String stdDay) {
        this.accFirstCnt = accFirstCnt;
        this.accSecondCnt = accSecondCnt;
        this.accThirdCnt = accThirdCnt;
        this.firstCnt = firstCnt;
        this.secondCnt = secondCnt;
        this.thirdCnt = thirdCnt;
        this.totalFirstCnt = totalFirstCnt;
        this.totalSecondCnt = totalSecondCnt;
        this.totalThirdCnt = totalThirdCnt;
        this.sido = sido;
        this.stdDay = stdDay;
    }
}