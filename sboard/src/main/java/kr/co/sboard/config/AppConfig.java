package kr.co.sboard.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AppConfig {

    @Bean
    public AppInfo appInfo(){


        return new AppInfo();
    }
}
