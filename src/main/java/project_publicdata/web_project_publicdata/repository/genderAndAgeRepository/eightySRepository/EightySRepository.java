package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.eightySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.EightyS;

@Repository
public interface EightySRepository extends JpaRepository<EightyS, Long>, EightySRepositoryCustom {
}
