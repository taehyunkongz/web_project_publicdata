package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineIncheonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineIncheon;

@Repository
public interface VaccineIncheonRepository extends JpaRepository<VaccineIncheon, Long> {
}
