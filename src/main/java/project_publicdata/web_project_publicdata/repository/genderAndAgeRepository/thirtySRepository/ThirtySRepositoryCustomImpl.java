package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.thirtySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.ThirtySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QThirtyS.thirtyS;

@RequiredArgsConstructor
public class ThirtySRepositoryCustomImpl implements ThirtySRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getThirtySConfCase() {
        return queryFactory
                .select(thirtyS.confCase)
                .from(thirtyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getThirtySConfCaseRate() {
        return queryFactory
                .select(thirtyS.confCaseRate)
                .from(thirtyS)
                .where(

                )
                .fetch();
    }

        @Override
        public List<Integer> getThirtySDeathCnt () {
            return queryFactory
                    .select(thirtyS.deathCnt)
                    .from(thirtyS)
                    .where(

                    )
                    .fetch();
        }

        @Override
        public List<Double> getThirtySDeathRate () {
            return queryFactory
                    .select(thirtyS.deathRate)
                    .from(thirtyS)
                    .where(

                    )
                    .fetch();
        }

        @Override
        public List<Double> getThirtySCriticalRate () {
            return queryFactory
                    .select(thirtyS.criticalRate)
                    .from(thirtyS)
                    .where(

                    )
                    .fetch();
        }

    @Override
    public List<ThirtySDto> getAllCountThirtyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(ThirtySDto.class,
                        thirtyS.confCase,
                        thirtyS.confCaseRate,
                        thirtyS.criticalRate,
                        thirtyS.deathRate,
                        thirtyS.deathCnt,
                        thirtyS.genderAndAge))
                .from(thirtyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return thirtyS.date.eq(condition);
    }

}
