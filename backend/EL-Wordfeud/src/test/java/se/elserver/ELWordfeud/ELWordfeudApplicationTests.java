package se.elserver.ELWordfeud;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/***
 * Tests for the REST api
 */
@AutoConfigureMockMvc
@SpringBootTest
public class ELWordfeudApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@ParameterizedTest
	@ValueSource(ints = {2345, 3245, 53, 234})
	public void getHelloId(int id) throws Exception {
		String expected = "You have requested hallo with id: " + id;

		mockMvc.perform(MockMvcRequestBuilders.get("/hello/" + id)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(expected));
	}

	@Test
	public void getHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
