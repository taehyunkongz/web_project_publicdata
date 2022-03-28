package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaejeonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineDaejeon;

@Repository
public interface VaccineDaejeonRepository extends JpaRepository<VaccineDaejeon, Long> {
}
