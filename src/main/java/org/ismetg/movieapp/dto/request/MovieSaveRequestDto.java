package org.ismetg.movieapp.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.List;

public record MovieSaveRequestDto(String Language,
                                  String image,
                                  String name,
                                  String country,
                                  Double rating,
                                  @Column(length = 10000)
                                  String summary,
                                  LocalDate premired,
                                  String url,
                                  List<GenreSaveRequestDto> genres) {
}
