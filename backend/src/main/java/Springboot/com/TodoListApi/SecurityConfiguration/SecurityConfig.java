//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.csrf().disable() // Disable CSRF for simplicity
//				.authorizeRequests()
//				.antMatchers(HttpMethod.POST, "/api/users/register").permitAll() // Allow registration
//				.antMatchers(HttpMethod.POST, "/api/users/login").permitAll()    // Allow login
//				.anyRequest().authenticated() // Require authentication for other requests
//				.and()
//				.httpBasic(); // Use basic authentication
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(); // Use BCrypt for password hashing
//	}
//}
