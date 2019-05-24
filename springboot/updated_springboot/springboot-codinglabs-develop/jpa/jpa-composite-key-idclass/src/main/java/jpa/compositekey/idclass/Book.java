package jpa.compositekey.idclass;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor

	@Entity
	@IdClass(Book.IdClass.class)
	public class Book {
	    @Id
	    private String name;

	    @Id
	    private Date publishedDate;

	    private Date updatedDate = new Date();

	    public Book(String name, Date publishedDate) {
	        this.name = name;
	        this.publishedDate = publishedDate;
	    }

	    @Data
	    static class IdClass implements Serializable {
	        private String name;
	        private Date publishedDate;
	    }
	}
