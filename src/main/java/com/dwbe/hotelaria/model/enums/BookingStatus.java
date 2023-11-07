package com.dwbe.hotelaria.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BookingStatus {

    AWAITING_PAYMENT_CONFIRMATION(1),
    PAYMENT_CONFIRMED(2),
    CANCELED(3);

    private int code;

    public static BookingStatus valueOf(int code) {
        for (BookingStatus value: BookingStatus.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid BookingStatus code");
    }
}
