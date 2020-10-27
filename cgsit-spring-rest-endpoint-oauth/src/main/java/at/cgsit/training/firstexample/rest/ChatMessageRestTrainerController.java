package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.exceptions.ChatMessageNotFoundException;
import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.translator.ChatMessageToChatMessageDTO;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.repository.ChatMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/trainerrest")
// @Secured({"ROLE_READ"})
@RolesAllowed({"ROLE_READ"})
public class ChatMessageRestTrainerController {
  Logger logger = LoggerFactory.getLogger(ChatMessageRestTrainerController.class);

  private ChatMessageService chatMessageService;

  private ChatMessageToChatMessageDTO cmToCMDTO;

  private ChatMessageRepository repository;

  @Autowired
  public void setRepository(ChatMessageRepository repository) {
    this.repository = repository;
  }

  @Autowired
  public void setCmToCMDTO(ChatMessageToChatMessageDTO cmToCMDTO) {
    this.cmToCMDTO = cmToCMDTO;
  }

  @Autowired
  public void setChatMessageService(ChatMessageService chatMessageService) {
    this.chatMessageService = chatMessageService;
  }

  @GetMapping(value = "/restlogout")
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    logger.info("log-out");

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    SecurityContextHolder.getContext().setAuthentication(null);
  }


  @GetMapping(value = "/chatmessages")
  public List<ChatMessage> all() {
    return chatMessageService.listAll();
  }

  @GetMapping( value = "/chatmessages/findBySender/{sender}")
  @Secured({"ROLE_POWER_USER"})
  // @RolesAllowed({"ROLE_POWER_USER"})
  public List<ChatMessage> findBySender(@PathVariable String sender) {
    return chatMessageService.findBySender(sender);
  }

  @PostMapping(value = "/chatmessages")
  public ChatMessage createChatMassage(@RequestBody ChatMessage chatMessage) {
    return repository.save(chatMessage);
  }


  @GetMapping("/chatmessages/{id}")
  ChatMessage findById(@PathVariable Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ChatMessageNotFoundException(id));
  }

  @GetMapping("/chatmessages/byRequestParam")
  ChatMessage findByRPid(@RequestParam("id") Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ChatMessageNotFoundException(id));
  }


  @PutMapping("/chatmessages/{id}")
  ChatMessage replaceEmployee(@RequestBody ChatMessage chatMessage, @PathVariable Long id) {

    return repository.findById(id)
        .map(foundCM -> {
          foundCM.setSender(chatMessage.getSender());
          foundCM.setContent(chatMessage.getContent());
          foundCM.setRecipient(chatMessage.getRecipient());
          return repository.save(foundCM);
        })
        .orElseGet(() -> {
          chatMessage.setId(id);
          return repository.save(chatMessage);
        });
  }

  @DeleteMapping("/chatmessagess/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
