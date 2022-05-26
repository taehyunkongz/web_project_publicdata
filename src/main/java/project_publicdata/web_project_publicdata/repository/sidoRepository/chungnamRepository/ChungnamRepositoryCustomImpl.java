package project_publicdata.web_project_publicdata.repository.sidoRepository.chungnamRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.ChungnamDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.ChungnamDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QChungnam.chungnam;

@RequiredArgsConstructor
public class ChungnamRepositoryCustomImpl implements ChungnamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countChungnamDefCnt() {
        return queryFactory
                .select(chungnam.defCnt)
                .from(chungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countChungnamDeathCnt() {
        return queryFactory
                .select(chungnam.deathCnt)
                .from(chungnam)
                .where(

                )
                .fetch();

    }

    @Override
    public List<Integer> countChungnamIncdec() {
        return queryFactory
                .select(chungnam.incDec)
                .from(chungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countChungnamOverflowCnt() {
        return queryFactory
                .select(chungnam.overFlowCnt)
                .from(chungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<ChungnamDefCountAndGubunDto> getDefCountAndGubunChungnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(ChungnamDefCountAndGubunDto.class,
                        chungnam.incDec,
                        chungnam.gubun))
                .from(chungnam)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<ChungnamDto> getAllCountChungnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(ChungnamDto.class,
                        chungnam.deathCnt,
                        chungnam.defCnt,
                        chungnam.incDec,
                        chungnam.localOccCnt,
                        chungnam.overFlowCnt,
                        chungnam.qurRate,
                        chungnam.gubun,
                        chungnam.gubunEn))
                .from(chungnam)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return chungnam.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return chungnam.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return chungnam.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return chungnam.date.eq(condition);

    }
}
