package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGangwonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGangwonDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineGangwon.vaccineGangwon;

@RequiredArgsConstructor
public class VaccineGangwonRepositoryCustomImpl implements VaccineGangwonRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getGangwonFirstCnt() {
        return queryFactory
                .select(vaccineGangwon.firstCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonSecondCnt() {
        return queryFactory
                .select(vaccineGangwon.secondCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonThirdCnt() {
        return queryFactory
                .select(vaccineGangwon.thirdCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonAccFirstCnt() {
        return queryFactory
                .select(vaccineGangwon.accFirstCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonAccSecondCnt() {
        return queryFactory
                .select(vaccineGangwon.accSecondCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonAccThirdCnt() {
        return queryFactory
                .select(vaccineGangwon.accThirdCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonTotalFirstCnt() {
        return queryFactory
                .select(vaccineGangwon.totalFirstCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonTotalSecondCnt() {
        return queryFactory
                .select(vaccineGangwon.totalSecondCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGangwonTotalThirdCnt() {
        return queryFactory
                .select(vaccineGangwon.totalThirdCnt)
                .from(vaccineGangwon)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineGangwonDto> getAllVaccineCountGangwon(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineGangwonDto.class,
                        vaccineGangwon.firstCnt,
                        vaccineGangwon.secondCnt,
                        vaccineGangwon.thirdCnt,
                        vaccineGangwon.accFirstCnt,
                        vaccineGangwon.accSecondCnt,
                        vaccineGangwon.accThirdCnt,
                        vaccineGangwon.totalFirstCnt,
                        vaccineGangwon.totalSecondCnt,
                        vaccineGangwon.totalThirdCnt,
                        vaccineGangwon.sido))
                .from(vaccineGangwon)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineGangwon.date.eq(condition);
    }
}
