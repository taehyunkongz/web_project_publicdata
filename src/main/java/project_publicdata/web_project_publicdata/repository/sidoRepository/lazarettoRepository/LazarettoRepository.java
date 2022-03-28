package project_publicdata.web_project_publicdata.repository.sidoRepository.lazarettoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Lazaretto;

@Repository
public interface LazarettoRepository  extends JpaRepository<Lazaretto, Long>, LazarettoRepositoryCustom {
}
