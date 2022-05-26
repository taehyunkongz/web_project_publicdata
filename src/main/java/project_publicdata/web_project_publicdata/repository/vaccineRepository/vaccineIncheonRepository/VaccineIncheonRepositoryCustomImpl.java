package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineIncheonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineIncheonDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineIncheon.vaccineIncheon;

@RequiredArgsConstructor
public class VaccineIncheonRepositoryCustomImpl implements VaccineIncheonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getIncheonFirstCnt() {
        return queryFactory
                .select(vaccineIncheon.firstCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonSecondCnt() {
        return queryFactory
                .select(vaccineIncheon.secondCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonThirdCnt() {
        return queryFactory
                .select(vaccineIncheon.thirdCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonAccFirstCnt() {
        return queryFactory
                .select(vaccineIncheon.accFirstCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonAccSecondCnt() {
        return queryFactory
                .select(vaccineIncheon.accSecondCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonAccThirdCnt() {
        return queryFactory
                .select(vaccineIncheon.accThirdCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonTotalFirstCnt() {
        return queryFactory
                .select(vaccineIncheon.totalFirstCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonTotalSecondCnt() {
        return queryFactory
                .select(vaccineIncheon.totalSecondCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getIncheonTotalThirdCnt() {
        return queryFactory
                .select(vaccineIncheon.totalThirdCnt)
                .from(vaccineIncheon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineIncheonDto> getAllVaccineCountIncheon(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineIncheonDto.class,
                        vaccineIncheon.firstCnt,
                        vaccineIncheon.secondCnt,
                        vaccineIncheon.thirdCnt,
                        vaccineIncheon.accFirstCnt,
                        vaccineIncheon.accSecondCnt,
                        vaccineIncheon.accThirdCnt,
                        vaccineIncheon.totalFirstCnt,
                        vaccineIncheon.totalSecondCnt,
                        vaccineIncheon.totalThirdCnt,
                        vaccineIncheon.sido))
                .from(vaccineIncheon)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineIncheon.date.eq(condition);
    }
}
