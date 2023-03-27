package bg.softuni.ToolShop.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OtherConfiguration {

    @Bean
    public RestTemplate create(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.
                build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }


}
