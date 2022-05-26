package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.twentySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.TwentySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QTwentyS.twentyS;

@RequiredArgsConstructor
public class TwentySRepositoryCustomImpl implements TwentySRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Integer> getTwentySConfCase() {
        return queryFactory
                .select(twentyS.confCase)
                .from(twentyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getTwentySConfCaseRate() {
        return queryFactory
                .select(twentyS.confCaseRate)
                .from(twentyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTwentySDeathCnt() {
        return queryFactory
                .select(twentyS.deathCnt)
                .from(twentyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getTwentySDeathRate() {
        return queryFactory
                .select(twentyS.deathRate)
                .from(twentyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getTwentySCriticalRate() {
        return queryFactory
                .select(twentyS.criticalRate)
                .from(twentyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<TwentySDto> getAllCountTwentyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(TwentySDto.class,
                        twentyS.confCase,
                        twentyS.confCaseRate,
                        twentyS.criticalRate,
                        twentyS.deathRate,
                        twentyS.deathCnt,
                        twentyS.genderAndAge))
                .from(twentyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return twentyS.date.eq(condition);
    }

}
