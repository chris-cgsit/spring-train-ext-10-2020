package at.cgsit.training.firstexample.translator;

import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ChatMessageToChatMessageDTO implements Converter<ChatMessage, ChatMessageDTO> {

  @Override
  public ChatMessageDTO convert(ChatMessage cmInput) {
    ChatMessageDTO message = new ChatMessageDTO();
    if (cmInput.getId() != null  && !StringUtils.isEmpty(cmInput.getId())) {
      message.setId(Long.valueOf(cmInput.getId()));
    }
    message.setType( ChatMessageDTO.MessageType.valueOf(cmInput.getType().name()));
    message.setRecipient(cmInput.getRecipient());
    message.setContent(cmInput.getContent());
    message.setSender(cmInput.getSender());

    return message;
  }
}
