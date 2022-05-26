package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaejeonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineDaejeonDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineDaejeon.vaccineDaejeon;

@RequiredArgsConstructor
public class VaccineDaejeonRepositoryCustomImpl implements VaccineDaejeonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getDaejeonFirstCnt() {
        return queryFactory
                .select(vaccineDaejeon.firstCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonSecondCnt() {
        return queryFactory
                .select(vaccineDaejeon.secondCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonThirdCnt() {
        return queryFactory
                .select(vaccineDaejeon.thirdCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonAccFirstCnt() {
        return queryFactory
                .select(vaccineDaejeon.accFirstCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonAccSecondCnt() {
        return queryFactory
                .select(vaccineDaejeon.accSecondCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonAccThirdCnt() {
        return queryFactory
                .select(vaccineDaejeon.accThirdCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonTotalFirstCnt() {
        return queryFactory
                .select(vaccineDaejeon.totalFirstCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonTotalSecondCnt() {
        return queryFactory
                .select(vaccineDaejeon.totalSecondCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaejeonTotalThirdCnt() {
        return queryFactory
                .select(vaccineDaejeon.totalThirdCnt)
                .from(vaccineDaejeon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineDaejeonDto> getAllVaccineCountDaejeon(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineDaejeonDto.class,
                        vaccineDaejeon.firstCnt,
                        vaccineDaejeon.secondCnt,
                        vaccineDaejeon.thirdCnt,
                        vaccineDaejeon.accFirstCnt,
                        vaccineDaejeon.accSecondCnt,
                        vaccineDaejeon.accThirdCnt,
                        vaccineDaejeon.totalFirstCnt,
                        vaccineDaejeon.totalSecondCnt,
                        vaccineDaejeon.totalThirdCnt,
                        vaccineDaejeon.sido))
                .from(vaccineDaejeon)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineDaejeon.date.eq(condition);
    }
}
