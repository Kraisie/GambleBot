package com.motorbesitzen.gamblebot.data.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class GamblePrize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prizeId;

	@NotNull
	private String prizeName;

	@NotNull
	private double prizeChance;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "settingsId")
	private GambleSettings settings;

	protected GamblePrize() {
	}

	public GamblePrize(@NotNull String prizeName, @NotNull double prizeChance, @NotNull GambleSettings settings) {
		this.prizeName = prizeName;
		this.prizeChance = prizeChance;
		this.settings = settings;
	}

	public long getPrizeId() {
		return prizeId;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public double getPrizeChance() {
		return prizeChance;
	}

	@Override
	public String toString() {
		return "{\"" + prizeName + "\", " + prizeChance + "}";
	}
}
