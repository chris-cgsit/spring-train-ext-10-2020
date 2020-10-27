package at.cgsit.training.firstexample.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/simpleoauth")
public class SimpleOAuthRestController {

  Logger logger = LoggerFactory.getLogger(SimpleOAuthRestController.class);

  @PostConstruct
  public void init() {
    // do nothing
  }

  @GetMapping("/user")
  public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
    return Collections.singletonMap("name", principal.getAttribute("name"));
  }

  @GetMapping("/echo/{property}")
  String getProperty(@PathVariable String property) {
    logger.info("getProperty /properties called with value {}", property);
    return "success " + property;
  }

}
