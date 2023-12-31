package com.hdsam.springclouddemo.springsecuritydemo.hellosecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * HelloSecurityTest
 *
 * @author Yeo
 * @date 2023/7/7
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloSecurityTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void indexWhenUnAuthenticatedThenRedirect() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser
	void indexWhenAuthenticatedThenOk() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}
}
