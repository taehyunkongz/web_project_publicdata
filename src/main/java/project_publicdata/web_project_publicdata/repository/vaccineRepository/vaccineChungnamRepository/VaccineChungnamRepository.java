package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungnamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineChungnam;

@Repository
public interface VaccineChungnamRepository extends JpaRepository<VaccineChungnam, Long> {
}
