package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeonggiRepository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.dto.DateDto;
import project_publicdata.web_project_publicdata.dto.vaccineDto.VaccineGyeonggiDto;

import java.time.LocalDate;
import java.util.List;

import static project_publicdata.web_project_publicdata.entity.vaccine.QVaccineGyeonggi.vaccineGyeonggi;

@RequiredArgsConstructor
public class VaccineGyeonggiRepositoryCustomImpl implements VaccineGyeonggiRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Integer> getGyeonggiFirstCnt() {
        return queryFactory
                .select(vaccineGyeonggi.firstCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiSecondCnt() {
        return queryFactory
                .select(vaccineGyeonggi.secondCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiThirdCnt() {
        return queryFactory
                .select(vaccineGyeonggi.thirdCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiAccFirstCnt() {
        return queryFactory
                .select(vaccineGyeonggi.accFirstCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiAccSecondCnt() {
        return queryFactory
                .select(vaccineGyeonggi.accSecondCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiAccThirdCnt() {
        return queryFactory
                .select(vaccineGyeonggi.accThirdCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiTotalFirstCnt() {
        return queryFactory
                .select(vaccineGyeonggi.totalFirstCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiTotalSecondCnt() {
        return queryFactory
                .select(vaccineGyeonggi.totalSecondCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<Integer> getGyeonggiTotalThirdCnt() {
        return queryFactory
                .select(vaccineGyeonggi.totalThirdCnt)
                .from(vaccineGyeonggi)
                .where(

                )
                .fetch();
    }

    @Override
    public List<VaccineGyeonggiDto> getAllVaccineCountGyeonggi(DateDto date) {
        return queryFactory
                .select(Projections.fields(VaccineGyeonggiDto.class,
                        vaccineGyeonggi.firstCnt,
                        vaccineGyeonggi.secondCnt,
                        vaccineGyeonggi.thirdCnt,
                        vaccineGyeonggi.accFirstCnt,
                        vaccineGyeonggi.accSecondCnt,
                        vaccineGyeonggi.accThirdCnt,
                        vaccineGyeonggi.totalFirstCnt,
                        vaccineGyeonggi.totalSecondCnt,
                        vaccineGyeonggi.totalThirdCnt,
                        vaccineGyeonggi.sido))
                .from(vaccineGyeonggi)
                .where(dateCondition(date))
                .fetch();
    }

    private static BooleanExpression dateCondition(DateDto date) {
        LocalDate condition = LocalDate.parse(
                date.getYear() + "-" + date.getMonth() + "-" + date.getDay());

        return vaccineGyeonggi.date.eq(condition);
    }
}
