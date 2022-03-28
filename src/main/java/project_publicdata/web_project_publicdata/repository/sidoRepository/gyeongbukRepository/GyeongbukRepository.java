package project_publicdata.web_project_publicdata.repository.sidoRepository.gyeongbukRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.sido.Gyeongbuk;

@Repository
public interface GyeongbukRepository extends JpaRepository<Gyeongbuk, Long>, GyeongbukRepositoryCustom {
}
