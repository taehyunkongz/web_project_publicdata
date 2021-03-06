package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGwangjuRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineGwangju;

@Repository
public interface VaccineGwangjuRepository extends JpaRepository<VaccineGwangju, Long>, VaccineGwangjuRepositoryCustom {
}
