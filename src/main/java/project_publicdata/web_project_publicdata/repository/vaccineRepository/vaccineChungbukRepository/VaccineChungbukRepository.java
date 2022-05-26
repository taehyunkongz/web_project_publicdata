package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineChungbukRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineChungbuk;

@Repository
public interface VaccineChungbukRepository extends JpaRepository<VaccineChungbuk, Long>, VaccineChungbukRepositoryCustom {
}
