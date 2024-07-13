package org.ismetg.movieapp.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import org.ismetg.movieapp.entity.User;

import java.time.LocalDate;
@Builder
public record MovieCommentFindAllResponseDto(@Column(length = 500)
                                             String yorum,
                                             LocalDate yorumtarihi,
                                             Long movieid,
                                             Long userid
                                             ) {
}
