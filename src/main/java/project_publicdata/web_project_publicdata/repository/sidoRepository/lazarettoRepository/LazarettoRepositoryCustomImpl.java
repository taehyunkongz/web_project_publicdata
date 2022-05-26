package project_publicdata.web_project_publicdata.repository.sidoRepository.lazarettoRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.LazarettoDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.LazarettoDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QLazaretto.lazaretto;

@RequiredArgsConstructor
public class LazarettoRepositoryCustomImpl implements LazarettoRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countLazarettoDefCnt() {
        return queryFactory
                .select(lazaretto.defCnt)
                .from(lazaretto)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countLazarettoDeathCnt() {
        return queryFactory
                .select(lazaretto.deathCnt)
                .from(lazaretto)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countLazarettoIncdec() {
        return queryFactory
                .select(lazaretto.incDec)
                .from(lazaretto)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countLazarettoOverflowCnt() {
        return queryFactory
                .select(lazaretto.overFlowCnt)
                .from(lazaretto)
                .where(

                )
                .fetch();
    }

    @Override
    public List<LazarettoDefCountAndGubunDto> getDefCountAndGubunLazaretto(DateDto date) {
        return queryFactory
                .select(Projections.fields(LazarettoDefCountAndGubunDto.class,
                        lazaretto.incDec,
                        lazaretto.gubun))
                .from(lazaretto)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<LazarettoDto> getAllCountLazaretto(DateDto date) {
        return queryFactory
                .select(Projections.fields(LazarettoDto.class,
                        lazaretto.deathCnt,
                        lazaretto.defCnt,
                        lazaretto.incDec,
                        lazaretto.localOccCnt,
                        lazaretto.overFlowCnt,
                        lazaretto.qurRate,
                        lazaretto.gubun,
                        lazaretto.gubunEn))
                .from(lazaretto)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return lazaretto.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return lazaretto.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return lazaretto.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return lazaretto.date.eq(condition);

    }
}
