package project_publicdata.web_project_publicdata.repository.sidoRepository.chungbukRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Chungbuk;

@Repository
public interface ChungbukRepository extends JpaRepository<Chungbuk, Long>, ChungbukRepositoryCustom {
}
