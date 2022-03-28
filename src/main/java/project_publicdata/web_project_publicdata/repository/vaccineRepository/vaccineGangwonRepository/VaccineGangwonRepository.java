package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGangwonRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineGangwon;

@Repository
public interface VaccineGangwonRepository extends JpaRepository<VaccineGangwon, Long> {
}
