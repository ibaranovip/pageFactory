package project.util;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DataGenerator {
    private static final Logger logger = LogManager.getLogger(DataGenerator.class);

    public static Map<String,String> newUser = new HashMap<>();
    public static String generateRandomEmail(int length) {
        //log.info("Generating a Random email String");
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length() - 9) + "@testdata.com";
        return email;
    }


    public static Map<String,String> createUserInfo(){

        Faker faker = new Faker(new Locale("ru-RU"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String address = faker.address().streetAddress();
        String postcode = faker.address().zipCode();
        String city = faker.address().cityName();
        String phone = faker.phoneNumber().cellPhone();
        String region = faker.address().state();
        String email = generateRandomEmail(15);

        newUser.put("firstname",firstName);
        newUser.put("lastname",lastName);
        newUser.put("email",email);
        newUser.put("password", password);
        newUser.put("address", address);
        newUser.put("city", city);
        newUser.put("phone", phone);
        newUser.put("postcode", postcode);
        newUser.put("region", region);

        logger.info(newUser);

        return newUser;
    }

}
