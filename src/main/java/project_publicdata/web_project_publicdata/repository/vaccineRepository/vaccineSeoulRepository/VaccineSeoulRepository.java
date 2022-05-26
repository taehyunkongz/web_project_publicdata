package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineSeoulRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineSeoul;

@Repository
public interface VaccineSeoulRepository extends JpaRepository<VaccineSeoul, Long>, VaccineSeoulRepositoryCustom {
}
