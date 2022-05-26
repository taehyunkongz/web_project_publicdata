package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.maleRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.MaleDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.gender.QMale.male;

@RequiredArgsConstructor
public class MaleRepositoryCustomImpl implements MaleRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getMaleConfCase() {
        return queryFactory
                .select(male.confCase)
                .from(male)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getMaleConfCaseRate() {
        return queryFactory
                .select(male.confCaseRate)
                .from(male)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getMaleDeathCnt() {
        return queryFactory
                .select(male.deathCnt)
                .from(male)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getMaleDeathRate() {
        return queryFactory
                .select(male.deathRate)
                .from(male)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getMaleCriticalRate() {
        return queryFactory
                .select(male.criticalRate)
                .from(male)
                .where(

                )
                .fetch();
    }

    @Override
    public List<MaleDto> getAllCountMale(DateDto date) {
        return queryFactory
                .select(Projections.fields(MaleDto.class,
                        male.confCase,
                        male.confCaseRate,
                        male.criticalRate,
                        male.deathRate,
                        male.deathCnt,
                        male.genderAndAge))
                .from(male)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return male.date.eq(condition);
    }
}
