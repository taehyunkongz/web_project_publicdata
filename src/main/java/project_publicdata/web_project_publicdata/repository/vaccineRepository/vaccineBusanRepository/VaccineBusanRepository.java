package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineBusanRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineBusan;

@Repository
public interface VaccineBusanRepository extends JpaRepository<VaccineBusan, Long> {
}
