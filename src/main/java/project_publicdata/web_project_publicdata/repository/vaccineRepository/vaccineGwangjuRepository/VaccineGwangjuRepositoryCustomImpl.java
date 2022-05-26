package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGwangjuRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGwangjuDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineGwangju.vaccineGwangju;

@RequiredArgsConstructor
public class VaccineGwangjuRepositoryCustomImpl implements VaccineGwangjuRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getGwangjuFirstCnt() {
        return queryFactory
                .select(vaccineGwangju.firstCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuSecondCnt() {
        return queryFactory
                .select(vaccineGwangju.secondCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuThirdCnt() {
        return queryFactory
                .select(vaccineGwangju.thirdCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuAccFirstCnt() {
        return queryFactory
                .select(vaccineGwangju.accFirstCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuAccSecondCnt() {
        return queryFactory
                .select(vaccineGwangju.accSecondCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuAccThirdCnt() {
        return queryFactory
                .select(vaccineGwangju.accThirdCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuTotalFirstCnt() {
        return queryFactory
                .select(vaccineGwangju.totalFirstCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuTotalSecondCnt() {
        return queryFactory
                .select(vaccineGwangju.totalSecondCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGwangjuTotalThirdCnt() {
        return queryFactory
                .select(vaccineGwangju.totalThirdCnt)
                .from(vaccineGwangju)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineGwangjuDto> getAllVaccineCountGwangju(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineGwangjuDto.class,
                        vaccineGwangju.firstCnt,
                        vaccineGwangju.secondCnt,
                        vaccineGwangju.thirdCnt,
                        vaccineGwangju.accFirstCnt,
                        vaccineGwangju.accSecondCnt,
                        vaccineGwangju.accThirdCnt,
                        vaccineGwangju.totalFirstCnt,
                        vaccineGwangju.totalSecondCnt,
                        vaccineGwangju.totalThirdCnt,
                        vaccineGwangju.sido))
                .from(vaccineGwangju)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineGwangju.date.eq(condition);
    }
}
