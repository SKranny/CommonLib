package configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UMapperConfiguration {
    @Bean
    public ModelMapper init(){
        return new ModelMapper();
    }
}
