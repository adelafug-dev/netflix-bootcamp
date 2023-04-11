package com.everis.d4i.tutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "TV_SHOWS")
public class TvShow implements Serializable {

	private static final long serialVersionUID = 4916713904971425156L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SHORT_DESC", nullable = true)
	private String shortDescription;

	@Column(name = "LONG_DESC", nullable = true)
	private String longDescription;

	@Column(name = "YEAR")
	private Year year;

	@Column(name = "RECOMMENDED_AGE")
	private byte recommendedAge;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		name = "TV_SHOWS_CATEGORIES",
		joinColumns = @JoinColumn(name = "ID_TV_SHOW"),
		inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIES"))
	private List<Category> category;

	@Column(name = "ADVERTISING", nullable = true)
	private String advertising;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShow")
	private List<Season> seasons;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TvShow tvShow = (TvShow) o;
		return recommendedAge == tvShow.recommendedAge && Objects.equals(id, tvShow.id) && Objects.equals(name, tvShow.name) && shortDescription.equals(tvShow.shortDescription) && longDescription.equals(tvShow.longDescription) && Objects.equals(year, tvShow.year) && Objects.equals(category, tvShow.category) && advertising.equals(tvShow.advertising) && Objects.equals(seasons, tvShow.seasons);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, shortDescription, longDescription, year, recommendedAge, category, advertising, seasons);
	}

	@Override
	public String toString() {
		return "TvShow{" +
				"id=" + id +
				", name='" + name + '\'' +
				", shortDescription='" + shortDescription + '\'' +
				", longDescription='" + longDescription + '\'' +
				", year=" + year +
				", recommendedAge=" + recommendedAge +
				", category=" + category +
				", advertising='" + advertising + '\'' +
				", seasons=" + seasons +
				'}';
	}

}
