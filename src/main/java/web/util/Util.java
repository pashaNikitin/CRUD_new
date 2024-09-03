package web.util;//package org.example.util;
//
//import org.example.model.User;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Util {
//    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "pavel";
//
////    public static Connection createConnection() throws SQLException {
////        return DriverManager.getConnection(URL, USER, PASSWORD);
////    }
//
//    private static SessionFactory sessionFactory;
//
//    static {
//        try {
//            //настройка хибера
//            Configuration configuration = new Configuration();
//
//            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
//            configuration.setProperty("hibernate.connection.username", "postgres");
//            configuration.setProperty("hibernate.connection.password", "pavel");
//            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//            configuration.setProperty("hibernate.show_sql", "true");
//
//            // configuration.addAnnotatedClass(User.class); добавляет класс User в конфигурацию Hibernate.
//            // Этот класс должен быть аннотирован с использованием аннотаций Hibernate (например, @Entity, @Table, @Id
//            configuration.addAnnotatedClass(User.class);
//
//            sessionFactory = configuration.buildSessionFactory();
//            // создает и инициализирует SessionFactory на основе настроенной конфигурации. SessionFactory является основным интерфейсом для взаимодействия
//            // с Hibernate и используется для создания сессий (объектов Session), которые представляют собой единицы работы с базой данных.
//
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}
