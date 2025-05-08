package com.tka.sams.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors(Customizer.withDefaults()) // Use your CORS config
            .authorizeHttpRequests(auth -> auth
                .antMatchers(
                    // UserController
                    "/user/login-user",
                    "/user/register-user",
                    "/user/get-user-by-username/**",
                    "/user/get-all-user",
                    "/user/get-all-admin",
                    "/user/get-all-faculty",
                    "/user/delete-user-by-username",
                    "/user/update-user",
                    // SubjectController
                    "/subject/get-all-subjects",
                    "/subject/get-subject-by-id/**",
                    "/subject/add-subject",
                    "/subject/update-subject",
                    "/subject/delete-subject/**",
                    // StudentController
                    "/student/get-all-students",
                    "/student/get-student-by-id/**",
                    "/student/add-student",
                    "/student/update-student",
                    "/student/delete-student/**",
                    // AttendanceController
                    "/attendance/get-all-attendance-records",
                    "/attendance/get-attendance-by-date-subjet/**",
                    "/attendance/take-attendance"
                ).permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
