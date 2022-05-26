package project_publicdata.web_project_publicdata.repository.sidoRepository.jeonbukRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.JeonbukDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.JeonbukDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QJeonbuk.jeonbuk;

@RequiredArgsConstructor
public class JeonbukRepositoryCustomImpl implements JeonbukRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countJeonbukDefCnt() {
        return queryFactory
                .select(jeonbuk.defCnt)
                .from(jeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJeonbukDeathCnt() {
        return queryFactory
                .select(jeonbuk.deathCnt)
                .from(jeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJeonbukIncdec() {
        return queryFactory
                .select(jeonbuk.incDec)
                .from(jeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countJeonbukOverflowCnt() {
        return queryFactory
                .select(jeonbuk.overFlowCnt)
                .from(jeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<JeonbukDefCountAndGubunDto> getDefCountAndGubunJeonbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(JeonbukDefCountAndGubunDto.class,
                        jeonbuk.incDec,
                        jeonbuk.gubun))
                .from(jeonbuk)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<JeonbukDto> getAllCountJeonbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(JeonbukDto.class,
                        jeonbuk.deathCnt,
                        jeonbuk.defCnt,
                        jeonbuk.incDec,
                        jeonbuk.localOccCnt,
                        jeonbuk.overFlowCnt,
                        jeonbuk.qurRate,
                        jeonbuk.gubun,
                        jeonbuk.gubunEn))
                .from(jeonbuk)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return jeonbuk.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return jeonbuk.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return jeonbuk.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return jeonbuk.date.eq(condition);

    }
}
