package at.cgsit.training.firstexample.controllers;

import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.requestsope.GlobalCounter;
import at.cgsit.training.firstexample.requestsope.RandomMessageGenerator;
import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.translator.ChatMessageToChatMessageDTO;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Chat Message MVC Controller
 */
@Controller
public class ChatMessageController {

  private ChatMessageService chatMessageService;

  private ChatMessageToChatMessageDTO cmToCMDTO;

  @Autowired
  private RandomMessageGenerator generator;

  @Autowired
  private GlobalCounter globalCounter;


  @Autowired
  public void setCmToCMDTO(ChatMessageToChatMessageDTO cmToCMDTO) {
    this.cmToCMDTO = cmToCMDTO;
  }

  @Autowired
  public void setChatMessageService(ChatMessageService chatMessageService) {
    this.chatMessageService = chatMessageService;
  }

  // Login form
  @RequestMapping( {"/login.html", "/login"})
  public String login() {
    return "login.html";
  }

  // Login form with error
  @RequestMapping("/login-error.html")
  public String loginError(Model model) {
    model.addAttribute("loginError", true);
    return "login.html";
  }


  @RequestMapping("/")
  public String redirToList(){
    return "redirect:/chatmessage/list";
  }

  @RequestMapping({"/chatmessage/list", "/chatmessage"})
  public String listChatMessages(Model model){

    String message = generator.getMessage();
    globalCounter.getCounter();

    model.addAttribute("chatmessagelist", chatMessageService.listAll());
    return "chatmessage/list";
  }

  @RequestMapping("/chatmessage/show/{id}")
  public String getChatMessage(@PathVariable String id, Model model){

    ChatMessage byId = chatMessageService.getById(Long.valueOf(id));

    model.addAttribute("chatmessage", byId);

    return "chatmessage/show";
  }

  @RequestMapping("chatmessage/edit/{id}")
  public String editChatmessage(@PathVariable String id, Model model){
    ChatMessage product = chatMessageService.getById(Long.valueOf(id));
    ChatMessageDTO chatMessageDTO = cmToCMDTO.convert(product);

    model.addAttribute("chatMessageform", chatMessageDTO);

    String message = generator.getMessage();
    globalCounter.getCounter();
    model.addAttribute("genCountValue", generator.getCounter());

    return "chatmessage/chatmessageform";
  }

  @RequestMapping("/chatmessage/new")
  public String newChatMessage(Model model){
    model.addAttribute("chatMessageform", new ChatMessageDTO());
    return "chatmessage/chatmessageform";
  }

  @RequestMapping(value = "/chatmessage", method = RequestMethod.POST)
  public String saveOrUpdateChatMessage(@Valid @ModelAttribute("chatMessageform") ChatMessageDTO chatMessageDTO,
      BindingResult bindingResult,  Model model ){

    if(bindingResult.hasErrors()){
      return "chatmessage/chatmessageform";
    }
    String message = generator.getMessage();
    globalCounter.getCounter();
    model.addAttribute("genCountValue", generator.getCounter());

    ChatMessage savedProduct = chatMessageService.saveOrUpdateChatMessageDTO(chatMessageDTO);
    return "redirect:/chatmessage/show/" + savedProduct.getId();
  }

  @RequestMapping("/chatmessage/delete/{id}")
  public String delete(@PathVariable String id){
    chatMessageService.delete(Long.valueOf(id));
    return "redirect:/chatmessage/list";
  }
}
