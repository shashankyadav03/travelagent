package com.devops.travelagent;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class signupTest {

	userdb u1=new userdb();
	
	@SuppressWarnings("restriction")
	@Test
	public void userTest() throws Exception {
		u1.setuser("Vivek","pass");
		assertEquals("pass",u1.getuserpassword("Vivek"));
	}

}
