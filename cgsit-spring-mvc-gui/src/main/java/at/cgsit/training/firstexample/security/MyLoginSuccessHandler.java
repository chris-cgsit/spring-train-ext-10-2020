package at.cgsit.training.firstexample.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {

  Logger logger = LoggerFactory.getLogger(MyLoginSuccessHandler.class);

  public MyLoginSuccessHandler() {
    super();
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,
      ServletException {
    logger.info("LOGIN SUCCESS for User " + (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
  }
}
