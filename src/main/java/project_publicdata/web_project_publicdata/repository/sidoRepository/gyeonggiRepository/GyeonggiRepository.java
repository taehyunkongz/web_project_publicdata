package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeonggiRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Gyeonggi;

@Repository
public interface GyeonggiRepository extends JpaRepository<Gyeonggi, Long>, GyeonggiRepositoryCustom {
}
