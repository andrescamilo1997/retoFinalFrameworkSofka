package com.automationpractice.test.helpers;

import com.automationpractice.test.model.Customer;
import co.com.sofka.test.evidence.reports.Report;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import static com.automationpractice.test.helpers.Dictionary.*;


public class Helper {

    private Helper() {
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();

        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure(ERROR_TO_CONSULT_PROPERTY
                    + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static Customer generateCustomer(String language, String country, String emailDomain){

        Faker faker =  Faker.instance(
                new Locale(language, country),
                new Random()
        );

        Customer customer = new Customer();
        customer.setEmail(
                faker.name()
                        .username()
                        .concat(emailDomain)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );

        customer.setFirstName   (faker.name     ().firstName());
        customer.setLastName    (faker.name     ().lastName());
        customer.setPassword    (faker.number   ().digits(DIGITS_PASSWORD));
        customer.setDayBirth    (String.valueOf (faker.number().numberBetween(MIN_DAY, MAX_DAY)));
        customer.setMonthBirth  (String.valueOf (faker.number().numberBetween(MIN_MONTH, MAX_MONTH)));
        customer.setYearBirth   (String.valueOf (faker.number().numberBetween(MIN_YEAR, MAX_YEAR)));

        customer.setAddress     (faker.address  ().fullAddress  ());
        customer.setCity        (faker.address  ().city         ());
        customer.setPostalCode  (faker.address  ().zipCode      ());
        customer.setMobilePhone (
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(MIN_PHONE_NUMBER, MAX_PHONE_NUMBER))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(MIN_NUMBER, MAX_NUMBER)
                                )
                        )
        );


        customer.setHeading     (
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(
                                        SELECT_HEADING_OPTION1,
                                        SELECT_HEADING_OPTION2)
                )
        );

        customer.setMessage     (MSG_TO_SEND);
        customer.setState       (STATE_BY_DEFAULT_FLORIDA);
        customer.setSize        (SIZE_S);
        customer.setSize        (SIZE_L);

        return customer;
    }

}
