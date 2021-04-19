package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class BookEntity {
    @Id
    private Long id;

    private String name;

    @OneToOne( fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private PeopleEntity people;
}
