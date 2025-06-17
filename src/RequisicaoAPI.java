import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoAPI {

    public RespostaAPI pegarRespostaAPI(String moedaBase) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient(); // Client
        HttpRequest request = HttpRequest.newBuilder() // Request
                .uri(URI.create("https://v6.exchangerate-api.com/v6/e74d288de4e8f50b25ceb22f/latest/" + moedaBase))
                .build();
        //response
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString()); //Response
        Gson gson = new Gson();
        return gson.fromJson(response.body(), RespostaAPI.class);
    }
}
