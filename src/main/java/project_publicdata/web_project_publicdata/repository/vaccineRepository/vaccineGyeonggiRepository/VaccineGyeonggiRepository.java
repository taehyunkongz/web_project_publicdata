package project_publicdata.web_project_publicdata.repository.vaccineRepository.vaccineGyeonggiRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.vaccine.VaccineGyeonggi;

@Repository
public interface VaccineGyeonggiRepository extends JpaRepository<VaccineGyeonggi, Long>, VaccineGyeonggiRepositoryCustom {
}
