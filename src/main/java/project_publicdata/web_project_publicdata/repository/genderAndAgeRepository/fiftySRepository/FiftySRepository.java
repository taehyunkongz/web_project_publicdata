package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.fiftySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.FiftyS;

@Repository
public interface FiftySRepository extends JpaRepository<FiftyS, Long>, FiftySRepositoryCustom {
}
