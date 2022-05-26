package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.seventySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.SeventySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QSeventyS.seventyS;

@RequiredArgsConstructor
public class SeventySRepositoryCustomImpl implements SeventySRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getSeventySConfCase() {
        return queryFactory
                .select(seventyS.confCase)
                .from(seventyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getSeventySConfCaseRate() {
        return queryFactory
                .select(seventyS.confCaseRate)
                .from(seventyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSeventySDeathCnt() {
        return queryFactory
                .select(seventyS.deathCnt)
                .from(seventyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getSeventySDeathRate() {
        return queryFactory
                .select(seventyS.deathRate)
                .from(seventyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getSeventySCriticalRate() {
        return queryFactory
                .select(seventyS.criticalRate)
                .from(seventyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<SeventySDto> getAllCountSeventyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(SeventySDto.class,
                        seventyS.confCase,
                        seventyS.confCaseRate,
                        seventyS.criticalRate,
                        seventyS.deathRate,
                        seventyS.deathCnt,
                        seventyS.genderAndAge))
                .from(seventyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return seventyS.date.eq(condition);
    }
}
