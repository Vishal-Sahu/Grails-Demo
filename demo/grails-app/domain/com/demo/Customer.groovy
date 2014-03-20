package com.demo

class Customer {

    String firstName
    String lastName
    Date dateCreated
    Date lastUpdated

    static hasMany = [charges: Charge];

    Customer() {

    }

    Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static constraints = {

    }

    static transients = ['fullName']

    String getFullName() {
        return this.firstName + " " + this.lastName
    }
}
