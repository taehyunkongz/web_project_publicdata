package project_publicdata.web_project_publicdata.repository.sidoRepository.busanRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Busan;

@Repository
public interface BusanRepository extends JpaRepository<Busan, Long>, BusanRepositoryCustom {

}
