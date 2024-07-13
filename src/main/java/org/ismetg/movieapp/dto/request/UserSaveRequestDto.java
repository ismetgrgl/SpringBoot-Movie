package org.ismetg.movieapp.dto.request;

import jakarta.persistence.Column;

public record UserSaveRequestDto(@Column(length = 50)
                                 String name,
                                 @Column(length = 50)
                                 String surname,
                                 @Column(length = 50)
                                 String email,
                                 @Column(length = 15)
                                 String phone,
                                 @Column(length = 32)
                                 String password,
                                 String rePassword
)


{
}
