package com.leoncarraro.springwebflux.domain.document;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Coffee {

	@Id
	private String id;

	private String name;

	private BigDecimal price;

	public Coffee() {
	}

	public Coffee(final String id, final String name, final BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final Coffee coffee = (Coffee) o;

		return Objects.equals(id, coffee.id) && //
				Objects.equals(name, coffee.name) && //
				Objects.equals(price, coffee.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}

}
