package wiki.marvel.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiki.marvel.repository.HeroRepository;
import wiki.marvel.repository.UserRepository;
import wiki.marvel.service.HeroService;
import wiki.marvel.service.UserService;
import wiki.marvel.service.implementation.HeroServiceImpl;
import wiki.marvel.service.implementation.UserServiceImpl;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public HeroService getHeroService(HeroRepository heroRepository) {
        return new HeroServiceImpl(heroRepository);
    }

    @Bean
    public UserService getUserService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
