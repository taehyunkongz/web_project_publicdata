package project_publicdata.web_project_publicdata.repository.sidoRepository.seoulRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Seoul;

@Repository
public interface SeoulRepository  extends JpaRepository<Seoul, Long>, SeoulRepositoryCustom {
}
