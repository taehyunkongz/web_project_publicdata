package project_publicdata.web_project_publicdata.repository.sidoRepository.jejuRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.JejuDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.JejuDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QJeju.jeju;

@RequiredArgsConstructor
public class JejuRepositoryCustomImpl implements JejuRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countJejuDefCnt() {
        return queryFactory
                .select(jeju.defCnt)
                .from(jeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJejuDeathCnt() {
        return queryFactory
                .select(jeju.deathCnt)
                .from(jeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJejuIncdec() {
        return queryFactory
                .select(jeju.incDec)
                .from(jeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJejuOverflowCnt() {
        return queryFactory
                .select(jeju.overFlowCnt)
                .from(jeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<JejuDefCountAndGubunDto> getDefCountAndGubunJeju(DateDto date) {
        return queryFactory
                .select(Projections.fields(JejuDefCountAndGubunDto.class,
                        jeju.incDec,
                        jeju.gubun))
                .from(jeju)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<JejuDto> getAllCountJeju(DateDto date) {
        return queryFactory
                .select(Projections.fields(JejuDto.class,
                        jeju.deathCnt,
                        jeju.defCnt,
                        jeju.incDec,
                        jeju.localOccCnt,
                        jeju.overFlowCnt,
                        jeju.qurRate,
                        jeju.gubun,
                        jeju.gubunEn))
                .from(jeju)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return jeju.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return jeju.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return jeju.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return jeju.date.eq(condition);

    }
}
