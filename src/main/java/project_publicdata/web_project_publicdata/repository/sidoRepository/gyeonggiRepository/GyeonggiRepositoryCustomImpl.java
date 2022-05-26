package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeonggiRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GyeonggiDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GyeonggiDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QGyeonggi.gyeonggi;

@RequiredArgsConstructor
public class GyeonggiRepositoryCustomImpl implements GyeonggiRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countGyeonggiDefCnt() {
        return queryFactory
                .select(gyeonggi.defCnt)
                .from(gyeonggi)
                .where(

                )
                .fetch();

    }

    @Override
    public List<Integer> countGyeonggiDeathCnt() {
        return queryFactory
                .select(gyeonggi.deathCnt)
                .from(gyeonggi)
                .where(

                )
                .fetch();

    }

    @Override
    public List<Integer> countGyeonggiIncdec() {
        return queryFactory
                .select(gyeonggi.incDec)
                .from(gyeonggi)
                .where(

                )
                .fetch();

    }

    @Override
    public List<Integer> countGyeonggiOverflowCnt() {
        return queryFactory
                .select(gyeonggi.overFlowCnt)
                .from(gyeonggi)
                .where(

                )
                .fetch();

    }

    @Override
    public List<GyeonggiDefCountAndGubunDto> getDefCountAndGubunGyeonggi(DateDto date) {
        return queryFactory
                .select(Projections.fields(GyeonggiDefCountAndGubunDto.class,
                        gyeonggi.incDec,
                        gyeonggi.gubun))
                .from(gyeonggi)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<GyeonggiDto> getAllCountGyeonggi(DateDto date) {
        return queryFactory
                .select(Projections.fields(GyeonggiDto.class,
                        gyeonggi.deathCnt,
                        gyeonggi.defCnt,
                        gyeonggi.incDec,
                        gyeonggi.localOccCnt,
                        gyeonggi.overFlowCnt,
                        gyeonggi.qurRate,
                        gyeonggi.gubun,
                        gyeonggi.gubunEn))
                .from(gyeonggi)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return gyeonggi.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return gyeonggi.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return gyeonggi.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return gyeonggi.date.eq(condition);

    }
}
