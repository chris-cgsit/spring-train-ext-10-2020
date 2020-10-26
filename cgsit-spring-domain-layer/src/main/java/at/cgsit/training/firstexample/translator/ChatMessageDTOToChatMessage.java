package at.cgsit.training.firstexample.translator;


import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.persistence.jpa.model.ChatMessage;
import at.cgsit.training.persistence.jpa.model.MessageType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ChatMessageDTOToChatMessage implements Converter<ChatMessageDTO, ChatMessage> {

  @Override
  public ChatMessage convert(ChatMessageDTO cmDTO) {
    ChatMessage message = new ChatMessage();
    if (cmDTO.getId() != null  && !StringUtils.isEmpty(cmDTO.getId())) {
      message.setId(Long.valueOf(cmDTO.getId()));
    }

    message.setType( MessageType.valueOf(cmDTO.getType().name()));
    message.setRecipient(cmDTO.getRecipient());
    message.setContent(cmDTO.getContent());
    message.setSender(cmDTO.getSender());

    return message;
  }

}
