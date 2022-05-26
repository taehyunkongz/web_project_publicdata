package project_publicdata.web_project_publicdata.repository.sidoRepository.daeguRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.DaeguDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.DaeguDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QDaegu.daegu;

@RequiredArgsConstructor
public class DaeguRepositoryCustomImpl implements DaeguRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Integer> countDaeguDefCnt() {
        return queryFactory
                .select(daegu.overFlowCnt)
                .from(daegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countDaeguDeathCnt() {
        return queryFactory
                .select(daegu.deathCnt)
                .from(daegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countDaeguIncdec() {
        return queryFactory
                .select(daegu.incDec)
                .from(daegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countDaeguOverflowCnt() {
        return queryFactory
                .select(daegu.overFlowCnt)
                .from(daegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<DaeguDefCountAndGubunDto> getDefCountAndGubunDaegu(DateDto date) {
        return queryFactory
                .select(Projections.fields(DaeguDefCountAndGubunDto.class,
                        daegu.incDec,
                        daegu.gubun))
                .from(daegu)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<DaeguDto> getAllCountDaegu(DateDto date) {
        return queryFactory
                .select(Projections.fields(DaeguDto.class,
                        daegu.deathCnt,
                        daegu.defCnt,
                        daegu.incDec,
                        daegu.localOccCnt,
                        daegu.overFlowCnt,
                        daegu.qurRate,
                        daegu.gubun,
                        daegu.gubunEn))
                .from(daegu)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return daegu.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return daegu.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return daegu.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return daegu.date.eq(condition);

    }
}
