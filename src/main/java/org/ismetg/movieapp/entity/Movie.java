package org.ismetg.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblmovie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String language;
    String image;
    String name;
    String country;
    Double rating;
    @Column(length = 10000)
    String summary;
    LocalDate premired;
    String url;
    @ManyToMany(mappedBy = "favmovie")
    List<User> users;
    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(name = "tblmovie_genre",
            joinColumns = @JoinColumn(name = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "genreid")
    )
    List<Genre> genres;
    @OneToMany(mappedBy ="movie")
    private List<MovieComment> comments;



}
