package project_publicdata.web_project_publicdata.repository.sidoRepository.incheonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.IncheonDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.IncheonDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QIncheon.incheon;

@RequiredArgsConstructor
public class IncheonRepositoryCustomImpl implements IncheonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> countIncheonDefCnt() {
        return queryFactory
                .select(incheon.defCnt)
                .from(incheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countIncheonDeathCnt() {
        return queryFactory
                .select(incheon.deathCnt)
                .from(incheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countIncheonIncdec() {
        return queryFactory
                .select(incheon.incDec)
                .from(incheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countIncheonOverflowCnt() {
        return queryFactory
                .select(incheon.overFlowCnt)
                .from(incheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<IncheonDefCountAndGubunDto> getDefCountAndGubunIncheon(DateDto date) {
        return queryFactory
                .select(Projections.fields(IncheonDefCountAndGubunDto.class,
                        incheon.incDec,
                        incheon.gubun))
                .from(incheon)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<IncheonDto> getAllCountIncheon(DateDto date) {
        return queryFactory
                .select(Projections.fields(IncheonDto.class,
                        incheon.deathCnt,
                        incheon.defCnt,
                        incheon.incDec,
                        incheon.localOccCnt,
                        incheon.overFlowCnt,
                        incheon.qurRate,
                        incheon.gubun,
                        incheon.gubunEn))
                .from(incheon)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return incheon.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return incheon.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return incheon.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return incheon.date.eq(condition);

    }
}
