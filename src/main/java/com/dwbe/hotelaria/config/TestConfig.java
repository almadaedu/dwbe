package com.dwbe.hotelaria.config;

import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.model.User;
import com.dwbe.hotelaria.repositories.BookingRepository;
import com.dwbe.hotelaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run (String... args) throws Exception {
        User user1 = new User(null, "Eduardo", "123456789" ,"90397992025", LocalDate.now(), "(61) 92481-5978", null);
        User user2 = new User(null,"Batata", "987654321","36682902026", LocalDate.now(),"(61) 92431-5978", null);

        Booking booking1 = new Booking(null, Instant.parse("2019-06-20T19:53:07Z"), user1);
        Booking booking2 = new Booking(null, Instant.parse("2019-07-21T03:42:10Z"), user2);
        Booking booking3 = new Booking(null, Instant.parse("2019-07-22T15:21:22Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        bookingRepository.saveAll(Arrays.asList(booking1,booking2,booking3));
    }
}
