package bank;

import java.security.SecureRandom;

import javax.mail.NoSuchProviderException;

public class CustomerMain {

	public static void main(String[] args) throws NoSuchProviderException {
		Customer cr = new Customer();
		cr.createAc();
	}

}
