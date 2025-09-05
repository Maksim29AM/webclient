package cam.example.app.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DogProxy {

    @Autowired
    WebClient webClient;

    //    https://dog.ceo/api/breed/hound/images/random/3
    public String makeDogRequest(Integer limit) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("dog.ceo")
                        .path("/api/breed/hound/images/random/"+limit)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
