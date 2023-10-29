package com.iotconnect.miband;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MibandbackendApplicationTests {

	@Test
	void contextLoads() {
		Long l1 = 127L;
		Long l2 = 127L;

		assertThat(l1 == l2).isTrue();
	}
	
	@Test
	void contextLoads2() {
		Long l1 = 128L;
		Long l2 = 128L;

		assertThat(l1.equals(l2)).isTrue();
	}
	

}
