package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.teenagersRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.TeenagersDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QTeenagers.teenagers;

@RequiredArgsConstructor
public class TeenagersRepositoryCustomImpl implements TeenagersRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getTeenagersConfCase() {
        return queryFactory
                .select(teenagers.confCase)
                .from(teenagers)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getTeenagersConfCaseRate() {
        return queryFactory
                .select(teenagers.confCaseRate)
                .from(teenagers)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getTeenagersDeathCnt() {
        return queryFactory
                .select(teenagers.deathCnt)
                .from(teenagers)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getTeenagersDeathRate() {
            return queryFactory
                    .select(teenagers.deathRate)
                    .from(teenagers)
                    .where(

                    )
                    .fetch();
    }

    @Override
    public List<Double> getTeenagersCriticalRate() {
            return queryFactory
                    .select(teenagers.criticalRate)
                    .from(teenagers)
                    .where(

                    )
                    .fetch();
    }

    @Override
    public List<TeenagersDto> getAllCountTeenagers(DateDto date) {
        return queryFactory
                .select(Projections.fields(TeenagersDto.class,
                        teenagers.confCase,
                        teenagers.confCaseRate,
                        teenagers.criticalRate,
                        teenagers.deathRate,
                        teenagers.deathCnt,
                        teenagers.genderAndAge))
                .from(teenagers)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return teenagers.date.eq(condition);
    }
}
