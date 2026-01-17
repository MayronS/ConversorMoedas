import br.com.desafio.conversorMoedas.api.ExchangeRate;
import br.com.desafio.conversorMoedas.conversor.Conversores;
import br.com.desafio.conversorMoedas.conversor.TiposMoedas;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String opcao;
        Scanner scanner = new Scanner(System.in);
        Conversores conversores = new Conversores();
        ExchangeRate exchangeRate = new ExchangeRate();
        TiposMoedas tiposMoedas = new TiposMoedas();

        HttpClient client = HttpClient.newHttpClient();
        while(true) {
            try {


                System.out.println(
                        """
                                **************************************************************
                                Seja bem vindo/a ao Conversor de Moeda =]
                                                            
                                1) Dólar =>> Peso argentino
                                2) Peso argentino =>> Dólar
                                3) Dólar =>> Real brasileiro
                                4) Real brasileiro =>> Dólar
                                5) Dólar =>> Peso colombiano
                                6) Peso colombiano =>> Dólar
                                7) Sair
                                Escolha uma opção válida:
                                **************************************************************
                                """
                );

                opcao = scanner.nextLine();
                if (opcao.equals("7")){
                    break;
                }

                System.out.println("Digite o valor que deseja converter: ");
                Double valor = Double.parseDouble(scanner.nextLine().replace(",", "."));


                tiposMoedas.moedas(opcao);
                tiposMoedas.tipos(exchangeRate);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(exchangeRate.api()))
                        .GET()
                        .build();


                HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Conversão para JSON
                JsonElement elemento = JsonParser.parseString(resposta.body());
                JsonObject objectRoot = elemento.getAsJsonObject();
                double cotacao = objectRoot.get("conversion_rate").getAsDouble();


                System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>>> %f [%s]\n", valor, exchangeRate.getMoedaIncial(), conversores.ConversorDeValor(cotacao, valor), exchangeRate.getMoedaFinal());



            } catch (NullPointerException e) {
                System.out.println("Digite uma das opçoes válidas!");
            }
            catch (Exception e){
                System.out.println("Ocorre um erro! Tente novamente");
            }
        }
        System.out.println("Obrigado por utilizar nossos serviços!");
    }
}