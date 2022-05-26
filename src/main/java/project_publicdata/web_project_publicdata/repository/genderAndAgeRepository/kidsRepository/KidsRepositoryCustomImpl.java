package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.kidsRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.KidsDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.genderAndAge.age.QKids.kids;

@RequiredArgsConstructor
public class KidsRepositoryCustomImpl implements KidsRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getKidsConfCase() {
        return queryFactory
                .select(kids.confCase)
                .from(kids)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getKidsConfCaseRate() {
        return queryFactory
                .select(kids.confCaseRate)
                .from(kids)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getKidsDeathCnt() {
        return queryFactory
                .select(kids.deathCnt)
                .from(kids)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getKidsDeathRate() {
        return queryFactory
                .select(kids.deathRate)
                .from(kids)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Double> getKidsCriticalRate() {
        return queryFactory
                .select(kids.criticalRate)
                .from(kids)
                .where(

                )
                .fetch();
    }

    @Override
    public List<KidsDto> getAllCountKids(DateDto date) {
        return queryFactory
                .select(Projections.fields(KidsDto.class,
                        kids.confCase,
                        kids.confCaseRate,
                        kids.criticalRate,
                        kids.deathRate,
                        kids.deathCnt,
                        kids.genderAndAge))
                .from(kids)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return kids.date.eq(condition);
    }
}
