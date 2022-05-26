package project_publicdata.web_project_publicdata.repository.sidoRepository.seoulRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.SeoulDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.SeoulDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QSeoul.seoul;

@RequiredArgsConstructor
public class SeoulRepositoryCustomImpl implements SeoulRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countSeoulDefCnt() {
        return queryFactory
                .select(seoul.defCnt)
                .from(seoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countSeoulDeathCnt() {
        return queryFactory
                .select(seoul.deathCnt)
                .from(seoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countSeoulIncdec() {
        return queryFactory
                .select(seoul.incDec)
                .from(seoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countSeoulOverflowCnt() {
        return queryFactory
                .select(seoul.overFlowCnt)
                .from(seoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<SeoulDefCountAndGubunDto> getDefCountAndGubunSeoul(DateDto date) {
        return queryFactory
                .select(Projections.fields(SeoulDefCountAndGubunDto.class,
                        seoul.incDec,
                        seoul.gubun))
                .from(seoul)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<SeoulDto> getAllCountSeoul(DateDto date) {
        return queryFactory
                .select(Projections.fields(SeoulDto.class,
                        seoul.deathCnt,
                        seoul.defCnt,
                        seoul.incDec,
                        seoul.localOccCnt,
                        seoul.overFlowCnt,
                        seoul.qurRate,
                        seoul.gubun,
                        seoul.gubunEn))
                .from(seoul)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return seoul.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return seoul.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return seoul.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return seoul.date.eq(condition);

    }
}
