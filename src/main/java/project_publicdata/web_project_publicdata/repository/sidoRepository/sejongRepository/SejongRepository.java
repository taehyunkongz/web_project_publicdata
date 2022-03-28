package project_publicdata.web_project_publicdata.repository.sidoRepository.sejongRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Sejong;

@Repository
public interface SejongRepository  extends JpaRepository<Sejong, Long>, SejongRepositoryCustom {
}
