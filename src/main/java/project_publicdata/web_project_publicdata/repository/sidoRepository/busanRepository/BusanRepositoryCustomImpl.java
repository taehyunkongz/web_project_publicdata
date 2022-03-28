package project_publicdata.web_project_publicdata.repository.sidoRepository.busanRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project_publicdata.web_project_publicdata.entity.QBusan;

import java.util.List;

import static com.querydsl.jpa.JPAExpressions.*;
import static project_publicdata.web_project_publicdata.entity.QBusan.busan;

@RequiredArgsConstructor
public class BusanRepositoryCustomImpl implements BusanRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Integer> addCount() {
        QBusan busanSub = new QBusan("busanSub"); // 서브쿼리 사용할때
        return queryFactory
                .select(busan.defCnt.sum())
                .from(busan)
                .where(busan.defCnt.eq(
                        select(busanSub.defCnt.max())
                                .from(busanSub)
                ))
                .fetch();
    }


}
