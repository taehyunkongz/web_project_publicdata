package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJejuRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineJeju;

@Repository
public interface VaccineJejuRepository extends JpaRepository<VaccineJeju, Long>, VaccineJejuRepositoryCustom {
}
