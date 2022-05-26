package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.sixtySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.SixtySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QSixtyS.sixtyS;

@RequiredArgsConstructor
public class SixtySRepositoryCustomImpl implements SixtySRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getSixtySConfCase() {
        return queryFactory
                .select(sixtyS.confCase)
                .from(sixtyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getSixtySConfCaseRate() {
        return queryFactory
                .select(sixtyS.confCaseRate)
                .from(sixtyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getSixtySDeathCnt() {
        return queryFactory
                .select(sixtyS.deathCnt)
                .from(sixtyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getSixtySDeathRate() {
        return queryFactory
                .select(sixtyS.deathRate)
                .from(sixtyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getSixtySCriticalRate() {
        return queryFactory
                .select(sixtyS.criticalRate)
                .from(sixtyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<SixtySDto> getAllCountSixtyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(SixtySDto.class,
                        sixtyS.confCase,
                        sixtyS.confCaseRate,
                        sixtyS.criticalRate,
                        sixtyS.deathRate,
                        sixtyS.deathCnt,
                        sixtyS.genderAndAge))
                .from(sixtyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return sixtyS.date.eq(condition);
    }
}
