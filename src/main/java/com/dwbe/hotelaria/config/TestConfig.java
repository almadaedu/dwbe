//package com.dwbe.hotelaria.config;
//
//import com.dwbe.hotelaria.model.*;
//import com.dwbe.hotelaria.model.enums.BookingStatus;
//import com.dwbe.hotelaria.repositories.BookingRepository;
//import com.dwbe.hotelaria.repositories.CategoryRepository;
//import com.dwbe.hotelaria.repositories.RoomRepository;
//import com.dwbe.hotelaria.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.time.Instant;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashSet;
//
//@Configuration
//@Profile("test")
//public class TestConfig implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private RoomRepository roomRepository;
//
//    @Override
//    public void run (String... args) throws Exception {
//
//        Room room1 = new Room(null, "Quarto Jardim", "ola", 1250.0, "", new HashSet<>());
//        Room room2 = new Room(null, "Quarto Jardim Secreto", "Este quarto tem acesso direto a um jardim privado, onde você pode relaxar em um oásis verde e tranquilo", 1250.0, "", new HashSet<>());
//        Room room3 = new Room(null, "Quarto Secreto", "banana", 1250.0, "", new HashSet<>());
//
//        Category category1 = new Category(null, "Quarto de solteiros", new HashSet<>());
//        Category category2 = new Category(null, "Quarto de solteiros", new HashSet<>());
//        Category category3 = new Category(null, "Quarto de solteiros", new HashSet<>());
//
//        room1.getCategories().add(category1);
//        room2.getCategories().add(category2);
//        room3.getCategories().add(category3);
//
//        User user1 = new User(null, "Eduardo", "123456789" ,"90397992025", LocalDate.now(), "(61) 92481-5978", null);
//        User user2 = new User(null,"Batata", "987654321","36682902026", LocalDate.now(),"(61) 92431-5978",null);
//
//        Booking booking1 = new Booking(null, Instant.parse("2019-06-20T19:53:07Z"), BookingStatus.AWAITING_PAYMENT_CONFIRMATION.getCode(), user1);
//        Booking booking2 = new Booking(null, Instant.parse("2019-07-21T03:42:10Z"), BookingStatus.PAYMENT_CONFIRMED.getCode() ,user2);
//        Booking booking3 = new Booking(null, Instant.parse("2019-07-22T15:21:22Z"), BookingStatus.CANCELED.getCode() ,user1);
//
//////        Payment payment1 = new Payment(null,  Instant.parse("2019-06-20T21:53:07Z"), booking1);
////        booking1.setPayment(payment1);
////        bookingRepository.save(booking1);
//
//        userRepository.saveAll(Arrays.asList(user1, user2));
//        bookingRepository.saveAll(Arrays.asList(booking1,booking2,booking3));
//        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
//        roomRepository.saveAll(Arrays.asList(room1, room2, room3));
//    }
//}
