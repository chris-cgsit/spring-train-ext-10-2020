package at.cgsit.training.restendpoint.rest;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
// @ComponentScan(basePackages="at.cgsit")
// @EnableMongoRepositories(basePackages="at.cgsit.training.persistence.mongo.repository")
@SpringBootTest
@AutoConfigureMockMvc
public class SimpleMongoDbRestControllerMockMvcTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {

    MvcResult mvcResult = this.mockMvc
        .perform(get("/simplerest/chatmessages/1232323232"))
        .andDo(print())
        .andExpect(status()
            .isOk()).andReturn();

    String json = mvcResult.getResponse().getContentAsString();
    ChatMessageMongoDb object = (ChatMessageMongoDb)new ObjectMapper().readValue(json, ChatMessageMongoDb.class);

    assertThat(object).isNotNull();
  }

}
