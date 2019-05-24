package com.unimoni.blog.springboot.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist")
@NamedEntityGraph(
    name = "artist-recording",
    attributeNodes = {
        @NamedAttributeNode("recordings")
    },
    subgraphs = {
        @NamedSubgraph(
            name = "recording-release",
            attributeNodes = {
                @NamedAttributeNode("releases")
            }
        )
    }
)
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "artist_id")
  private Long artistId;

  @Column(name = "name")
  private String name;

  @OneToOne(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Ranking ranking;

  @OneToMany(mappedBy = "artist")
  private Set<Recording> recordings = new HashSet<>();

  public Long getArtistId() {
    return artistId;
  }

  public void setArtistId(Long artistId) {
    this.artistId = artistId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Ranking getRanking() {
    return ranking;
  }

  public void setRanking(Ranking ranking) {
    this.ranking = ranking;
  }

  public Set<Recording> getRecordings() {
    return recordings;
  }

  public void setRecordings(Set<Recording> recordings) {
    this.recordings = recordings;
  }
}
