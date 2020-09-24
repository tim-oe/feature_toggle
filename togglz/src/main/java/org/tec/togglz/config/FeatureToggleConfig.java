package org.tec.togglz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.togglz.core.Feature;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.UserProvider;
import org.togglz.spring.security.SpringSecurityUserProvider;

import javax.sql.DataSource;

/**
 * https://github.com/ff4j/ff4j/wiki/Store-Technologies
 */
@Configuration
@ApplicationScope
@ConditionalOnProperty(value="togglz.enabled", havingValue = "true", matchIfMissing = false)
public class FeatureToggleConfig implements TogglzConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(SampleFeatures.class);
    }

    @Bean
    @Override
    public Class<? extends Feature> getFeatureClass() {
        return null;
    }

    @Bean
    @Override
    public StateRepository getStateRepository() {
        return new JDBCStateRepository(dataSource);
    }

    @Bean
    @Override
    public UserProvider getUserProvider() {
        return new SpringSecurityUserProvider("ROLE_ADMIN");
    }
}