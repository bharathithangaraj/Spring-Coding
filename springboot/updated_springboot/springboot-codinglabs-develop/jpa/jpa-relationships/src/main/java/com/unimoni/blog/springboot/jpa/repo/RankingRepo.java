package com.unimoni.blog.springboot.jpa.repo;

import com.unimoni.blog.springboot.jpa.domain.Ranking;
import org.springframework.data.repository.CrudRepository;

public interface RankingRepo extends CrudRepository<Ranking, Long> {
}
