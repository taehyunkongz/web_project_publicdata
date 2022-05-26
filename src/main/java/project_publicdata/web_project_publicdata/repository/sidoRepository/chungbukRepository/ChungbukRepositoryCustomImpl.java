package project_publicdata.web_project_publicdata.repository.sidoRepository.chungbukRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.ChungbukDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.ChungbukDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QChungbuk.chungbuk;

@RequiredArgsConstructor
public class ChungbukRepositoryCustomImpl implements ChungbukRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countChungbukDefCnt() {
        return queryFactory
                .select(chungbuk.defCnt)
                .from(chungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countChungbukdeathCnt() {
        return queryFactory
                .select(chungbuk.deathCnt)
                .from(chungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countChungbukIncDec() {
        return queryFactory
                .select(chungbuk.incDec)
                .from(chungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countChungbukoverFlowCnt() {
        return queryFactory
                .select(chungbuk.overFlowCnt)
                .from(chungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<ChungbukDefCountAndGubunDto> getDefCountAndGubunChungbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(ChungbukDefCountAndGubunDto.class,
                        chungbuk.incDec,
                        chungbuk.gubun))
                .from(chungbuk)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<ChungbukDto> getAllCountChungbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(ChungbukDto.class,
                        chungbuk.deathCnt,
                        chungbuk.defCnt,
                        chungbuk.incDec,
                        chungbuk.localOccCnt,
                        chungbuk.overFlowCnt,
                        chungbuk.qurRate,
                        chungbuk.gubun,
                        chungbuk.gubunEn))
                .from(chungbuk)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return chungbuk.date.eq(condition);
    }

    private BooleanExpression monthCondition(DateDto date) {

        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return chungbuk.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return chungbuk.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return chungbuk.date.eq(condition);

    }

}
