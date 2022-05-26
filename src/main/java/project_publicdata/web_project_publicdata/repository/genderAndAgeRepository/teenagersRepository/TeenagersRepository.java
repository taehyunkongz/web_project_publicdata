package project_publicdata.web_project_publicdata.repository.genderAndAgeRepository.teenagersRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_publicdata.web_project_publicdata.entity.genderAndAge.age.Teenagers;

@Repository
public interface TeenagersRepository extends JpaRepository<Teenagers, Long>, TeenagersRepositoryCustom {
}
