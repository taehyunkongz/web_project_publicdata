package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineDaeguRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineDaegu;

@Repository
public interface VaccineDaeguRepository extends JpaRepository<VaccineDaegu, Long>, VaccineDaeguRepositoryCustom {
}
