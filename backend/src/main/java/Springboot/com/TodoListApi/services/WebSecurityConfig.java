//package Springboot.com.TodoListApi.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableGlobalMethodSecurity(
//		// securedEnabled = true,
//		// jsr250Enabled = true,
//		prePostEnabled = true)
//public class WebSecurityConfig {
//
//	@Autowired
//	UserService userService;
//	@Autowired
//	TaskService taskService;
//
//	@Autowired
//	private AuthEntryPointJwt unauthorizedHandler;
//
//	@Bean
//	public AuthTokenFilter authenticationJwtTokenFilter() {
//
//		return new AuthTokenFilter();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//
//		return authProvider;
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//		return authConfig.getAuthenticationManager();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authorizeHttpRequests()
//				.requestMatchers("/api/v1/auth/**").permitAll()
//				.requestMatchers("/api/v1/test/**").permitAll()
//				.requestMatchers(GET, "/api/v1/athlete/**").permitAll()
//				.requestMatchers(GET, "/api/v1/listOfHonors/**").permitAll()
//				.requestMatchers(GET, "/api/v1/news/**").permitAll()
//				.anyRequest().authenticated();
//
//		http.authenticationProvider(authenticationProvider());
//
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//		return http.build();
//	}
//}
