package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.femaleRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.gender.Female;

@Repository
public interface FemaleRepository extends JpaRepository<Female, Long> {
}
