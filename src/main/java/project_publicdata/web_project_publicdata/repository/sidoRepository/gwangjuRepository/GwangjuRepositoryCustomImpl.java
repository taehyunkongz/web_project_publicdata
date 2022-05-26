package project_publicdata.web_project_publicdata.repository.sidoRepository.gwangjuRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GwangjuDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GwangjuDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QGwangju.gwangju;

@RequiredArgsConstructor
public class GwangjuRepositoryCustomImpl implements GwangjuRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countGwangjuDefCnt() {
        return queryFactory
                .select(gwangju.defCnt)
                .from(gwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGwangjuDeathCnt() {
        return queryFactory
                .select(gwangju.deathCnt)
                .from(gwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGwangjuIncdec() {
        return queryFactory
                .select(gwangju.incDec)
                .from(gwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGwangjuOverflowCnt() {
        return queryFactory
                .select(gwangju.overFlowCnt)
                .from(gwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<GwangjuDefCountAndGubunDto> getDefCountAndGubunGwangju(DateDto date) {
        return queryFactory
                .select(Projections.fields(GwangjuDefCountAndGubunDto.class,
                        gwangju.incDec,
                        gwangju.gubun))
                .from(gwangju)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<GwangjuDto> getAllCountGwangju(DateDto date) {
        return queryFactory
                .select(Projections.fields(GwangjuDto.class,
                        gwangju.deathCnt,
                        gwangju.defCnt,
                        gwangju.incDec,
                        gwangju.localOccCnt,
                        gwangju.overFlowCnt,
                        gwangju.qurRate,
                        gwangju.gubun,
                        gwangju.gubunEn))
                .from(gwangju)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return gwangju.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return gwangju.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return gwangju.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return gwangju.date.eq(condition);

    }
}
