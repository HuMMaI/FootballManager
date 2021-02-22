package dmytro.kudriavtsev.footballmanager;

import dmytro.kudriavtsev.footballmanager.entities.Footballer;
import dmytro.kudriavtsev.footballmanager.entities.Statement;
import dmytro.kudriavtsev.footballmanager.entities.Team;
import dmytro.kudriavtsev.footballmanager.repos.FootballerRepository;
import dmytro.kudriavtsev.footballmanager.repos.StatementRepository;
import dmytro.kudriavtsev.footballmanager.repos.TeamRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class FootballManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballManagerApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	public ApplicationRunner initializer(TeamRepository teamRepository, FootballerRepository footballerRepository, StatementRepository statementRepository) {
		Team team1 = new Team("Arsenal", 2, "England", 5, 1000000);
		Team team2 = new Team("Real Madrid", 1, "Spain", 7, 1000000);
		Team team3 = new Team("Juventus", 4, "Italy", 4, 50000);

		Footballer footballer1 = new Footballer("Bernd", "Leno", 30, 22, 43000);
		Footballer footballer2 = new Footballer("Cedric", "Soares", 24, 20, 55000);

		Footballer footballer3 = new Footballer("Sergio", "Ramos", 28, 33, 100000);

		Footballer footballer4 = new Footballer("Gianluigi", "Buffon", 50, 53, 135000);
		Footballer footballer5 = new Footballer("Merih", "Demiral", 25, 24, 76000);
		Footballer footballer6 = new Footballer("Cristiano", "Ronaldo", 31, 40, 145000);
		Footballer footballer7 = new Footballer("Paulo", "Dybala", 27, 31, 100000);

		Statement statement1 = new Statement(team1, footballer1);
		Statement statement2 = new Statement(team1, footballer2);

		Statement statement3 = new Statement(team2, footballer3);

		Statement statement4 = new Statement(team3, footballer4);
		Statement statement5 = new Statement(team3, footballer5);
		Statement statement6 = new Statement(team3, footballer6);
		Statement statement7 = new Statement(team3, footballer7);

		return args -> {
			teamRepository.saveAll(Arrays.asList(team1, team2, team3));
			footballerRepository.saveAll(Arrays.asList(footballer1, footballer2, footballer3, footballer4, footballer5, footballer6, footballer7));
			statementRepository.saveAll(Arrays.asList(statement1, statement2, statement3, statement4, statement5, statement6, statement7));
		};
	}

}
