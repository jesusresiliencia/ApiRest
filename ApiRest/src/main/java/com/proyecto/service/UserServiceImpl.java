package com.proyecto.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.model.PaginationRequest;
import com.proyecto.model.UserRequest;
import com.proyecto.model.UserResponse;

@Service
public class UserServiceImpl implements UserService{

	@Value("${URL}")
	private String URL;

	@Autowired
    RestTemplate restTemplate;
	
	@Override
	public UserResponse getDataUrl() {
		ResponseEntity<PaginationRequest> response =
                restTemplate.getForEntity(
                this.URL,
                PaginationRequest.class);
		PaginationRequest paginationRequest = response.getBody();
		/*convirtiendo al nuevo formato trama*/
		ArrayList<StringBuilder>usersTrama=new ArrayList<>();
		UserResponse userResponse=new UserResponse();
		for(UserRequest user:paginationRequest.getData()) {
			StringBuilder tramaUser = new StringBuilder().append(
					user.getId()).append("|").append(
				    user.getLast_name()).append("|").append(
				    user.getEmail());
			usersTrama.add(tramaUser);
		}
		userResponse.setData(usersTrama);
      return  userResponse;
	}
	

}
