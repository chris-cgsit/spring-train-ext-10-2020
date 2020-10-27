package at.cgsit.training.firstexample.restsecurity;

import at.cgsit.training.firstexample.config.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

  Logger logger = LoggerFactory.getLogger(CustomBasicAuthenticationEntryPoint.class);

  @Override
  public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException)
          throws IOException {

    logger.error("AuthenticationException", authException);

    //Authentication failed, send error response.
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

    PrintWriter writer = response.getWriter();
    writer.println("HTTP Status 401 : " + authException.getMessage());
  }

  @Override
  public void afterPropertiesSet() {
    setRealmName(WebSecurityConfig.REST_REALM);
    super.afterPropertiesSet();
  }
}
