package com.demo

class Charge {

    Boolean paid
    Double amount
    String currency
    Boolean refunded
    Date dateCreated

    static belongsTo = [customer: Customer];

    static constraints = {

    }

    Charge() {

    }

    Charge(Double amount, String currency, Boolean paid, Boolean refunded) {
        this.amount = amount;
        this.currency = currency;
        this.paid = paid;
        this.refunded = refunded;
    }
}
