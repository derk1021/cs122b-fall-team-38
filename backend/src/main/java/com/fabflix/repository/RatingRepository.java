package com.fabflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabflix.entity.Ratings;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, String> {

}
