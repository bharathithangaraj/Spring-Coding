package jpacompositekeyonetoone.compositekey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jpacompositekeyonetoone.compositekey.entity.Address;
import jpacompositekeyonetoone.compositekey.entity.AddressKey;
import jpacompositekeyonetoone.compositekey.entity.AddressRepo;
import jpacompositekeyonetoone.compositekey.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompositekeyApplicationTests {

	@Autowired
	AddressRepo addRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCompositeKey() {
		AddressKey addKey = new AddressKey(100l, 100l);
		Address addres = new Address(addKey, "Hyd", "Gachibowli", "india", null);
		Person per = new Person();
		per.setName("dadas");
		per.setSociety("dsada");
		per.setAddress(addres);
		addres.setPerson(per);
		addRepo.save(addres);
	}

}
