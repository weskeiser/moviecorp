package com.moviecorp.datastore.config;

import java.net.URI;
import java.net.URISyntaxException;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdDatabaseConfig {
  @Bean
  public DataSource dataSource() throws URISyntaxException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));
    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.url(dbUrl);
    dataSourceBuilder.username(username);
    dataSourceBuilder.password(password);
    return dataSourceBuilder.build();
  }
}
