package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonbukRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineJeonbukDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineJeonbuk.vaccineJeonbuk;

@RequiredArgsConstructor
public class VaccineJeonbukRepositoryCustomImpl implements VaccineJeonbukRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getJeonbukFirstCnt() {
        return queryFactory
                .select(vaccineJeonbuk.firstCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukSecondCnt() {
        return queryFactory
                .select(vaccineJeonbuk.secondCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukThirdCnt() {
        return queryFactory
                .select(vaccineJeonbuk.thirdCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukAccFirstCnt() {
        return queryFactory
                .select(vaccineJeonbuk.accFirstCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukAccSecondCnt() {
        return queryFactory
                .select(vaccineJeonbuk.accSecondCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukAccThirdCnt() {
        return queryFactory
                .select(vaccineJeonbuk.accThirdCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukTotalFirstCnt() {
        return queryFactory
                .select(vaccineJeonbuk.totalFirstCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukTotalSecondCnt() {
        return queryFactory
                .select(vaccineJeonbuk.totalSecondCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonbukTotalThirdCnt() {
        return queryFactory
                .select(vaccineJeonbuk.totalThirdCnt)
                .from(vaccineJeonbuk)
                .where(

                )
                .fetch();
}

    @Override
    public List<VaccineJeonbukDto> getAllVaccineCountJeonbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineJeonbukDto.class,
                        vaccineJeonbuk.firstCnt,
                        vaccineJeonbuk.secondCnt,
                        vaccineJeonbuk.thirdCnt,
                        vaccineJeonbuk.accFirstCnt,
                        vaccineJeonbuk.accSecondCnt,
                        vaccineJeonbuk.accThirdCnt,
                        vaccineJeonbuk.totalFirstCnt,
                        vaccineJeonbuk.totalSecondCnt,
                        vaccineJeonbuk.totalThirdCnt,
                        vaccineJeonbuk.sido))
                .from(vaccineJeonbuk)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineJeonbuk.date.eq(condition);
    }
}
