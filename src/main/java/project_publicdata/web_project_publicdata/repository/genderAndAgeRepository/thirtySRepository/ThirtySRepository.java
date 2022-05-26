package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.thirtySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.ThirtyS;

@Repository
public interface ThirtySRepository extends JpaRepository<ThirtyS, Long>, ThirtySRepositoryCustom {
}
