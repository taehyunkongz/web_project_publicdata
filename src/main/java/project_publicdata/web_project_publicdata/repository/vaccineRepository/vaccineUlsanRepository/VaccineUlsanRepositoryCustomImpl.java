package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineUlsanRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineUlsanDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineUlsan.vaccineUlsan;

@RequiredArgsConstructor
public class VaccineUlsanRepositoryCustomImpl implements VaccineUlsanRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getUlsanFirstCnt() {
        return queryFactory
                .select(vaccineUlsan.firstCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanSecondCnt() {
        return queryFactory
                .select(vaccineUlsan.secondCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanThirdCnt() {
        return queryFactory
                .select(vaccineUlsan.thirdCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanAccFirstCnt() {
        return queryFactory
                .select(vaccineUlsan.accFirstCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanAccSecondCnt() {
        return queryFactory
                .select(vaccineUlsan.accSecondCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanAccThirdCnt() {
        return queryFactory
                .select(vaccineUlsan.accThirdCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanTotalFirstCnt() {
        return queryFactory
                .select(vaccineUlsan.totalFirstCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanTotalSecondCnt() {
        return queryFactory
                .select(vaccineUlsan.totalSecondCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getUlsanTotalThirdCnt() {
        return queryFactory
                .select(vaccineUlsan.totalThirdCnt)
                .from(vaccineUlsan)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineUlsanDto> getAllVaccineCountUlsan(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineUlsanDto.class,
                        vaccineUlsan.firstCnt,
                        vaccineUlsan.secondCnt,
                        vaccineUlsan.thirdCnt,
                        vaccineUlsan.accFirstCnt,
                        vaccineUlsan.accSecondCnt,
                        vaccineUlsan.accThirdCnt,
                        vaccineUlsan.totalFirstCnt,
                        vaccineUlsan.totalSecondCnt,
                        vaccineUlsan.totalThirdCnt,
                        vaccineUlsan.sido))
                .from(vaccineUlsan)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineUlsan.date.eq(condition);
    }

}



