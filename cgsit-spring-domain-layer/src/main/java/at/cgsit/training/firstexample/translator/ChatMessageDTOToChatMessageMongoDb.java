package at.cgsit.training.firstexample.translator;


import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ChatMessageDTOToChatMessageMongoDb implements Converter<ChatMessageDTO, ChatMessageMongoDb> {

  @Override
  public ChatMessageMongoDb convert(ChatMessageDTO cmDTO) {
    ChatMessageMongoDb message = new ChatMessageMongoDb();
    if (cmDTO.getId() != null  && !StringUtils.isEmpty(cmDTO.getId())) {
      message.setId(cmDTO.getId());
    }

    message.setRecipient(cmDTO.getRecipient());
    message.setContent(cmDTO.getContent());
    message.setSender(cmDTO.getSender());

    return message;
  }

}
