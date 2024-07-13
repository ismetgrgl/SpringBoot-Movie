package org.ismetg.movieapp.dto.request;

import jakarta.persistence.Column;

public record MovieCommentSaveRequestDto(@Column(length = 500)
                                         String yorum,
                                         Long userid,
                                         Long movieid
                                         ) {
}
