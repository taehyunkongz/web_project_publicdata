package project_publicdata.web_project_publicdata.entity.genderAndAge.age;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "TWENTYS_SEQ_GN",
        sequenceName = "TWENTYS_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class TwentyS {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BUSAN_SEQ_GN")
    @Column(name = "twentys_id")
    private Long id;

    private Integer confCase;
    private Double confCaseRate;
    private String createDate;
    private Double criticalRate;
    private Integer deathCnt;
    private Double deathRate;
    private String ageAndGender;
    private Integer seq;

    public TwentyS(Integer confCase, Double confCaseRate, String createDate, Double criticalRate, Integer deathCnt,
                   Double deathRate, String ageAndGender, Integer seq) {
        this.confCase = confCase;
        this.confCaseRate = confCaseRate;
        this.createDate = createDate;
        this.criticalRate = criticalRate;
        this.deathCnt = deathCnt;
        this.deathRate = deathRate;
        this.ageAndGender = ageAndGender;
        this.seq = seq;
    }
}
