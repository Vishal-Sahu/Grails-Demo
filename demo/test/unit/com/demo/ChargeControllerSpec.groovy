package com.demo

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification


@TestFor(ChargeController)
@Mock([Charge, Customer])
class ChargeControllerSpec extends Specification {

    def "Summary Action : Verify that there are three lists on the screen."() {

        given:
        createInitialData()

        when:
        controller.summary()

        then:
        model.successChargesList.size() != 0
        model.failedChargesList.size() != 0
        model.refundedChargesList.size() != 0
    }


    def "Summary Action : Verify that in the Successful charges list there are 10 line items. Verify that in the failed charges list there are 5 failed charges."() {

        given:
        createInitialData()

        when:
        controller.summary()

        then:
        model.successChargesList.size() == 10
        model.failedChargesList.size() == 5
    }


    public static createInitialData() {

        Customer customer1 = new Customer("John", "Flow").save(flush: true)
        Customer customer2 = new Customer("Raj", "Jamnis").save(flush: true)
        Customer customer3 = new Customer("Andrew", "Chung").save(flush: true)
        Customer customer4 = new Customer("Mike", "Smith").save(flush: true)

        createSuccessfulAndRefundedCharges(customer1, customer2, customer3, customer4)
        createFailedCharge(customer3, customer4)
    }

    public
    static createSuccessfulAndRefundedCharges(Customer customer1, Customer customer2, Customer customer3, Customer customer4) {

//        **************************** First Customer Charge ******************************
        Charge charges1 = new Charge(2000, "GBP", true, false)
        Charge charges2 = new Charge(3000, "GBP", true, true)
        Charge charges3 = new Charge(4000, "GBP", true, true)
        Charge charges4 = new Charge(5000, "GBP", true, true)
        Charge charges5 = new Charge(6000, "GBP", true, true)

        customer1.addToCharges(charges1);
        charges1.customer = customer1

        customer1.addToCharges(charges2);
        charges2.customer = customer1;

        customer1.addToCharges(charges3);
        charges3.customer = customer1;

        customer1.addToCharges(charges4);
        charges4.customer = customer1;

        customer1.addToCharges(charges5);
        charges5.customer = customer1;

        customer1.save(flush: true)

//        **************************** Second Customer Charge ******************************
        Charge charges6 = new Charge(7000, "GBP", true, false)
        Charge charges7 = new Charge(8000, "GBP", true, true)
        Charge charges8 = new Charge(9000, "GBP", true, true)

        customer2.addToCharges(charges6);
        charges6.customer = customer2;

        customer2.addToCharges(charges7);
        charges7.customer = customer2;

        customer2.addToCharges(charges8);
        charges8.customer = customer2;

        customer2.save(flush: true)

//        **************************** Third Customer Charge ******************************
        Charge charges9 = new Charge(10000, "GBP", true, false)
        customer3.addToCharges(charges9);
        charges9.customer = customer3;
        customer3.save(flush: true)

//        **************************** Fourth Customer Charge ******************************
        Charge charges10 = new Charge(100, "GBP", true, false)
        customer4.addToCharges(charges10);
        charges10.customer = customer4;
        customer4.save(flush: true)
    }


    public static createFailedCharge(Customer customer3, Customer customer4) {
//        **************************** Third Customer Charge ******************************
        Charge charges11 = new Charge(200, "GBP", false, false);
        Charge charges12 = new Charge(300, "GBP", false, false);
        Charge charges13 = new Charge(400, "GBP", false, false);

        customer3.addToCharges(charges11);
        charges11.customer = customer3

        customer3.addToCharges(charges12);
        charges12.customer = customer3;

        customer3.addToCharges(charges13);
        charges13.customer = customer3;

        customer3.save(flush: true)

        //        **************************** Fourth Customer Charge ******************************
        Charge charges14 = new Charge(500, "GBP", false, false);
        Charge charges15 = new Charge(600, "GBP", false, false);

        customer4.addToCharges(charges14);
        charges14.customer = customer4;

        customer4.addToCharges(charges15);
        charges15.customer = customer4;

        customer4.save(flush: true)
    }
}