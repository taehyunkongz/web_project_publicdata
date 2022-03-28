package project_publicdata.web_project_publicdata.repository.sidoRepository.jejuRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Jeju;

@Repository
public interface JejuRepository  extends JpaRepository<Jeju, Long>, JejuRepositoryCustom {
}
