package project_publicdata.web_project_publicdata.repository.sidoRepository.daeguRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Daegu;

@Repository
public interface DaeguRepository  extends JpaRepository<Daegu, Long>, DaeguRepositoryCustom {
}
