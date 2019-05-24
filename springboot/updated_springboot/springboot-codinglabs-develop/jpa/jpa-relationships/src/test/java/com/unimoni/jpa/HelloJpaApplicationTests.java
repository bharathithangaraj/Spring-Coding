package com.unimoni.jpa;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.unimoni.blog.springboot.jpa.Application;
import com.unimoni.blog.springboot.jpa.domain.Artist;
import com.unimoni.blog.springboot.jpa.domain.Ranking;
import com.unimoni.blog.springboot.jpa.repo.ArtistRepo;
import com.unimoni.blog.springboot.jpa.repo.RankingRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import com.unimoni.blog.springboot.jpa.domain.QArtist;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HelloJpaApplicationTests {

  @Autowired
  ArtistRepo repo;

  @Autowired
  RankingRepo rankingRepo;

  @Autowired
  EntityManager manager;

  @Test
  public void contextLoads() {
//    repo.findByNameAndRankingUserRatings("test", 3, PageRequest.of(1, 10));
//    repo.findByName("test", PageRequest.of(1, 10));
//    JPAQueryFactory queryFactory = new JPAQueryFactory(manager);
////    JPAQuery query = new JPAQuery<Artist>(manager);
//    QArtist artist = QArtist.artist;
//    queryFactory.selectFrom(artist).fetchResults().getResults();




//    Artist artist = new Artist();
//    artist.setName("artist name");
//    Ranking ranking = new Ranking() ;
//    artist.setRanking(ranking);
//    ranking.setOverallRating(5);
//    ranking.setUserRatings(10);

    repo.findById(1L);

//    rankingRepo.findById(1L);


  }


}
