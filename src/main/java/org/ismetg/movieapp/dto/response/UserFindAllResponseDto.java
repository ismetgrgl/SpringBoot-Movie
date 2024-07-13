package org.ismetg.movieapp.dto.response;

import jakarta.persistence.Column;

public record UserFindAllResponseDto(@Column(length = 50)
                                     String name,
                                     @Column(length = 50)
                                     String surname,
                                     @Column(length = 50)
                                     String email,
                                     @Column(length = 15)
                                     String phone) {
}
