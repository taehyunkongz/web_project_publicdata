package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungbukRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineChungbukDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineChungbuk.vaccineChungbuk;

@RequiredArgsConstructor
public class VaccineChungbukRepositoryCustomImpl implements VaccineChungbukRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getChungbukFirstCnt() {
        return queryFactory
                .select(vaccineChungbuk.firstCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukSecondCnt() {
        return queryFactory
                .select(vaccineChungbuk.secondCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukThirdCnt() {
        return queryFactory
                .select(vaccineChungbuk.thirdCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukAccFirstCnt() {
        return queryFactory
                .select(vaccineChungbuk.accFirstCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukAccSecondCnt() {
        return queryFactory
                .select(vaccineChungbuk.accSecondCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukAccThirdCnt() {
        return queryFactory
                .select(vaccineChungbuk.accThirdCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukTotalFirstCnt() {
        return queryFactory
                .select(vaccineChungbuk.totalFirstCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukTotalSecondCnt() {
        return queryFactory
                .select(vaccineChungbuk.totalSecondCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungbukTotalThirdCnt() {
        return queryFactory
                .select(vaccineChungbuk.totalThirdCnt)
                .from(vaccineChungbuk)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineChungbukDto> getAllVaccineCountChungbuk(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineChungbukDto.class,
                        vaccineChungbuk.firstCnt,
                        vaccineChungbuk.secondCnt,
                        vaccineChungbuk.thirdCnt,
                        vaccineChungbuk.accFirstCnt,
                        vaccineChungbuk.accSecondCnt,
                        vaccineChungbuk.accThirdCnt,
                        vaccineChungbuk.totalFirstCnt,
                        vaccineChungbuk.totalSecondCnt,
                        vaccineChungbuk.totalThirdCnt,
                        vaccineChungbuk.sido))
                .from(vaccineChungbuk)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineChungbuk.date.eq(condition);
    }
}
