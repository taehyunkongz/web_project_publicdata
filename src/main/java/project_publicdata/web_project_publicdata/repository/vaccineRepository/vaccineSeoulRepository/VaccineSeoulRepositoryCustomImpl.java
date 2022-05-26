package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSeoulRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineSeoulDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineSeoul.vaccineSeoul;

@RequiredArgsConstructor
public class VaccineSeoulRepositoryCustomImpl implements VaccineSeoulRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getSeoulFirstCnt() {
        return queryFactory
                .select(vaccineSeoul.firstCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulSecondCnt() {
        return queryFactory
                .select(vaccineSeoul.secondCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulThirdCnt() {
        return queryFactory
                .select(vaccineSeoul.thirdCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulAccFirstCnt() {
        return queryFactory
                .select(vaccineSeoul.accFirstCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulAccSecondCnt() {
        return queryFactory
                .select(vaccineSeoul.accSecondCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulAccThirdCnt() {
        return queryFactory
                .select(vaccineSeoul.accThirdCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulTotalFirstCnt() {
        return queryFactory
                .select(vaccineSeoul.totalFirstCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulTotalSecondCnt() {
        return queryFactory
                .select(vaccineSeoul.totalSecondCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeoulTotalThirdCnt() {
        return queryFactory
                .select(vaccineSeoul.totalThirdCnt)
                .from(vaccineSeoul)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineSeoulDto> getAllVaccineCountSeoul(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineSeoulDto.class,
                        vaccineSeoul.firstCnt,
                        vaccineSeoul.secondCnt,
                        vaccineSeoul.thirdCnt,
                        vaccineSeoul.accFirstCnt,
                        vaccineSeoul.accSecondCnt,
                        vaccineSeoul.accThirdCnt,
                        vaccineSeoul.totalFirstCnt,
                        vaccineSeoul.totalSecondCnt,
                        vaccineSeoul.totalThirdCnt,
                        vaccineSeoul.sido))
                .from(vaccineSeoul)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineSeoul.date.eq(condition);
    }
}
