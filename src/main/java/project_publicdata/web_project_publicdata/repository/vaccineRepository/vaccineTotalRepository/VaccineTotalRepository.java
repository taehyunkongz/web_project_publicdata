package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineTotalRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineTotal;

@Repository
public interface VaccineTotalRepository extends JpaRepository<VaccineTotal, Long> {
}
