package com.fanap.hotel.dto.payment;

import com.fanap.hotel.model.PaymentMethod;

public class CreatePaymentRequestDTO {

    private PaymentMethod paymentMethod;

    public CreatePaymentRequestDTO() {

    }

    public CreatePaymentRequestDTO(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
