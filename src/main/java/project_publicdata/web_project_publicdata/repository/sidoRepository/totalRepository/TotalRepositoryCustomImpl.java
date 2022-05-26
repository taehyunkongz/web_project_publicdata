package project_publicdata.web_project_publicdata.repository.sidoRepository.totalRepository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.TotalDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.TotalDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QTotal.total;

@RequiredArgsConstructor
public class TotalRepositoryCustomImpl implements TotalRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countTotalDefCnt() {
        return queryFactory
                .select(total.defCnt)
                .from(total)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countTotalDeathCnt() {
        return queryFactory
                .select(total.deathCnt)
                .from(total)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countTotalIncdec() {
        return queryFactory
                .select(total.incDec)
                .from(total)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countTotalOverflowCnt() {
        return queryFactory
                .select(total.overFlowCnt)
                .from(total)
                .where(

                )
                .fetch();
    }

    @Override
    public List<TotalDefCountAndGubunDto> getDefCountAndGubunTotal(DateDto date) {
        return queryFactory
                .select(Projections.fields(TotalDefCountAndGubunDto.class,
                        total.incDec,
                        total.gubun,
                        total.deathCnt,
                        total.localOccCnt,
                        total.overFlowCnt,
                        total.defCnt))
                .from(total)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<TotalDto> getAllCountTotal(DateDto date) {
        return queryFactory
                .select(Projections.fields(TotalDto.class,
                        total.deathCnt,
                        total.defCnt,
                        total.incDec,
                        total.localOccCnt,
                        total.overFlowCnt,
                        total.qurRate,
                        total.gubun,
                        total.gubunEn))
                .from(total)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {

        if (date.getMonth().equals("01")) {

            return monthCondition1(date);
        }

        if (date.getMonth().equals("02")) {

            return monthCondition2(date);
        }

        if (date.getMonth().equals("03")) {

            return monthCondition3(date);
        }

        if (date.getMonth().equals("04")) {

            return monthCondition4(date);
        }

        if (date.getMonth().equals("05")) {

            return monthCondition5(date);
        }

        if (date.getMonth().equals("06")) {

            return monthCondition6(date);
        }

        if (date.getMonth().equals("07")) {

            return monthCondition7(date);
        }

        if (date.getMonth().equals("08")) {

            return monthCondition8(date);
        }

        if (date.getMonth().equals("09")) {

            return monthCondition9(date);
        }

        if (date.getMonth().equals("10")) {

            return monthCondition10(date);
        }

        if (date.getMonth().equals("11")) {

            return monthCondition11(date);
        }

        return monthCondition12(date);

    }


    private static BooleanExpression monthCondition1(DateDto date) {

        if (date.getMonth().equals("02")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);



    }

    private static BooleanExpression monthCondition2(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition3(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition4(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition5(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition6(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition7(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition8(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition9(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition10(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition11(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);

    }

    private static BooleanExpression monthCondition12(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return total.date.eq(condition);
        }
        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return total.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return total.date.eq(condition);



    }
}
