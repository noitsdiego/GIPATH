package com.PISPATH.UserAdministrator.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.PISPATH.UserAdministrator.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {

    private static final String MOCKAPI_URL = "https://65b522ec41db5efd28675a9e.mockapi.io/api/v1/user";
    
    @Value("${mockapi.url}") // Agrega la URL de tu MockAPI al archivo application.properties
    private String mockApiUrl;

    private final RestTemplate restTemplate;
    
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




   

    public String ingresarUsuario(UserModel usuario) {
        String url = mockApiUrl + "/User"; // Ajusta la ruta según la API de tu MockAPI

        HttpHeaders headers = new HttpHeaders();
        // Agrega cualquier encabezado necesario, como Content-Type, si es necesario

        HttpEntity<UserModel> requestEntity = new HttpEntity<>(usuario, headers);

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "profilePage";
        } else {
            return "registerIncorrect";
        }
    }

    
    
    public UserModel obtenerUsuario(String email, String clave) {
        String apiUrl = mockApiUrl + "/User?email=" + email;
        
        
        try {
        	 ResponseEntity<UserModel[]> responseEntity = restTemplate.getForEntity(apiUrl, UserModel[].class);

             if (responseEntity.getStatusCode() == HttpStatus.OK) {
                 UserModel[] users = responseEntity.getBody();

                 if (users != null && users.length > 0) {
                     
                 	if(users[0].getPassword().equals(clave)) {
                 		return users[0];
                 	}
                 }
             }
             
		} catch (Exception e) {
			// TODO: handle exception
		}
        
       
        return null;
    }
    
    
}
