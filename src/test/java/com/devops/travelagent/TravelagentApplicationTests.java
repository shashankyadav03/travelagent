package com.devops.travelagent;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelagentApplicationTests {

	@Autowired
	public rest rest;
	
	userdb u1=new userdb();
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(rest).isNotNull();
	}
	
	@SuppressWarnings("restriction")
	@Test
	public void userTest() throws Exception {
		u1.setuser("Shashank","pass");
		assertEquals("pass",u1.getuserpassword("Shashank"));
	}
}
