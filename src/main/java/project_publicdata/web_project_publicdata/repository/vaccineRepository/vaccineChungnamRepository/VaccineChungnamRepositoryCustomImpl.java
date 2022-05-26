package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungnamRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineChungnamDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineChungnam.vaccineChungnam;

@RequiredArgsConstructor
public class VaccineChungnamRepositoryCustomImpl implements VaccineChungnamRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getChungnamFirstCnt() {
        return queryFactory
                .select(vaccineChungnam.firstCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamSecondCnt() {
        return queryFactory
                .select(vaccineChungnam.secondCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamThirdCnt() {
        return queryFactory
                .select(vaccineChungnam.thirdCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamAccFirstCnt() {
        return queryFactory
                .select(vaccineChungnam.accFirstCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamAccSecondCnt() {
        return queryFactory
                .select(vaccineChungnam.accSecondCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamAccThirdCnt() {
        return queryFactory
                .select(vaccineChungnam.accThirdCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamTotalFirstCnt() {
        return queryFactory
                .select(vaccineChungnam.totalFirstCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamTotalSecondCnt() {
        return queryFactory
                .select(vaccineChungnam.totalSecondCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getChungnamTotalThirdCnt() {
        return queryFactory
                .select(vaccineChungnam.totalThirdCnt)
                .from(vaccineChungnam)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineChungnamDto> getAllVaccineCountChungnam(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineChungnamDto.class,
                        vaccineChungnam.firstCnt,
                        vaccineChungnam.secondCnt,
                        vaccineChungnam.thirdCnt,
                        vaccineChungnam.accFirstCnt,
                        vaccineChungnam.accSecondCnt,
                        vaccineChungnam.accThirdCnt,
                        vaccineChungnam.totalFirstCnt,
                        vaccineChungnam.totalSecondCnt,
                        vaccineChungnam.totalThirdCnt,
                        vaccineChungnam.sido))
                .from(vaccineChungnam)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineChungnam.date.eq(condition);
    }
}
