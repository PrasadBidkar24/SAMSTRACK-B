//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig {
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("https://samstrack.netlify.app")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE");
//            }
//        };
//    }
//}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("https://samstrack.netlify.app") // Your Netlify URL
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Add OPTIONS
                    .allowedHeaders("*") // Allow all headers (or list specific ones)
                    .exposedHeaders("Authorization", "Set-Cookie") // Expose auth headers
                    .allowCredentials(true); // Allow cookies/auth headers
            }
        };
    }
}