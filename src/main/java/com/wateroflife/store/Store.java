package com.wateroflife.store;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "STORE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tel")
    private String tel;


}
