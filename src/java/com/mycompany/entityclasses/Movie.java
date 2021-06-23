/*
 * Created by Osman Balci on 2016.05.23  * 
 * Copyright © 2016 Osman Balci. All rights reserved. * 
 */
package com.mycompany.entityclasses;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Balci
 */
// The @Entity annotation designates this class as a JPA Entity POJO class representing the Movie table in the MoviesDB database.
@Entity

// Name of the MoviesDB database table represented
@Table(name = "Movie")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByGenres", query = "SELECT m FROM Movie m WHERE m.genres = :genres"),
    @NamedQuery(name = "Movie.findByReleaseDate", query = "SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Movie.findByDirector", query = "SELECT m FROM Movie m WHERE m.director = :director"),
    @NamedQuery(name = "Movie.findByStars", query = "SELECT m FROM Movie m WHERE m.stars = :stars"),
    @NamedQuery(name = "Movie.findByFilmRating", query = "SELECT m FROM Movie m WHERE m.filmRating = :filmRating"),
    @NamedQuery(name = "Movie.findByPercentLiked", query = "SELECT m FROM Movie m WHERE m.percentLiked = :percentLiked")})

public class Movie implements Serializable {

    /*
    ========================================================
    Instance variables representing the attributes (columns)
    of the Movie table in the MoviesDB database.
    ========================================================
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "genres")
    private String genres;

    @Basic(optional = false)
    @NotNull
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "director")
    private String director;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "stars")
    private String stars;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "film_rating")
    private String filmRating;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "percent_liked")
    private String percentLiked;

    /*
    =============================================================
    Class constructors for instantiating a Movie entity object to
    represent a row in the Movie table in the MoviesDB database.
    =============================================================
     */
    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public Movie(Integer id, String title, String genres, Date releaseDate, String director, String stars, String filmRating, String percentLiked) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.director = director;
        this.stars = stars;
        this.filmRating = filmRating;
        this.percentLiked = percentLiked;
    }

    /*
    ======================================================
    Getter and Setter methods for the attributes (columns)
    of the Movie table in the MoviesDB database.
    ======================================================
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }

    public String getPercentLiked() {
        return percentLiked;
    }

    public void setPercentLiked(String percentLiked) {
        this.percentLiked = percentLiked;
    }

    /**
     * @return Generates and returns a hash code value for the object with id
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Checks if the Movie object identified by 'object' is the same as the Movie object identified by 'id'
     *
     * @param object The Movie object identified by 'object'
     * @return True if the Movie 'object' and 'id' are the same; otherwise, return False
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * @return the String representation of a Movie id
     */
    @Override
    public String toString() {
        return "com.mycompany.entityclasses.Movie[ id=" + id + " ]";
    }

}
