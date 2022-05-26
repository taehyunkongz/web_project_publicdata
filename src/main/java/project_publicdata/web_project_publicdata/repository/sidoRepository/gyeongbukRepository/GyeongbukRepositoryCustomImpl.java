package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongbukRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.defCountAndGubunDto.GyeongbukDefCountAndGubunDto;
import project_publicdata.web_project_publicdata.dto.sidoDto.GyeongbukDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.sido.QGyeongbuk.gyeongbuk;

@RequiredArgsConstructor
public class GyeongbukRepositoryCustomImpl implements GyeongbukRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Integer> countGyeongbukDefCnt() {
        return queryFactory
                .select(gyeongbuk.defCnt)
                .from(gyeongbuk)
                .where(

                )
                .fetch();

    }

    @Override
    public List<Integer> countGyeongbukDeathCnt() {
        return queryFactory
                .select(gyeongbuk.deathCnt)
                .from(gyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> countGyeongbukIncdec() {
        return queryFactory
        .select(gyeongbuk.incDec)
        .from(gyeongbuk)
        .where(

        )
        .fetch();

    }

    @Override
    public List<Integer> countGyeongbukOverflowCnt() {
        return queryFactory
        .select(gyeongbuk.overFlowCnt)
        .from(gyeongbuk)
        .where(

        )
        .fetch();

    }

    @Override
    public List<GyeongbukDefCountAndGubunDto> getDefCountAndGubunGyeongbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(GyeongbukDefCountAndGubunDto.class,
                        gyeongbuk.incDec,
                        gyeongbuk.gubun))
                .from(gyeongbuk)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<GyeongbukDto> getAllCountGyeongbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(GyeongbukDto.class,
                        gyeongbuk.deathCnt,
                        gyeongbuk.defCnt,
                        gyeongbuk.incDec,
                        gyeongbuk.localOccCnt,
                        gyeongbuk.overFlowCnt,
                        gyeongbuk.qurRate,
                        gyeongbuk.gubun,
                        gyeongbuk.gubunEn))
                .from(gyeongbuk)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return gyeongbuk.date.eq(condition);
    }

    private static BooleanExpression monthCondition(DateDto date) {


        if (date.getMonth().equals("01") || date.getMonth().equals("03") || date.getMonth().equals("05") ||
                date.getMonth().equals("07") || date.getMonth().equals("08") || date.getMonth().equals("10") ||
                date.getMonth().equals("12")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "31");

            return gyeongbuk.date.eq(condition);
        }

        if (date.getMonth().equals("04") || date.getMonth().equals("06") || date.getMonth().equals("09") ||
                date.getMonth().equals("11")) {

            LocalDate condition = LocalDate.parse(
                    date.getYear() + "-" + date.getMonth() + "-" + "30");

            return gyeongbuk.date.eq(condition);
        }

        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + "28");

        return gyeongbuk.date.eq(condition);

    }

}
