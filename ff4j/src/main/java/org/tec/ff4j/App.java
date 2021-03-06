/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.tec.ff4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages ={
        "org.tec.ff4j.config",
        "org.tec.ff4j.svc"
})
@EntityScan(basePackages = {"org.tec.ff4j.entity"})
@EnableJpaRepositories(basePackages = {"org.tec.ff4j.repository"})
@EnableJpaAuditing
public class App {
    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}