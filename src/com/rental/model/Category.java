package com.rental.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private long categoryId;
	private Timestamp lastUpdate;
	private String name;
	private List<FilmCategory> filmCategories;

	public Category() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id", columnDefinition="TINYINT")
	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	@Column(name="last_update")
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to FilmCategory
	@OneToMany(mappedBy="category")
	public List<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(List<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().add(filmCategory);
		filmCategory.setCategory(this);

		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().remove(filmCategory);
		filmCategory.setCategory(null);

		return filmCategory;
	}

}