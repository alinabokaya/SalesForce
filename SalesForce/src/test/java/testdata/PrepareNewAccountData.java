package testdata;

import models.NewAccountModel;
import utils.FakeMessageGenerator;

public class PrepareNewAccountData {

    public static NewAccountModel getValidData() {
        return NewAccountModel
                .builder()
                .accountName(FakeMessageGenerator.generateAccountName())
                .phone(FakeMessageGenerator.generatePhone())
                .type("Analyst")
                .description(FakeMessageGenerator.generateDescription())
                .billingStreet(FakeMessageGenerator.generateAddress())
                .shippingStreet(FakeMessageGenerator.generateAddress())
                .website(FakeMessageGenerator.generateWebsite())
                .employees(FakeMessageGenerator.generateName())
                .industry("Agriculture")
                .billingCity(FakeMessageGenerator.generateCity())
                .billingState(FakeMessageGenerator.generateState())
                .shippingCity(FakeMessageGenerator.generateCity())
                .shippingState(FakeMessageGenerator.generateState())
                .billingZip(FakeMessageGenerator.generateZip())
                .shippingZip(FakeMessageGenerator.generateZip())
                .billingCountry(FakeMessageGenerator.generateCountry())
                .shippingCountry(FakeMessageGenerator.generateCountry())
                .build();
    }
}
