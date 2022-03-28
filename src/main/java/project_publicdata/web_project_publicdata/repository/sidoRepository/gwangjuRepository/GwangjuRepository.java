package project_publicdata.web_project_publicdata.repository.sidoRepository.gwangjuRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Gwangju;

@Repository
public interface GwangjuRepository  extends JpaRepository<Gwangju, Long>, GwangjuRepositoryCustom {
}
