package project_publicdata.web_project_publicdata.repository.sidoRepository.busanRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.BusanDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.BusanDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QBusan.busan;

@RequiredArgsConstructor
public class BusanRepositoryCustomImpl implements BusanRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countBusanDefcnt() {
        return queryFactory
                .select(busan.defCnt)
                .from(busan)
                .where(

                )
                .fetch();
    }


    @Override
    public List<Integer> countBusanDeathcnt() {
        return queryFactory
                .select(busan.deathCnt)
                .from(busan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countBusanIncDec() {
        return queryFactory
                .select(busan.incDec)
                .from(busan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countBusanOverflowCnt() {
        return queryFactory
                .select(busan.overFlowCnt)
                .from(busan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<BusanDefCountAndGubunDto> getDefCountAndGubunBusan(DateDto date) {
        return queryFactory
                .select(Projections.fields(BusanDefCountAndGubunDto.class,
                        busan.incDec,
                        busan.gubun))
                .from(busan)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<BusanDto> getAllCountBusan(DateDto date) {
        return queryFactory
                .select(Projections.fields(BusanDto.class,
                        busan.deathCnt,
                        busan.defCnt,
                        busan.incDec,
                        busan.localOccCnt,
                        busan.overFlowCnt,
                        busan.qurRate,
                        busan.gubun,
                        busan.gubunEn,
                        busan.date))
                .from(busan)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);
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

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);



    }

    private static BooleanExpression monthCondition2(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition3(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition4(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition5(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition6(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition7(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition8(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition9(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition10(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition11(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);

    }

    private static BooleanExpression monthCondition12(DateDto date) {

        if (date.getMonth().equals("01")) {
            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("02")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "28");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("03")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("04")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("05")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("06")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("07")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("08")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("09")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }

        if (date.getMonth().equals("10")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return busan.date.eq(condition);
        }
        if (date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return busan.date.eq(condition);
        }


        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return busan.date.eq(condition);



    }
}





