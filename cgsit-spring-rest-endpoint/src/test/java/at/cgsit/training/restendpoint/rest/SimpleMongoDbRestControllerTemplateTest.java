package at.cgsit.training.restendpoint.rest;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.restendpoint.logging.LoggingRequestInterceptor;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleMongoDbRestControllerTemplateTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String basePath;

  @BeforeEach
  public void initbasePath() {
    this.basePath = "http://localhost:" + port + "/simplerest";

    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new LoggingRequestInterceptor());

    // restTemplate.getRestTemplate().setInterceptors(interceptors);

    restTemplate.getRestTemplate().getInterceptors().add(new LoggingRequestInterceptor());

    restTemplate.getRestTemplate()
        .setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

  }

  @Test
  public void getOneChatMessage() throws Exception {

    String urlGETList = basePath + "/chatmessages/1232323232";

    ResponseEntity<ChatMessageMongoDb> responseEntity = restTemplate.getForEntity(urlGETList, ChatMessageMongoDb.class);
    ChatMessageMongoDb objects = responseEntity.getBody();
    MediaType contentType = responseEntity.getHeaders().getContentType();
    HttpStatus statusCode = responseEntity.getStatusCode();

    assertThat(statusCode).isEqualTo(HttpStatus.OK);

    assertThat(objects).isNotNull();

  }

    //@Disabled("Disabled until problems are solved!")
    @Test
    public void getAllChatMessages() throws Exception {

      String urlGETList = basePath +"/chatmessages";

      ResponseEntity<ChatMessageMongoDb[]> responseEntity = restTemplate.getForEntity(urlGETList, ChatMessageMongoDb[].class);
      Object[] objects = responseEntity.getBody();
      MediaType contentType = responseEntity.getHeaders().getContentType();
      HttpStatus statusCode = responseEntity.getStatusCode();

      assertThat(statusCode).isEqualTo(HttpStatus.OK);

      assertThat(objects).isNotEmpty();
    }

}

