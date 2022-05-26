package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fortySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.FortyS;

@Repository
public interface FortySRepository extends JpaRepository<FortyS, Long>, FortySRepositoryCustom {
}
