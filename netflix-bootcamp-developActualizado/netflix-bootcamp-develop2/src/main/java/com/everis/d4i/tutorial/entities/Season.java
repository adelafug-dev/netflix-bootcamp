package com.everis.d4i.tutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "SEASONS")
public class Season implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMBER")
	private short number;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TV_SHOW_ID", nullable = false)
	private TvShow tvShow;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "season")
	private List<Chapter> chapters;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Season season = (Season) o;
		return number == season.number && Objects.equals(id, season.id) && Objects.equals(name, season.name) && Objects.equals(tvShow, season.tvShow) && Objects.equals(chapters, season.chapters);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number, name, tvShow, chapters);
	}

	@Override
	public String toString() {
		return "Season{" +
				"id=" + id +
				", number=" + number +
				", name='" + name + '\'' +
				", tvShow=" + tvShow +
				", chapters=" + chapters +
				'}';
	}

}
