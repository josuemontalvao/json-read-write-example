package com.josue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample {
	// Esconde alguns possíveis avisos no console
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Instancia um objeto para fazer o parse ao ler o arquivo
		JSONParser jsonParser = new JSONParser();

		// Tentativa de leitura de arquivo
		try (FileReader reader = new FileReader("employees.json")) {
			// Instancia um objeto para receber o parse do JSONParser previamente declarado
			Object obj = jsonParser.parse(reader);

			// Converte tudo o que foi parseado em uma lista do tipo JSONArray
			JSONArray employeeList = (JSONArray) obj;
			// Imprime o que foi parseado na tela
			System.out.println(employeeList);

			// Para todos os elementos do JSONArray, executa o método declarado abaixo para
			// captura e atribuição de atributos relativos às chaves internas ao JSON
			employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

			// Captura de Exceção caso o arquivo não esteja no diretório
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// Captura de Exceções em geral relacionadas a entrada e saída de arquivos
		} catch (IOException e) {
			e.printStackTrace();
			// Captura de Exceções em caso de falha no processo de parse
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parseEmployeeObject(JSONObject employee) {
		// Método para capturar o objeto de uma chave JSON principal por nome, nesse
		// caso "employee"
		// O que é capturado é armazenado em um JSONObject
		JSONObject employeeObject = (JSONObject) employee.get("employee");

		// Em seguida, para o JSONObject capturado é feita a captura de seus atributos a
		// partir das respectivas chaves
		// Captura e atribuição em String do atributo relativo à chave "firstName"
		String firstName = (String) employeeObject.get("firstName");
		// Impressão no console do que foi atribuído à String "firstName"
		System.out.println(firstName);

		// Captura e atribuição em String do atributo relativo à chave "lastName"
		String lastName = (String) employeeObject.get("lastName");
		// Impressão no console do que foi atribuído à String "lastName"
		System.out.println(lastName);

		// Captura e atribuição em String do atributo relativo à chave "website"
		String website = (String) employeeObject.get("website");
		// Impressão no console do que foi atribuído à String "website"
		System.out.println(website);
	}
}
