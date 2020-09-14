package com.devops.travelagent;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class SearchPlaceTest {

	search se=new search();
	
	@SuppressWarnings("restriction")
	@Test
	public void searchTest() throws Exception {
		se.setPlace("Delhi");
		assertEquals("Delhi",se.getPlace());
	}

}
