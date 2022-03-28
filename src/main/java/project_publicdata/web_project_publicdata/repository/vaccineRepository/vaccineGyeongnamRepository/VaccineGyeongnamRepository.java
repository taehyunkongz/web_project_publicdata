package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongnamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineGyeongnam;

@Repository
public interface VaccineGyeongnamRepository extends JpaRepository<VaccineGyeongnam, Long> {
}
