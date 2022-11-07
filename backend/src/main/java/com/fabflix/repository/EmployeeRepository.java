package com.fabflix.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabflix.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmail(String email);

	@Query(value = " call add_movie(:movieTitle,:movieYear,:movieDirector,:starName,:genreName)", nativeQuery = true)
	String addMovie(@Param("movieTitle") String movieTitle, @Param("movieYear") int movieYear,
			@Param("movieDirector") String movieDirector, @Param("starName") String starName,
			@Param("genreName") String genreName);

	@Query(value = "show tables", nativeQuery = true)
	List<String> describeTables();

	@Query(value = "describe movies", nativeQuery = true)
	List<Map<String, Object>> describeMovies();

	@Query(value = "describe stars", nativeQuery = true)
	List<Map<String, Object>> describeStars();

	@Query(value = "describe stars_in_movies", nativeQuery = true)
	List<Map<String, Object>> describeStarsInMovies();

	@Query(value = "describe genres", nativeQuery = true)
	List<Map<String, Object>> describeGenre();

	@Query(value = "describe genres_in_movies", nativeQuery = true)
	List<Map<String, Object>> describeGenresInMovies();

	@Query(value = "describe customers", nativeQuery = true)
	List<Map<String, Object>> describeCustomers();

	@Query(value = "describe sales", nativeQuery = true)
	List<Map<String, Object>> describeSales();

	@Query(value = "describe creditcards", nativeQuery = true)
	List<Map<String, Object>> describeCreditCards();

	@Query(value = "describe ratings", nativeQuery = true)
	List<Map<String, Object>> describeRatings();

	@Query(value = "describe employees", nativeQuery = true)
	List<Map<String, Object>> describeEmployees();

}
