package com.proyecto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.proyecto.Controller.UserController;
import com.proyecto.model.UserResponse;
import com.proyecto.service.UserService;

public class UserControllerTest {
	private static final List<StringBuilder>DATA=new ArrayList<StringBuilder>();
	public static final UserResponse USER_RESPONSE=new UserResponse();
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	UserController userController;

	@Before
	public void init() throws Exception{
		MockitoAnnotations.initMocks(this);
		USER_RESPONSE.setData(DATA);
		Mockito.when(userService.getDataUrl()).thenReturn(USER_RESPONSE);
	}
	
	@Test
	public void getDataUrlTest() throws Exception{
		final UserResponse response=userController.getDataUrl();
		assertEquals(response, USER_RESPONSE);
	}
}
