package ServiTec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration 
@EnableWebSecurity 
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsersDetailsServiceImpl usersDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder() ;
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersDetailsService).passwordEncoder(passwordEncoder());
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Aquí coloco las url que van hacer de dominio publico "/","/auth/**","/public/*.....
		http.authorizeRequests().antMatchers("/","/auth/**","/public/**","/css/**","/js/**","/images/**","/fonts/**").permitAll().anyRequest().authenticated()
		.and() //atraves de este metodo puedo concatenar metodos
			.formLogin()
			.loginPage("/auth/login")
			.defaultSuccessUrl("/private/menuInicio_pag",true)
			.failureUrl("/auth/login?error=true") //aca puedo personalizar los formularios de loguien y luego indico la url que desplegaria este formulario y la pagina que abriria si es correcto  
			.loginProcessingUrl("/auth/login-post")
			.permitAll()
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
}

	


