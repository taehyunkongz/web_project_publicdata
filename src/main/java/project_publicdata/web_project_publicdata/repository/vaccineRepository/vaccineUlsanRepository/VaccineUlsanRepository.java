package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineUlsanRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineUlsan;

@Repository
public interface VaccineUlsanRepository extends JpaRepository<VaccineUlsan, Long> {
}
