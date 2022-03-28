package project_publicdata.web_project_publicdata.repository.sidoRepository.jeonnamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Jeonnam;

@Repository
public interface JeonnamRepository extends JpaRepository<Jeonnam, Long>, JeonnamRepositoryCustom {
}
