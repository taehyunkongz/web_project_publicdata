package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.seventySRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.SeventyS;

@Repository
public interface SeventySRepository extends JpaRepository<SeventyS, Long>, SeventySRepositoryCustom {
}
