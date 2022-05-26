package project_publicdata.web_project_publicdata.entity.genderAndAge.age;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "KIDS_SEQ_GN",
        sequenceName = "KIDS_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Kids {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "KIDS_SEQ_GN")
    @Column(name = "kids_id")
    private Long id;

    private Integer confCase;
    private Double confCaseRate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double criticalRate;
    private Integer deathCnt;
    private Double deathRate;
    private String genderAndAge;
    private Integer seq;

    public Kids(Integer confCase, Double confCaseRate, LocalDate date, Double criticalRate, Integer deathCnt,
                Double deathRate, String genderAndAge, Integer seq) {
        this.confCase = confCase;
        this.confCaseRate = confCaseRate;
        this.date = date;
        this.criticalRate = criticalRate;
        this.deathCnt = deathCnt;
        this.deathRate = deathRate;
        this.genderAndAge = genderAndAge;
        this.seq = seq;
    }
}
