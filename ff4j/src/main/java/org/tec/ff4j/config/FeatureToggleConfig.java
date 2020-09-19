package org.tec.ff4j.config;

import org.ff4j.FF4j;
import org.ff4j.audit.repository.EventRepository;
import org.ff4j.audit.repository.JdbcEventRepository;
import org.ff4j.cache.InMemoryCacheManager;
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc;
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * https://github.com/ff4j/ff4j/wiki/Store-Technologies
 */
@Configuration
public class FeatureToggleConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public FF4j getFF4j() {
        FF4j ff4j = new FF4j();

        //TODO
        // https://github.com/ff4j/ff4j/wiki/Store-Technologies#aws-ssm-parameter-store

// Feature States in a RDBMS
        FeatureStoreSpringJdbc featureStore= new FeatureStoreSpringJdbc();
        featureStore.setDataSource(dataSource);
        ff4j.setFeatureStore(featureStore);

// Properties in RDBMS
        PropertyStoreSpringJdbc propertyStore= new PropertyStoreSpringJdbc();
        propertyStore.setDataSource(dataSource);
        ff4j.setPropertiesStore(propertyStore);

// Audit in RDBMS
// So far the implementation with SpringJDBC is not there, leverage on default JDBC
        EventRepository eventRepository = new JdbcEventRepository(dataSource);
        ff4j.setEventRepository(eventRepository);

        ff4j.audit(true);

        // When evaluting not existing features, ff4j will create then but disabled
        // ff4j.autoCreate(true);

        // To define RBAC access, the application must have a logged user
        //ff4j.setAuthManager(...);

        // To define a cacher layer to relax the DB, multiple implementations
        ff4j.cache(new InMemoryCacheManager());

        return ff4j;
    }
}