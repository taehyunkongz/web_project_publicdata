package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongnamRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GyeongnamDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GyeongnamDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QGyeongnam.gyeongnam;

@RequiredArgsConstructor
public class GyeongnamRepositoryCustomImpl implements GyeongnamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countGyeongnamDefCnt() {
        return queryFactory
                .select(gyeongnam.defCnt)
                .from(gyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGyeongnamDeathCnt() {
        return queryFactory
                .select(gyeongnam.deathCnt)
                .from(gyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGyeongnamIncdec() {
        return queryFactory
                .select(gyeongnam.incDec)
                .from(gyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGyeongnamOverflowCnt() {
        return queryFactory
                .select(gyeongnam.overFlowCnt)
                .from(gyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<GyeongnamDefCountAndGubunDto> getDefCountAndGubunGyeongnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(GyeongnamDefCountAndGubunDto.class,
                        gyeongnam.incDec,
                        gyeongnam.gubun))
                .from(gyeongnam)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<GyeongnamDto> getAllCountGyeongnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(GyeongnamDto.class,
                        gyeongnam.deathCnt,
                        gyeongnam.defCnt,
                        gyeongnam.incDec,
                        gyeongnam.localOccCnt,
                        gyeongnam.overFlowCnt,
                        gyeongnam.qurRate,
                        gyeongnam.gubun,
                        gyeongnam.gubunEn))
                .from(gyeongnam)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return gyeongnam.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return gyeongnam.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return gyeongnam.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return gyeongnam.date.eq(condition);

    }
}
