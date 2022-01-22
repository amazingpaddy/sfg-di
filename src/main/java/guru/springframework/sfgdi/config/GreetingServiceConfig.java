package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasource.FakeDatasource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@ImportResource("classpath:sfd-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDatasource fakeDatasource(final SfgConstructorConfig config) {
        FakeDatasource fakeDatasource = new FakeDatasource();
        fakeDatasource.setName(config.getName());
        fakeDatasource.setPassword(config.getPassword());
        fakeDatasource.setJdbcUrl(config.getJdbcUrl());
        return fakeDatasource;
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService() {
        return new I18nEnglishGreetingService(englishGreetingRepository());
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }

    //For this we are using XML Configuration. So commenting @Bean annotation. Spring will create bean from xml.
/*    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }*/

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
