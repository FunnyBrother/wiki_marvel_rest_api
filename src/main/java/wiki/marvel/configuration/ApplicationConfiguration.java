package wiki.marvel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.marvel.service.HeroService;
import wiki.marvel.service.implementation.HeroServiceImpl;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public HeroService getHeroService() {
        return new HeroServiceImpl();
    }
}
