package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSejongRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineSejong;

@Repository
public interface VaccineSejongRepository extends JpaRepository<VaccineSejong, Long> {
}
