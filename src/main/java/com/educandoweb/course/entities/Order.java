package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long a_id;

	@Column(name = "momento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant b_momento;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User c_client;

	public Order() {
	}

	public Order(Long id, Instant momento, User client) {
		this.a_id = id;
		this.b_momento = momento;
		this.c_client = client;
	}

	public Long getId() {
		return a_id;
	}

	public void setId(Long id) {
		this.a_id = id;
	}

	public Instant getMomento() {
		return b_momento;
	}

	public void setMomento(Instant momento) {
		this.b_momento = momento;
	}

	public User getClient() {
		return c_client;
	}

	public void setClient(User client) {
		this.c_client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(a_id, other.a_id);
	}

}
