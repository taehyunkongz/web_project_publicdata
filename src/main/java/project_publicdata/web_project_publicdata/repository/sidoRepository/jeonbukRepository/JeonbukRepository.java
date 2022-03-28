package project_publicdata.web_project_publicdata.repository.sidoRepository.jeonbukRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Jeonbuk;

@Repository
public interface JeonbukRepository extends JpaRepository<Jeonbuk, Long>, JeonbukRepositoryCustom {
}
