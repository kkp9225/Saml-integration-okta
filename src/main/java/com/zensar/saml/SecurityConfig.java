package com.zensar.saml;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Autowired private RelyingPartyRegistrationRepository
	 * relyingPartyRegistrationRepository;
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    	.authorizeRequests(authorize -> 
	    		authorize.antMatchers("/").permitAll().anyRequest().authenticated()
	        ).saml2Login();

		// add auto-generation of ServiceProvider Metadata
		/*
		 * Converter<HttpServletRequest, RelyingPartyRegistration>
		 * relyingPartyRegistrationResolver = new
		 * DefaultRelyingPartyRegistrationResolver(relyingPartyRegistrationRepository);
		 * Saml2MetadataFilter filter = new
		 * Saml2MetadataFilter(relyingPartyRegistrationResolver, new
		 * OpenSamlMetadataResolver()); http.addFilterBefore(filter,
		 * Saml2WebSsoAuthenticationFilter.class);
		 */
	}
	
	/*
	 * @Bean protected RelyingPartyRegistrationRepository
	 * relyingPartyRegistrations() throws Exception { ClassLoader classLoader =
	 * getClass().getClassLoader(); File verificationKey = new
	 * File(classLoader.getResource("saml-certificate/okta.cert").getFile());
	 * X509Certificate certificate = X509Support.decodeCertificate(verificationKey);
	 * Saml2X509Credential credential =
	 * Saml2X509Credential.verification(certificate); RelyingPartyRegistration
	 * registration = RelyingPartyRegistration .withRegistrationId("okta-saml")
	 * .assertingPartyDetails(party -> party
	 * .entityId("http://www.okta.com/exk9vpmiun382TGKS5d7")
	 * .singleSignOnServiceLocation(
	 * "https://dev-12413790.okta.com/app/dev-12413790_springbootsamllogin_1/exk9vpmiun382TGKS5d7/sso/saml")
	 * .wantAuthnRequestsSigned(false) .verificationX509Credentials(c ->
	 * c.add(credential)) ).build(); return new
	 * InMemoryRelyingPartyRegistrationRepository(registration); }
	 */
	
}