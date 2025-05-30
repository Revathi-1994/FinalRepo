package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	Faker faker=new Faker();
	public String createRandomUsername()
	{
		return faker.name().username();
	}
	public String createRandomPassword()
	{
		return faker.internet().password();
	}
	public String createRandomName()
	{
	return faker.name().firstName();	
	}
	public String createRandomEmail()
	{
		return faker.internet().emailAddress();
	}
	public String createRandomContactNumber()
	{
		return faker.phoneNumber().phoneNumber();
	}
}
