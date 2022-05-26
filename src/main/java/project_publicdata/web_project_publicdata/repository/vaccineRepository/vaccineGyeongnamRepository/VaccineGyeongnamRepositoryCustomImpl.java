package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongnamRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGyeongnamDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineGyeongnam.vaccineGyeongnam;

@RequiredArgsConstructor
public class VaccineGyeongnamRepositoryCustomImpl implements VaccineGyeongnamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getGyeongnamFirstCnt() {
        return queryFactory
                .select(vaccineGyeongnam.firstCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamSecondCnt() {
        return queryFactory
                .select(vaccineGyeongnam.secondCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamThirdCnt() {
        return queryFactory
                .select(vaccineGyeongnam.thirdCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamAccFirstCnt() {
        return queryFactory
                .select(vaccineGyeongnam.accFirstCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamAccSecondCnt() {
        return queryFactory
                .select(vaccineGyeongnam.accSecondCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamAccThirdCnt() {
        return queryFactory
                .select(vaccineGyeongnam.accThirdCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamTotalFirstCnt() {
        return queryFactory
                .select(vaccineGyeongnam.totalFirstCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamTotalSecondCnt() {
        return queryFactory
                .select(vaccineGyeongnam.totalSecondCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeongnamTotalThirdCnt() {
        return queryFactory
                .select(vaccineGyeongnam.totalThirdCnt)
                .from(vaccineGyeongnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineGyeongnamDto> getAllVaccineCountGyeongnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineGyeongnamDto.class,
                        vaccineGyeongnam.firstCnt,
                        vaccineGyeongnam.secondCnt,
                        vaccineGyeongnam.thirdCnt,
                        vaccineGyeongnam.accFirstCnt,
                        vaccineGyeongnam.accSecondCnt,
                        vaccineGyeongnam.accThirdCnt,
                        vaccineGyeongnam.totalFirstCnt,
                        vaccineGyeongnam.totalSecondCnt,
                        vaccineGyeongnam.totalThirdCnt,
                        vaccineGyeongnam.sido))
                .from(vaccineGyeongnam)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineGyeongnam.date.eq(condition);
    }
}
