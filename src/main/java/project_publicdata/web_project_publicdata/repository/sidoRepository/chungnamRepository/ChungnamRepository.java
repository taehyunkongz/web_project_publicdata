package project_publicdata.web_project_publicdata.repository.sidoRepository.chungnamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Chungnam;

@Repository
public interface ChungnamRepository extends JpaRepository<Chungnam, Long>, ChungnamRepositoryCustom {
}
