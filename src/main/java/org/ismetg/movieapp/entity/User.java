package org.ismetg.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String surname;
    @Column(length = 50)
    String email;
    @Column(length = 15)
    String phone;
    @Column(length = 32)
    String password;
    @ManyToMany()
    @JoinTable(name = "tbluser_movie",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "movieid")
    )
    List<Movie> favmovie;
    @ManyToMany()
    @JoinTable(name = "tbluser_genre",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "genreid")
    )
    List<Genre> favgenre;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<MovieComment> comments;

}
