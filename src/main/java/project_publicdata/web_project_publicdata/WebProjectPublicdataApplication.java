package project_publicdata.web_project_publicdata;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing
public class WebProjectPublicdataApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WebProjectPublicdataApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}

}
