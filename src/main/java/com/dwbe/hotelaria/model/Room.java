package com.dwbe.hotelaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name= "room")
public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = 6831506266201148348L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 200, message = "O campo 'Nome' deve conter entre 1 e 200 caracteres")
    private String name;

    @Column(name = "description", nullable = false)
    @Size(min = 1, max = 200, message = "O campo 'Descrição' deve conter entre 1 e 200 caracteres")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image", nullable = false)
    private String imgUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "rooms")
    private List<Booking> bookings = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

}
