package com.unimoni.blog.springboot.jpa.repo;

import com.unimoni.blog.springboot.jpa.domain.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ArtistRepo extends JpaRepository<Artist, Long>, QuerydslPredicateExecutor<Artist> {

  // this perform two queries
  // 1. select query to return the requested page
  // 2. count query to know total number of elements and pages available
  Page<Artist> findByNameAndRankingUserRatings(String name, int ratings , Pageable pageable);

  // 1. select query to return the requested page
  // knows about whether a next Slice is available. Good for retrieving large results
  Slice<Artist> findByName(String name, Pageable pageable);

  List<Artist> findByNameAndRecordingsTitle(String name, String title, Sort sort);

  List<Artist> findByNameAndRankingGreaterThan(String name, int minRating, Pageable pageable);

  /**
   * @NamedEntityGraph
   *
   * EntityGraph entityGraph = entityManager.getEntityGraph("artist-recording");
   * Map<String, Object> properties = new HashMap<>();
   * properties.put("javax.persistence.fetchgraph", entityGraph);
   * Artist post = entityManager.find(Artist.class, id, properties);
   *
   */
}
