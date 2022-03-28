package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.maleRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.gender.Male;

@Repository
public interface MaleRepository extends JpaRepository<Male, Long> {
}
