package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineBusanRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineBusanDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineBusan.vaccineBusan;

@RequiredArgsConstructor
public class VaccineBusanRepositoryCustomImpl implements VaccineBusanRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getBusanFirstCnt() {
        return queryFactory
                .select(vaccineBusan.firstCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanSecondCnt() {
        return queryFactory
                .select(vaccineBusan.secondCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanThirdCnt() {
        return queryFactory
                .select(vaccineBusan.thirdCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanAccFirstCnt() {
        return queryFactory
                .select(vaccineBusan.accFirstCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanAccSecondCnt() {
        return queryFactory
                .select(vaccineBusan.accSecondCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanAccThirdCnt() {
        return queryFactory
                .select(vaccineBusan.accThirdCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanTotalFirstCnt() {
        return queryFactory
                .select(vaccineBusan.totalFirstCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanTotalSecondCnt() {
        return queryFactory
                .select(vaccineBusan.totalSecondCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getBusanTotalThirdCnt() {
        return queryFactory
                .select(vaccineBusan.totalThirdCnt)
                .from(vaccineBusan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineBusanDto> getAllVaccineCountBusan(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineBusanDto.class,
                        vaccineBusan.firstCnt,
                        vaccineBusan.secondCnt,
                        vaccineBusan.thirdCnt,
                        vaccineBusan.accFirstCnt,
                        vaccineBusan.accSecondCnt,
                        vaccineBusan.accThirdCnt,
                        vaccineBusan.totalFirstCnt,
                        vaccineBusan.totalSecondCnt,
                        vaccineBusan.totalThirdCnt,
                        vaccineBusan.sido))
                .from(vaccineBusan)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineBusan.date.eq(condition);
    }
}
