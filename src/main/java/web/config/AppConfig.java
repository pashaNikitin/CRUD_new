package web.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration // Эта аннотация указывает, что класс AppConfig является конфигурационным и содержит методы с аннотацией @Bean
@PropertySource("classpath:db.properties") // Эта аннотация указывает, что файл свойств db.properties, содержащий параметры конфигурации базы данных
@EnableJpaRepositories(basePackages = "web.dao") // Эта аннотация включает поддержку JPA репозиториев в Spring, что позволяет автоматически создавать реализации для интерфейсов репозиториев
@EnableTransactionManagement // Эта аннотация включает поддержку управления транзакциями в Spring.
@EnableWebMvc // Эта аннотация включает поддержку Spring MVC, что позволяет данному приложению обрабатывать веб-запросы.
@ComponentScan(basePackages = "web") // Эта аннотация указывает Spring, где искать компоненты, сервисы и другие бины для автоматической регистрации их в контексте.
public class AppConfig {

   @Autowired
   private Environment env;

   @Bean
   public DataSource getDataSource() { // Этот метод создает и настраивает пул соединений с базой данных с использованием библиотеки HikariCP.
      HikariConfig hikariConfig = new HikariConfig();
      hikariConfig.setDriverClassName(env.getProperty("db.driver"));
      hikariConfig.setJdbcUrl(env.getProperty("db.url"));
      hikariConfig.setUsername(env.getProperty("db.username"));
      hikariConfig.setPassword(env.getProperty("db.password"));
      return new HikariDataSource(hikariConfig);
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() { //Этот метод создает и настраивает EntityManagerFactory, который используется JPA для работы с базой данных.
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(getDataSource());
      em.setPackagesToScan("web.model");

      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // Создает адаптер для использования Hibernate как JPA-провайдера.
      em.setJpaVendorAdapter(vendorAdapter);

      Properties props = new Properties(); // Создает объект Properties для хранения свойств Hibernate.
      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

      em.setJpaProperties(props);
      return em;
   }

   @Bean
   public JpaTransactionManager transactionManager() { // Этот метод создает и настраивает JpaTransactionManager, который будет управлять транзакциями в приложении.
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
      return transactionManager;
   }


}