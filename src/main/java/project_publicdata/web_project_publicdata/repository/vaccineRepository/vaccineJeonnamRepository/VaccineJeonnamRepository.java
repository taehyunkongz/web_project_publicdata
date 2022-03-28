package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonnamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineJeonnam;

@Repository
public interface VaccineJeonnamRepository extends JpaRepository<VaccineJeonnam, Long> {
}
