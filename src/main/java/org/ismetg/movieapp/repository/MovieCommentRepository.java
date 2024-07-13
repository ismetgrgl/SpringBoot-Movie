package org.ismetg.movieapp.repository;

import org.ismetg.movieapp.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCommentRepository extends JpaRepository<MovieComment , Long> {
}
