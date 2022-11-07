package com.fabflix.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fabflix.entity.Stars;

@Repository
public interface StarRepository extends JpaRepository<Stars, String> {
	@Query(value = "select * from movies where id in (select movie_id from stars_in_movies where star_id=?)", nativeQuery = true)
	List<Map<String, Object>> findMoviesByStarId(String starId);

	@Query(value = "select max(substring(id, 3)) from stars", nativeQuery = true)
	int findLastId();
}
