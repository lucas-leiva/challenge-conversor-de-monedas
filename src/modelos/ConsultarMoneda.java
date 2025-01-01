package modelos;

import java.net.http.HttpClient;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public void enviarConsulta(int opcion) throws IOException, InterruptedException {
        // Pedir el monto al usuario
        System.out.println("Ingrese el valor que desea convertir: ");
        Scanner scanner = new Scanner(System.in);
        double montoUsuario = Double.parseDouble(scanner.nextLine());

        // Configurar la URL y abreviaturas según la opción
        String segundaAbreviatura;
        String abreviatura;
        switch (opcion) {
            case 1:
                abreviatura = "USD";
                segundaAbreviatura = "ARS";
                break;
            case 2:
                abreviatura = "ARS";
                segundaAbreviatura = "USD";
                break;
            case 3:
                abreviatura = "USD";
                segundaAbreviatura = "BRL";
                break;
            case 4:
                abreviatura = "BRL";
                segundaAbreviatura = "USD";
                break;
            case 5:
                abreviatura = "USD";
                segundaAbreviatura = "COP";
                break;
            case 6:
                abreviatura = "COP";
                segundaAbreviatura = "USD";
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // Restablecer la URL base
        String BASE_URL = "https://v6.exchangerate-api.com/v6/fdf7c72852dd4803810b93e0/latest/";
        String direccion = BASE_URL + abreviatura;

        // Configurar Gson
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Crear la solicitud HTTP
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            // Enviar la solicitud y procesar la respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Parsear el JSON
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Mapear las tasas de conversión al record
            MonedaRecord monedaRecord = gson.fromJson(conversionRates, MonedaRecord.class);

            // Acceder al valor dinámico mediante reflexión
            double tasaDeCambio = conversionRates.get(segundaAbreviatura).getAsDouble();

            // Mostrar el resultado
            System.out.println("El valor de " + montoUsuario + " [" + abreviatura + "]" +
                    " corresponde al valor final de: " + (tasaDeCambio * montoUsuario) + " [" + segundaAbreviatura + "]\n");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
