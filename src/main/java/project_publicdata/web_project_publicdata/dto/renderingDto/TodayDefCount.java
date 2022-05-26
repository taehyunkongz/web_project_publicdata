package project_publicdata.web_project_publicdata.dto.renderingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodayDefCount {

    @Column(nullable = false)
    private Integer seoulDefCnt;

    @Column(nullable = false)
    private Integer gyeonggiDefCnt;

    @Column(nullable = false)
    private Integer incheonDefCnt;

    @Column(nullable = false)
    private Integer sejongDefCnt;

    @Column(nullable = false)
    private Integer busanDefCnt;

    @Column(nullable = false)
    private Integer ulsanDefCnt;

    @Column(nullable = false)
    private Integer daeguDefCnt;

    @Column(nullable = false)
    private Integer gyeongbukDefCnt;

    @Column(nullable = false)
    private Integer gyeongnamDefCnt;

    @Column(nullable = false)
    private Integer daejeonDefCnt;

    @Column(nullable = false)
    private Integer chungbukDefCnt;

    @Column(nullable = false)
    private Integer chungnamDefCnt;

    @Column(nullable = false)
    private Integer gangwonDefCnt;

    @Column(nullable = false)
    private Integer gwangjuDefCnt;

    @Column(nullable = false)
    private Integer jeonbukDefCnt;

    @Column(nullable = false)
    private Integer jeonnamDefCnt;

    @Column(nullable = false)
    private Integer jejuDefCnt;

    @Column(nullable = false)
    private Integer lazarettoDefCnt;

}
