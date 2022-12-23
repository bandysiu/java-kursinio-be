package com.parcel.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Test")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_ID", nullable = false)
    private Long id;

    @Column(name = "TEXT", nullable = false)
    private String text;

    @Column(name = "NUMBER", nullable = false)
    private Long number;
}
