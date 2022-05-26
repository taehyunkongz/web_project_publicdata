package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.eightySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.EightySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QEightyS.eightyS;

@RequiredArgsConstructor
@Repository
public class EightySRepositoryCustomImpl implements EightySRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getEightySConfCase() {
        return queryFactory
                .select(eightyS.confCase)
                .from(eightyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getEightySConfCaseRate() {
        return queryFactory
                .select(eightyS.confCaseRate)
                .from(eightyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getEightySDeathCnt() {
        return queryFactory
                .select(eightyS.deathCnt)
                .from(eightyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getEightySDeathRate() {
        return queryFactory
                .select(eightyS.deathRate)
                .from(eightyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getEightySCriticalRate() {
        return queryFactory
                .select(eightyS.criticalRate)
                .from(eightyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<EightySDto> getAllCountEightyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(EightySDto.class,
                        eightyS.confCase,
                        eightyS.confCaseRate,
                        eightyS.criticalRate,
                        eightyS.deathRate,
                        eightyS.deathCnt,
                        eightyS.genderAndAge))
                .from(eightyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return eightyS.date.eq(condition);
    }
}
