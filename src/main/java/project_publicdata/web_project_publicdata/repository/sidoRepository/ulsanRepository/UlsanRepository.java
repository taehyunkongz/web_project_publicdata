package project_publicdata.web_project_publicdata.repository.sidoRepository.ulsanRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Ulsan;

@Repository
public interface UlsanRepository  extends JpaRepository<Ulsan, Long>, UlsanRepositoryCustom {
}
