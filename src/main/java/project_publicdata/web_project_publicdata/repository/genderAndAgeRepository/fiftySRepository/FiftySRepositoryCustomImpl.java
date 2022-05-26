package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fiftySRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.FiftySDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QFiftyS.fiftyS;

@RequiredArgsConstructor
public class FiftySRepositoryCustomImpl implements FiftySRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getFiftySConfCase() {
        return queryFactory
                .select(fiftyS.confCase)
                .from(fiftyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFiftySConfCaseRate() {
        return queryFactory
                .select(fiftyS.confCaseRate)
                .from(fiftyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getFiftySDeathCnt() {
        return queryFactory
                .select(fiftyS.deathCnt)
                .from(fiftyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFiftySDeathRate() {
        return queryFactory
                .select(fiftyS.deathRate)
                .from(fiftyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getFiftySCriticalRate() {
        return queryFactory
                .select(fiftyS.criticalRate)
                .from(fiftyS)
                .where(

                )
                .fetch();
    }

    @Override
    public List<FiftySDto> getAllCountFiftyS(DateDto date) {
        return queryFactory
                .select(Projections.fields(FiftySDto.class,
                        fiftyS.confCase,
                        fiftyS.confCaseRate,
                        fiftyS.criticalRate,
                        fiftyS.deathRate,
                        fiftyS.deathCnt,
                        fiftyS.genderAndAge))
                .from(fiftyS)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return fiftyS.date.eq(condition);
    }
}
