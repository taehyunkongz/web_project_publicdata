package project_publicdata.web_project_publicdata.repository.sidoRepository.incheonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_publicdata.web_project_publicdata.entity.sido.Incheon;

public interface IncheonRepository extends JpaRepository<Incheon, Long>, IncheonRepositoryCustom {
}
