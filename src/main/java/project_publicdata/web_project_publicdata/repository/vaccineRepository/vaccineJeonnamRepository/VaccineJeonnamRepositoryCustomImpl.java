package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonnamRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineJeonnamDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineJeonnam.vaccineJeonnam;

@RequiredArgsConstructor
public class VaccineJeonnamRepositoryCustomImpl implements VaccineJeonnamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getJeonnamFirstCnt() {
        return queryFactory
                .select(vaccineJeonnam.firstCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamSecondCnt() {
        return queryFactory
                .select(vaccineJeonnam.secondCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamThirdCnt() {
        return queryFactory
                .select(vaccineJeonnam.thirdCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamAccFirstCnt() {
        return queryFactory
                .select(vaccineJeonnam.accFirstCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamAccSecondCnt() {
        return queryFactory
                .select(vaccineJeonnam.accSecondCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamAccThirdCnt() {
        return queryFactory
                .select(vaccineJeonnam.accThirdCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamTotalFirstCnt() {
        return queryFactory
                .select(vaccineJeonnam.totalFirstCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamTotalSecondCnt() {
        return queryFactory
                .select(vaccineJeonnam.totalSecondCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getJeonnamTotalThirdCnt() {
        return queryFactory
                .select(vaccineJeonnam.totalThirdCnt)
                .from(vaccineJeonnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineJeonnamDto> getAllVaccineCountJeonnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineJeonnamDto.class,
                        vaccineJeonnam.firstCnt,
                        vaccineJeonnam.secondCnt,
                        vaccineJeonnam.thirdCnt,
                        vaccineJeonnam.accFirstCnt,
                        vaccineJeonnam.accSecondCnt,
                        vaccineJeonnam.accThirdCnt,
                        vaccineJeonnam.totalFirstCnt,
                        vaccineJeonnam.totalSecondCnt,
                        vaccineJeonnam.totalThirdCnt,
                        vaccineJeonnam.sido))
                .from(vaccineJeonnam)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineJeonnam.date.eq(condition);
    }
}
