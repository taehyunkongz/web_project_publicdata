package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJejuRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineJejuDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineJeju.vaccineJeju;

@RequiredArgsConstructor
public class VaccineJejuRepositoryCustomImpl implements VaccineJejuRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getJejuFirstCnt() {
        return queryFactory
                .select(vaccineJeju.firstCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuSecondCnt() {
        return queryFactory
                .select(vaccineJeju.secondCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuThirdCnt() {
        return queryFactory
                .select(vaccineJeju.thirdCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuAccFirstCnt() {
        return queryFactory
                .select(vaccineJeju.accFirstCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuAccSecondCnt() {
        return queryFactory
                .select(vaccineJeju.accSecondCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();    }

    @Override
    public List<Integer> getJejuAccThirdCnt() {
        return queryFactory
                .select(vaccineJeju.accThirdCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuTotalFirstCnt() {
        return queryFactory
                .select(vaccineJeju.totalFirstCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuTotalSecondCnt() {
        return queryFactory
                .select(vaccineJeju.totalSecondCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJejuTotalThirdCnt() {
        return queryFactory
                .select(vaccineJeju.totalThirdCnt)
                .from(vaccineJeju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineJejuDto> getAllVaccineCountJeju(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineJejuDto.class,
                        vaccineJeju.firstCnt,
                        vaccineJeju.secondCnt,
                        vaccineJeju.thirdCnt,
                        vaccineJeju.accFirstCnt,
                        vaccineJeju.accSecondCnt,
                        vaccineJeju.accThirdCnt,
                        vaccineJeju.totalFirstCnt,
                        vaccineJeju.totalSecondCnt,
                        vaccineJeju.totalThirdCnt,
                        vaccineJeju.sido))
                .from(vaccineJeju)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineJeju.date.eq(condition);
    }
}
