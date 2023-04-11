package com.everis.d4i.tutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "CHAPTERS")
public class Chapter implements Serializable {

	private static final long serialVersionUID = 8725949484031409482L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMBER")
	private short number;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DURATION")
	private short duration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEASON_ID", nullable = false)
	private Season season;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Chapter chapter = (Chapter) o;
		return number == chapter.number && duration == chapter.duration && Objects.equals(id, chapter.id) && Objects.equals(name, chapter.name) && Objects.equals(season, chapter.season);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number, name, duration, season);
	}

	@Override
	public String toString() {
		return "Chapter{" +
				"id=" + id +
				", number=" + number +
				", name='" + name + '\'' +
				", duration=" + duration +
				", season=" + season +
				'}';
	}

}
