package com.rental.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
//@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private int filmId;
	private String description;
	private int languageId;
	private Timestamp lastUpdate;
	private int length;
	private Byte originalLanguageId;
	private String rating;
	private Date releaseYear;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private BigDecimal replacementCost;
	private String specialFeatures;
	private String title;
	private List<FilmActor> filmActors;
	private List<FilmCategory> filmCategories;

	public Film() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id", columnDefinition="SMALLINT")
	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Column(columnDefinition="text")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="language_id", columnDefinition="tinyint")
	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}


	@Column(name="last_update")
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(columnDefinition="SMALLINT")
	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}


	@Column(name="original_language_id")
	public Byte getOriginalLanguageId() {
		return this.originalLanguageId;
	}

	public void setOriginalLanguageId(Byte originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}


	@Column(columnDefinition="enum('G','PG','PG-13','R','NC-17')")
	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="release_year", columnDefinition="year(4)")
	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}


	@Column(name="rental_duration")
	public byte getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}


	@Column(name="rental_rate")
	public BigDecimal getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}


	@Column(name="replacement_cost")
	public BigDecimal getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}


	@Column(name="special_features", columnDefinition="set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
	public String getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-one association to FilmActor
	@OneToMany(mappedBy="film")
	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setFilm(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setFilm(null);

		return filmActor;
	}


	//bi-directional many-to-one association to FilmCategory
	@OneToMany(mappedBy="film")
	public List<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(List<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().add(filmCategory);
		filmCategory.setFilm(this);

		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().remove(filmCategory);
		filmCategory.setFilm(null);

		return filmCategory;
	}


	@Override
	public String toString() {
		return "Film [filmId=" + filmId 
				+ ", title=" + title
				+ ", description=" + description
				+ ", languageId=" + languageId + ", lastUpdate=" + lastUpdate
				+ ", length=" + length + ", originalLanguageId="
				+ originalLanguageId + ", rating=" + rating + ", releaseYear="
				+ releaseYear + ", rentalDuration=" + rentalDuration
				+ ", rentalRate=" + rentalRate + ", replacementCost="
				+ replacementCost + ", specialFeatures=" + specialFeatures
				+ ", filmActors=" + filmActors
				+ ", filmCategories=" + filmCategories + "]";
	}

}