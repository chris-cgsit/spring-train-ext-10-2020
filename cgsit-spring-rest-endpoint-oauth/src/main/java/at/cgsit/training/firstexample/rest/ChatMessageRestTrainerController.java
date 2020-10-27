package at.cgsit.training.firstexample.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/simpleoauth")
@RolesAllowed({"ROLE_READ"})
public class ChatMessageRestTrainerController {

  Logger logger = LoggerFactory.getLogger(ChatMessageRestTrainerController.class);

  @PostConstruct
  public void init() {
    // do nothing
  }

  @GetMapping("/echo/{property}")
  String getProperty(@PathVariable String property) {
    logger.info("getProperty /properties called with value {}", property);
    return "success " + property;
  }

}
