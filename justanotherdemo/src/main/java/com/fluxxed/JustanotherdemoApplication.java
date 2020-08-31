package com.fluxxed;

import com.fluxxed.model.Event;
import com.fluxxed.repository.EventRepository;
import io.r2dbc.spi.ConnectionFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

@SpringBootApplication
@Slf4j
public class JustanotherdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustanotherdemoApplication.class, args);
	}


	@Bean
	public ConnectionFactoryInitializer connectionFactoryInitializer(
			ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(
				new CompositeDatabasePopulator(
						new ResourceDatabasePopulator(new ClassPathResource("schema.sql"), new ClassPathResource("data.sql"))));
		return initializer;
	}
}
