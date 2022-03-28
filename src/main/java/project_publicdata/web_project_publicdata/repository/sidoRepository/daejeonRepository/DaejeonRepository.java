package project_publicdata.web_project_publicdata.repository.sidoRepository.daejeonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Daejeon;

@Repository
public interface DaejeonRepository  extends JpaRepository<Daejeon, Long>, DaejeonRepositoryCustom {
}
