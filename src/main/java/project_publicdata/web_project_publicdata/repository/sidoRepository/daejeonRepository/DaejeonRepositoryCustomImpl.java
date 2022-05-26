package project_publicdata.web_project_publicdata.repository.sidoRepository.daejeonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.DaejeonDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.DaejeonDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QDaejeon.daejeon;

@RequiredArgsConstructor
public class DaejeonRepositoryCustomImpl implements DaejeonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countDaejeonDefCnt() {
        return queryFactory
                .select(daejeon.overFlowCnt)
                .from(daejeon)
                .where(

                )
                .fetch();
    }


    @Override
    public List<Integer> countDaejeonDeathCnt() {
        return queryFactory
                .select(daejeon.deathCnt)
                .from(daejeon)
                .where(

                )
                .fetch();
    }


    @Override
    public List<Integer> countDaejeonIncdec() {
        return queryFactory
                .select(daejeon.incDec)
                .from(daejeon)
                .where(

                )
                .fetch();
    }


    @Override
    public List<Integer> countDaejeonOverflowCnt() {
        return queryFactory
                .select(daejeon.overFlowCnt)
                .from(daejeon)
                .where(

                )
                .fetch();
    }


    @Override
    public List<DaejeonDefCountAndGubunDto> getDefCountAndGubunDaejeon(DateDto date) {
        return queryFactory
                .select(Projections.fields(DaejeonDefCountAndGubunDto.class,
                        daejeon.incDec,
                        daejeon.gubun))
                .from(daejeon)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<DaejeonDto> getAllCountDaejeon(DateDto date) {
        return queryFactory
                .select(Projections.fields(DaejeonDto.class,
                        daejeon.deathCnt,
                        daejeon.defCnt,
                        daejeon.incDec,
                        daejeon.localOccCnt,
                        daejeon.overFlowCnt,
                        daejeon.qurRate,
                        daejeon.gubun,
                        daejeon.gubunEn))
                .from(daejeon)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return daejeon.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return daejeon.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return daejeon.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return daejeon.date.eq(condition);

    }
}
