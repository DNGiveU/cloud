package com.ngiveu.cloud.admin;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ngiveu.cloud.admin.CloudAdminApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CloudAdminApplication.class)
public class CloudAdminApplicationTest {
	
	@Autowired
	private StringEncryptor stringEncryptor;

	@Test
	public void testEnvironmentProperties() {
		/*
		bX2XRwqx0v3VVWbL00JiXQ==
		1jnIkCKDfnXwIr/55nVgTA==
		J5S99II5EPdXMtxifCge7uVgQe57JY7L
		1cDxeYhvvym4anrLMKuNhA==
		asQ2EMF0Xho7L1+RjTmUiEtCuhDZ5etVNSuC/WsZUOTNoqTMC7GhVPwLbODxZwZinsl9qqKsSE8=
		fo6W40WgqWP4nOy4M4HH8fQBghYM07pt
		9NUr1sMWY1m5ESR7f4jZXJ8jYDiEyh/7hln65UCMhfIywhLIYmFy8OfU16nPTvza
		HHS8JYfY3L0Fl9e8lbYMnLwKG97yIEuj
		TAR6+JeG3rw+fSGeZWCI4YQlzBGWGVvXMcnK08DqFfcd07svC1MfSTTdmY8Kjl66
		 */
		System.out.println(stringEncryptor.encrypt("redis"));
		System.out.println(stringEncryptor.encrypt("pig"));
		System.out.println(stringEncryptor.encrypt("lengleng"));
		System.out.println(stringEncryptor.encrypt("root"));
		System.out.println(stringEncryptor.encrypt("g0HJr2Ltrs0k6tJDY6pDI2aVMUCPSWZDTROLcFMs"));
		System.out.println(stringEncryptor.encrypt("24760324"));
		System.out.println(stringEncryptor.encrypt("175d516debb916d3842d981dd3b76061"));
		System.out.println(stringEncryptor.encrypt("101322838"));
		System.out.println(stringEncryptor.encrypt("fe6ec1ed3fc45e664ce8ddbf78376ab7"));
	
		System.out.println(stringEncryptor.decrypt("Ho5VxMWMMIzfIEE8/WxVzA=="));
		
		String raw = "gaz";
		String encode = this.stringEncryptor.encrypt(raw);
		System.out.println(encode);
		System.out.println(this.stringEncryptor.decrypt(encode));
	}

}
