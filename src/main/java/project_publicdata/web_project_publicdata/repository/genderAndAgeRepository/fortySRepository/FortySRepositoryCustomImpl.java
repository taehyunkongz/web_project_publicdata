package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fortySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.FortySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QFortyS.fortyS;

@RequiredArgsConstructor
public class FortySRepositoryCustomImpl implements FortySRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getFortySConfCase() {
        return queryFactory
                .select(fortyS.confCase)
                .from()
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFortySConfCaseRate() {
        return queryFactory
                .select(fortyS.confCaseRate)
                .from(fortyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getFortySDeathCnt() {
        return queryFactory
                .select(fortyS.deathCnt)
                .from(fortyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFortySDeathRate() {
        return queryFactory
                .select(fortyS.deathRate)
                .from(fortyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFortySCriticalRate() {
        return queryFactory
                .select(fortyS.criticalRate)
                .from(fortyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<FortySDto> getAllCountFortyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(FortySDto.class,
                        fortyS.confCase,
                        fortyS.confCaseRate,
                        fortyS.criticalRate,
                        fortyS.deathRate,
                        fortyS.deathCnt,
                        fortyS.genderAndAge))
                .from(fortyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return fortyS.date.eq(condition);
    }
}
