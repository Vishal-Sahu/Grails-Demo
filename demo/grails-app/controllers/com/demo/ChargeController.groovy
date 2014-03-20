package com.demo

import com.demo.Charge

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ChargeController {

    static scaffold = true

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def summary() {
        List<Charge> successChargesList = Charge.findAllByPaid(true);
        List<Charge> failedChargesList = Charge.findAllByPaid(false);
        List<Charge> refundedChargesList = Charge.findAllByRefunded(true);
        render(view: "summary", model: [successChargesList: successChargesList, failedChargesList: failedChargesList, refundedChargesList: refundedChargesList]);
    }
}
