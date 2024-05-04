package com.scrabble;

import com.scrabble.entity.Score;
import com.scrabble.model.ScoreModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URL;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScrabbleControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSaveEndpoint() throws Exception {
        ResponseEntity<Score> res = restTemplate.postForEntity(new URL("http://localhost:" + port + "/v1/score").toString(), prepareScodeModel(), Score.class);
        assertEquals(prepareScodeModel().getScore(), res.getBody().getScore());
    }

    @Test
    public void testGetEndpoint() throws Exception {
        ResponseEntity<List> res = restTemplate.getForEntity(new URL("http://localhost:" + port + "/v1/score").toString(), List.class);
        assertEquals(1, res.getBody().size());
    }

    private ScoreModel prepareScodeModel() {
        return ScoreModel.builder()
                .description("description")
                .score(10)
                .playerName("player")
                .build();

    }
}
