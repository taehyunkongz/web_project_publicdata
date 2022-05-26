package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.twentySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.TwentyS;

@Repository
public interface TwentySRepository extends JpaRepository<TwentyS, Long>, TwentySRepositoryCustom {
}
