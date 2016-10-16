package org.fischermatte.training.spring.security;

public class SecurityConfig {

}

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/private/private").authenticated()
//                .antMatchers("/api/hello").permitAll()
//                .antMatchers("/index.html").permitAll()
//                .antMatchers("/login.html").permitAll().and()
//            .formLogin()
//                .loginPage("/login").and()
//            .logout()
//                .permitAll().and()
//            .csrf()
//                .disable()
//                /*.httpBasic()*/;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("password1").roles("USER")
//                .and()
//                .withUser("user2").password("password2").roles("USER");
//    }
//
//}