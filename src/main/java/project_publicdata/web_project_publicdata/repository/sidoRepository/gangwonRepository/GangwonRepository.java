package project_publicdata.web_project_publicdata.repository.sidoRepository.gangwonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Gangwon;

@Repository
public interface GangwonRepository extends JpaRepository<Gangwon, Long>, GangwonRepositoryCustom {
}
