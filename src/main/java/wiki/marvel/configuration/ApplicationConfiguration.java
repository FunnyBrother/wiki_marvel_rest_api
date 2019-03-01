package wiki.marvel.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.marvel.repository.HeroRepository;
import wiki.marvel.service.HeroService;
import wiki.marvel.service.implementation.HeroServiceImpl;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public HeroService getHeroService(HeroRepository heroRepository) {
        return new HeroServiceImpl(heroRepository);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
