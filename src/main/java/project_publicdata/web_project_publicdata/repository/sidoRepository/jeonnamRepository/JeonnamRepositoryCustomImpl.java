package project_publicdata.web_project_publicdata.repository.sidoRepository.jeonnamRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.JeonnamDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.JeonnamDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QJeonnam.jeonnam;

@RequiredArgsConstructor
public class JeonnamRepositoryCustomImpl implements JeonnamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countJeonnamDefCnt() {
        return queryFactory
                .select(jeonnam.defCnt)
                .from(jeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJeonnamDeathCnt() {
        return queryFactory
                .select(jeonnam.deathCnt)
                .from(jeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJeonnamIncdec() {
        return queryFactory
                .select(jeonnam.incDec)
                .from(jeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJeonnamOverflowCnt() {
        return queryFactory
                .select(jeonnam.overFlowCnt)
                .from(jeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<JeonnamDefCountAndGubunDto> getDefCountAndGubunJeonnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(JeonnamDefCountAndGubunDto.class,
                        jeonnam.incDec,
                        jeonnam.gubun))
                .from(jeonnam)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<JeonnamDto> getAllCountJeonnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(JeonnamDto.class,
                        jeonnam.deathCnt,
                        jeonnam.defCnt,
                        jeonnam.incDec,
                        jeonnam.localOccCnt,
                        jeonnam.overFlowCnt,
                        jeonnam.qurRate,
                        jeonnam.gubun,
                        jeonnam.gubunEn))
                .from(jeonnam)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return jeonnam.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return jeonnam.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return jeonnam.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return jeonnam.date.eq(condition);

    }
}
