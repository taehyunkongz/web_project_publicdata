package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineTotalRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.renderingDto.TotalVaccineCountDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineTotalDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineTotal.vaccineTotal;

@RequiredArgsConstructor
public class VaccineTotalRepositoryCustomImpl implements VaccineTotalRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getTotalFirstCnt() {
        return queryFactory
                .select(vaccineTotal.firstCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalSecondCnt() {
        return queryFactory
                .select(vaccineTotal.secondCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalThirdCnt() {
        return queryFactory
                .select(vaccineTotal.thirdCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalAccFirstCnt() {
        return queryFactory
                .select(vaccineTotal.accFirstCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalAccSecondCnt() {
        return queryFactory
                .select(vaccineTotal.accSecondCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalAccThirdCnt() {
        return queryFactory
                .select(vaccineTotal.accThirdCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalTotalFirstCnt() {
        return queryFactory
                .select(vaccineTotal.totalFirstCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTotalTotalSecondCnt() {
        return queryFactory
                .select(vaccineTotal.totalSecondCnt)
                .from(vaccineTotal)
                .where(

                )
                .fetch();
    }

    @Override
    public List<TotalVaccineCountDto> getTotalVaccineCount(DateDto date) {
        return queryFactory
                .select(Projections.fields(TotalVaccineCountDto.class,
                        vaccineTotal.firstCnt,
                        vaccineTotal.secondCnt,
                        vaccineTotal.thirdCnt
                ))
                .from(vaccineTotal)
                .where(dateCondition(date))
                .fetch();
    }

    @Override
    public List<VaccineTotalDto> getAllVaccineCountTotal(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineTotalDto.class,
                        vaccineTotal.firstCnt,
                        vaccineTotal.secondCnt,
                        vaccineTotal.thirdCnt,
                        vaccineTotal.accFirstCnt,
                        vaccineTotal.accSecondCnt,
                        vaccineTotal.accThirdCnt,
                        vaccineTotal.totalFirstCnt,
                        vaccineTotal.totalSecondCnt,
                        vaccineTotal.totalThirdCnt,
                        vaccineTotal.sido))
                .from(vaccineTotal)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineTotal.date.eq(condition);
    }
}
