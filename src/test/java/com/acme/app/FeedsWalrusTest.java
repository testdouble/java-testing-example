package com.acme.app;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.app.values.CannedWalrusFood;
import com.acme.app.values.Walrus;
import com.acme.app.values.WalrusFood;

@RunWith(MockitoJUnitRunner.class)
public class FeedsWalrusTest {

	@InjectMocks
	FeedsWalrus subject;
	
	@Mock
	OpensCan opensCan;

	@Test
	public void test() {
		Walrus gary = new Walrus();
		CannedWalrusFood can = new CannedWalrusFood();
		WalrusFood food = new WalrusFood();
		when(opensCan.open(can)).thenReturn(food);
		
		subject.feed(gary, can);
		
		assertThat(gary.hasEaten(food), is(true));
	}
}