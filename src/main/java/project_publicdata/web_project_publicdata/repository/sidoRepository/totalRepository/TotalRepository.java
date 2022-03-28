package project_publicdata.web_project_publicdata.repository.sidoRepository.totalRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Total;

@Repository
public interface TotalRepository  extends JpaRepository<Total, Long>, TotalRepositoryCustom {
}
