package es.iestetuan.acv.objectDBEjer42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.consumirAPIRest();
		
	}
	
	public void consumirAPIRest() {
		
		HttpClient client = HttpClient.newHttpClient();
		URI uri = URI.create("http://localhost:8080/rest/colores");
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			String resultado = response.body();
			String[] resultadoArray = resultado.split(",");
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<resultadoArray.length;i++) {
				sb.append(resultadoArray[i]+"\n");
			}
			
			System.out.println(sb.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
