package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongbukRepository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGyeongbukDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineGyeongbuk.vaccineGyeongbuk;

@RequiredArgsConstructor
public class VaccineGyeongbukRepositoryCustomImpl implements VaccineGyeongbukRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getGyeongbukFirstCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.firstCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukSecondCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.secondCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukThirdCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.thirdCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukAccFirstCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.accFirstCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukAccSecondCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.accSecondCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukAccThirdCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.accThirdCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukTotalFirstCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.totalFirstCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukTotalSecondCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.totalSecondCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongbukTotalThirdCnt() {
        return queryFactory
                .select(vaccineGyeongbuk.totalThirdCnt)
                .from(vaccineGyeongbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineGyeongbukDto> getAllVaccineCountGyeongbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineGyeongbukDto.class,
                        vaccineGyeongbuk.firstCnt,
                        vaccineGyeongbuk.secondCnt,
                        vaccineGyeongbuk.thirdCnt,
                        vaccineGyeongbuk.accFirstCnt,
                        vaccineGyeongbuk.accSecondCnt,
                        vaccineGyeongbuk.accThirdCnt,
                        vaccineGyeongbuk.totalFirstCnt,
                        vaccineGyeongbuk.totalSecondCnt,
                        vaccineGyeongbuk.totalThirdCnt,
                        vaccineGyeongbuk.sido))
                .from(vaccineGyeongbuk)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineGyeongbuk.date.eq(condition);
    }
}
