package project_publicdata.web_project_publicdata.entity.genderAndAge.gender;


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
        name = "MALE_SEQ_GN",
        sequenceName = "MALE_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Male {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MALE_SEQ_GN")
    @Column(name = "male_id")
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

    public Male(Integer confCase, Double confCaseRate, LocalDate date, Double criticalRate, Integer deathCnt,
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
