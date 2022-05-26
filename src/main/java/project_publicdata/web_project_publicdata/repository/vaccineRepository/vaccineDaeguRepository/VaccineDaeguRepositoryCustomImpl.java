package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaeguRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineDaeguDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineDaegu.vaccineDaegu;

@RequiredArgsConstructor
public class VaccineDaeguRepositoryCustomImpl implements VaccineDaeguRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getDaeguFirstCnt() {
        return queryFactory
                .select(vaccineDaegu.firstCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguSecondCnt() {
        return queryFactory
                .select(vaccineDaegu.secondCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguThirdCnt() {
        return queryFactory
                .select(vaccineDaegu.thirdCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguAccFirstCnt() {
        return queryFactory
                .select(vaccineDaegu.accFirstCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguAccSecondCnt() {
        return queryFactory
                .select(vaccineDaegu.accSecondCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguAccThirdCnt() {
        return queryFactory
                .select(vaccineDaegu.accThirdCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguTotalFirstCnt() {
        return queryFactory
                .select(vaccineDaegu.totalFirstCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguTotalSecondCnt() {
        return queryFactory
                .select(vaccineDaegu.totalSecondCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getDaeguTotalThirdCnt() {
        return queryFactory
                .select(vaccineDaegu.totalThirdCnt)
                .from(vaccineDaegu)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineDaeguDto> getAllVaccineCountDaegu(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineDaeguDto.class,
                        vaccineDaegu.firstCnt,
                        vaccineDaegu.secondCnt,
                        vaccineDaegu.thirdCnt,
                        vaccineDaegu.accFirstCnt,
                        vaccineDaegu.accSecondCnt,
                        vaccineDaegu.accThirdCnt,
                        vaccineDaegu.totalFirstCnt,
                        vaccineDaegu.totalSecondCnt,
                        vaccineDaegu.totalThirdCnt,
                        vaccineDaegu.sido))
                .from(vaccineDaegu)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineDaegu.date.eq(condition);
    }
}
