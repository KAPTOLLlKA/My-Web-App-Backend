package demo.configs;

import demo.api.repositories.SubscriptionsRepository;
import demo.interceptors.HomeInterceptor;
import demo.api.repositories.UsersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;
import demo.services.JdbcRepositoryUsersService;
import demo.api.repositories.UsersTokensRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    private HomeInterceptor interceptor;

    @Autowired
    public void setInterceptor(HomeInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("localhost:8080/**")
                .excludePathPatterns(
                        "**/users/login",
                        "**/users/logout",
                        "**/users/register",
                        "**/users/is_valid"
                );
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgre");
        Properties properties = new Properties();
        properties.setProperty("initialization-mode", "always");
        dataSource.setConnectionProperties(properties);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcRepositoryUsersService userService(UsersRepository userRepo,
                                                  UsersTokensRepository usersTokensRepo,
                                                  SubscriptionsRepository subscriptionsRepo) {
        return new JdbcRepositoryUsersService(userRepo, usersTokensRepo, subscriptionsRepo);
    }
}
