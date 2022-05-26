package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSejongRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineSejongDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineSejong.vaccineSejong;

@RequiredArgsConstructor
public class VaccineSejongRepositoryCustomImpl implements VaccineSejongRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getSejongFirstCnt() {
        return queryFactory
                .select(vaccineSejong.firstCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongSecondCnt() {
        return queryFactory
                .select(vaccineSejong.secondCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongThirdCnt() {
        return queryFactory
                .select(vaccineSejong.thirdCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongAccFirstCnt() {
        return queryFactory
                .select(vaccineSejong.accFirstCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongAccSecondCnt() {
        return queryFactory
                .select(vaccineSejong.accSecondCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongAccThirdCnt() {
        return queryFactory
                .select(vaccineSejong.accThirdCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongTotalFirstCnt() {
        return queryFactory
                .select(vaccineSejong.totalFirstCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongTotalSecondCnt() {
        return queryFactory
                .select(vaccineSejong.totalSecondCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSejongTotalThirdCnt() {
        return queryFactory
                .select(vaccineSejong.totalThirdCnt)
                .from(vaccineSejong)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineSejongDto> getAllVaccineCountSejong(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineSejongDto.class,
                        vaccineSejong.firstCnt,
                        vaccineSejong.secondCnt,
                        vaccineSejong.thirdCnt,
                        vaccineSejong.accFirstCnt,
                        vaccineSejong.accSecondCnt,
                        vaccineSejong.accThirdCnt,
                        vaccineSejong.totalFirstCnt,
                        vaccineSejong.totalSecondCnt,
                        vaccineSejong.totalThirdCnt,
                        vaccineSejong.sido))
                .from(vaccineSejong)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineSejong.date.eq(condition);
    }
}
