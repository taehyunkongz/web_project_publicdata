package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineJeonbukRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineJeonbuk;

@Repository
public interface VaccineJeonbukRepository extends JpaRepository<VaccineJeonbuk, Long> {
}
