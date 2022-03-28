package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeongbukRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineGyeongbuk;

@Repository
public interface VaccineGyeongbukRepository extends JpaRepository<VaccineGyeongbuk, Long> {
}
