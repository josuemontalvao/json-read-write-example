package com.josue;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSONExample {
	// Esconde alguns possíveis avisos no console
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Instancia de um primeiro JSONObject auxiliar
		JSONObject employeeDetails = new JSONObject();
		// Método put para inserir atributos e valores no JSONObject
		employeeDetails.put("firstName", "Lokesh");
		// Mais uma inserção de atributos e valores
		employeeDetails.put("lastName", "Gupta");
		// Última uma inserção de atributos e valores para o objeto employeeDetails
		employeeDetails.put("website", "howtodoinjava.com");

		// Um outro objeto (principal) para englobar o objeto que contém todos os atributos
		JSONObject employeeObject = new JSONObject();
		// Inserção de employeeDetails em employeeObject
		employeeObject.put("employee", employeeDetails);

		// Repete-se tudo o que foi feito para um segundo JSONObject auxiliar
		// Instancia de JSONObject
		JSONObject employeeDetails2 = new JSONObject();
		// Inserção de atributo e valor
		employeeDetails2.put("firstName", "Brian");
		// Inserção de atributo e valor
		employeeDetails2.put("lastName", "Schultz");
		// Inserção de atributo e valor
		employeeDetails2.put("website", "example.com");

		// Instância de um segundo JSONObject principal
		JSONObject employeeObject2 = new JSONObject();
		// Inserção do segundo objeto auxiliar dentro do principal
		employeeObject2.put("employee", employeeDetails2);

		// Criação de um JSONArray para guardar todos os JSONObjects principais
		JSONArray employeeList = new JSONArray();
		// Insere o primeiro JSONObject no array
		employeeList.add(employeeObject);
		// Insere o segundo JSONObject no array
		employeeList.add(employeeObject2);

		// Tentativa de se escrever o arquivo JSON com o nome escolhido
		try (FileWriter file = new FileWriter("employees.json")) {
			// Escreve o Array no arquivo através do método toJSONString()
			// Poderia ter sido um JSONObject no lugar de JSONArray
			file.write(employeeList.toJSONString());
			// Limpa o fluxo de dados
			file.flush();
		// Captura de exceção
		} catch (IOException e) {
			// Imprime na tela o erro
			e.printStackTrace();
		}
	}
}