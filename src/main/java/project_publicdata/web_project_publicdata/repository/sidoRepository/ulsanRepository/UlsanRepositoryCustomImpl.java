package project_publicdata.web_project_publicdata.repository.sidoRepository.ulsanRepository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.UlsanDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.UlsanDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QUlsan.ulsan;

@RequiredArgsConstructor
public class UlsanRepositoryCustomImpl implements UlsanRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countUlsanDefCnt() {
        return queryFactory
                .select(ulsan.defCnt)
                .from(ulsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countUlsanDeathCnt() {
        return queryFactory
                .select(ulsan.deathCnt)
                .from(ulsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countUlsanIncdec() {
        return queryFactory
                .select(ulsan.incDec)
                .from(ulsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countUlsanOverflowCnt() {
        return queryFactory
                .select(ulsan.overFlowCnt)
                .from(ulsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<UlsanDefCountAndGubunDto> getDefCountAndGubunUlsan(DateDto date) {
        return queryFactory
                .select(Projections.fields(UlsanDefCountAndGubunDto.class,
                        ulsan.incDec,
                        ulsan.gubun))
                .from(ulsan)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<UlsanDto> getAllCountUlsan(DateDto date) {
        return queryFactory
                .select(Projections.fields(UlsanDto.class,
                        ulsan.deathCnt,
                        ulsan.defCnt,
                        ulsan.incDec,
                        ulsan.localOccCnt,
                        ulsan.overFlowCnt,
                        ulsan.qurRate,
                        ulsan.gubun,
                        ulsan.gubunEn))
                .from(ulsan)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return ulsan.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return ulsan.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return ulsan.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return ulsan.date.eq(condition);

    }
}
