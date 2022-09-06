package utils;

import com.github.javafaker.Faker;

public class FakeMessageGenerator {

    public static String generateAccountName() {
        return new Faker().company().name();
    }

    public static String generatePhone() {
        return new Faker().phoneNumber().phoneNumber();
    }

    public static String generateDescription() {
        return new Faker().harryPotter().quote();
    }

    public static String generateWebsite() {
        return new Faker().internet().url();
    }

    public static String generateAddress() {
        return new Faker().address().fullAddress();
    }

    public static String generateName() {
        return new Faker().name().name();
    }

    public static String generateCity() {
        return new Faker().address().city();
    }

    public static String generateState() {
        return new Faker().address().state();
    }

    public static String generateZip() {
        return new Faker().address().zipCode();
    }

    public static String generateCountry() {
        return new Faker().address().country();
    }
}