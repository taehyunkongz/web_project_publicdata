package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongnamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Gyeongnam;

@Repository
public interface GyeongnamRepository extends JpaRepository<Gyeongnam, Long>, GyeongnamRepositoryCustom {
}
