package com.dwbe.hotelaria.view;

import com.dwbe.hotelaria.controller.BookingService;
import com.dwbe.hotelaria.controller.HotelService;
import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.model.Hotel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Start implements CommandLineRunner {

    private final BookingService service = new BookingService();
    @Override
    public void run(String... args) throws Exception {
        for(int x = 1; x<=5; x++) {
            service.addBooking(new Booking("booking" + x));
        }
        Booking booking = service.searchBooking("booking2");
        booking.setType("Master");
        service.editBooking(booking);

        for(Booking booking1 : service.bookingList()) {
            System.out.println(booking1.getType());
        }
    }
}
