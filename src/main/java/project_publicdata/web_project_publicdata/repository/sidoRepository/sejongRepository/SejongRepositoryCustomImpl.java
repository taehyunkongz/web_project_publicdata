package project_publicdata.web_project_publicdata.repository.sidoRepository.sejongRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.SejongDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.SejongDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QSejong.sejong;

@RequiredArgsConstructor
public class SejongRepositoryCustomImpl implements SejongRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countSejongDefCnt() {
        return queryFactory
                .select(sejong.defCnt)
                .from(sejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countSejongDeathCnt() {
        return queryFactory
                .select(sejong.deathCnt)
                .from(sejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countSejongIncdec() {
        return queryFactory
                .select(sejong.incDec)
                .from(sejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countSejongOverflowCnt() {
        return queryFactory
                .select(sejong.overFlowCnt)
                .from(sejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<SejongDefCountAndGubunDto> getDefCountAndGubunSejong(DateDto date) {
        return queryFactory
                .select(Projections.fields(SejongDefCountAndGubunDto.class,
                        sejong.incDec,
                        sejong.gubun))
                .from(sejong)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<SejongDto> getAllCountSejong(DateDto date) {
        return queryFactory
                .select(Projections.fields(SejongDto.class,
                        sejong.deathCnt,
                        sejong.defCnt,
                        sejong.incDec,
                        sejong.localOccCnt,
                        sejong.overFlowCnt,
                        sejong.qurRate,
                        sejong.gubun,
                        sejong.gubunEn))
                .from(sejong)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return sejong.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return sejong.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return sejong.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return sejong.date.eq(condition);

    }
}
