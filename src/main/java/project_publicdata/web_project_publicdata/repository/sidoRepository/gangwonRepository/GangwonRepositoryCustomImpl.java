package project_publicdata.web_project_publicdata.repository.sidoRepository.gangwonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GangwonDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GangwonDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QGangwon.gangwon;

@RequiredArgsConstructor
public class GangwonRepositoryCustomImpl implements GangwonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countGanwonDefCnt() {
        return queryFactory
                .select(gangwon.defCnt)
                .from(gangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGangwonDeathCnt() {
        return queryFactory
                .select(gangwon.deathCnt)
                .from(gangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGangwonIncdec() {
        return queryFactory
                .select(gangwon.incDec)
                .from(gangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGangwonOverflowCnt() {
        return queryFactory
                .select(gangwon.overFlowCnt)
                .from(gangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<GangwonDefCountAndGubunDto> getDefCountAndGubunGangwon(DateDto date) {
        return queryFactory
                .select(Projections.fields(GangwonDefCountAndGubunDto.class,
                        gangwon.incDec,
                        gangwon.gubun))
                .from(gangwon)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<GangwonDto> getAllCountGangwon(DateDto date) {
        return queryFactory
                .select(Projections.fields(GangwonDto.class,
                        gangwon.deathCnt,
                        gangwon.defCnt,
                        gangwon.incDec,
                        gangwon.localOccCnt,
                        gangwon.overFlowCnt,
                        gangwon.qurRate,
                        gangwon.gubun,
                        gangwon.gubunEn))
                .from(gangwon)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return gangwon.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return gangwon.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return gangwon.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return gangwon.date.eq(condition);

    }
}
