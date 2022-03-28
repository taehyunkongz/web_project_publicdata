package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.sixtySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.SixtyS;

@Repository
public interface SixtySRepository extends JpaRepository<SixtyS, Long> {
}
