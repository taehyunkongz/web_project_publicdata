package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.kidsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.Kids;

@Repository
public interface KidsRepository extends JpaRepository<Kids, Long> {
}
