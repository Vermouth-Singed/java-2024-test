package com.example.sample;

import idp.solution.idptest.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class Java2024TestApplicationTests {

	private static Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

	@Test
	@DisplayName("비밀번호 암호화")
	void 비밀번호_암호화() {
		String password = "123";
		String newPassword = StringUtil.passwordEncoder(password);

		LOGGER.info("password : [{}] changed to newPassword : [{}]", password, newPassword);

		assertNotEquals(password, newPassword);
	}
}
