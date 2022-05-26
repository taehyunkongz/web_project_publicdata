package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.femaleRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.FemaleDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.gender.QFemale.female;

@RequiredArgsConstructor
public class FemaleRepositoryCustomImpl implements FemaleRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getFemaleConfCase() {
        return queryFactory
                .select(female.confCase)
                .from(female)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFemaleConfCaseRate() {
        return queryFactory
                .select(female.confCaseRate)
                .from(female)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getFemaleDeathCnt() {
        return queryFactory
                .select(female.deathCnt)
                .from(female)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFemaleDeathRate() {
        return queryFactory
                .select(female.deathRate)
                .from(female)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFemaleCriticalRate() {
        return queryFactory
                .select(female.criticalRate)
                .from(female)
                .where(

                )
                .fetch();
    }

    @Override
    public List<FemaleDto> getAllCountFemale(DateDto date) {
        return queryFactory
                .select(Projections.fields(FemaleDto.class,
                        female.confCase,
                        female.confCaseRate,
                        female.criticalRate,
                        female.deathRate,
                        female.deathCnt,
                        female.genderAndAge))
                .from(female)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return female.date.eq(condition);
    }
}
