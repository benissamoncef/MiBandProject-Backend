package com.iotconnect.miband.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Heartbeat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String data1;
	
	private String data2;
	
	private String data3;
	
	private String data4;
	
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS]")
	private LocalDateTime date_prelevement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate_prelevement() {
		return date_prelevement;
	}

	public void setDate_prelevement(LocalDateTime date_prelevement) {
		this.date_prelevement = date_prelevement;
	}
	
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	public String getData4() {
		return data4;
	}

	public void setData4(String data4) {
		this.data4 = data4;
	}

	@Override
	public String toString() {
		return "id : "+ id + " , data1 : " + data1 + " , date : " + date_prelevement;
	}
	
	@Override
	public int hashCode() {
		return data1.hashCode() + 31 + Long.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof Heartbeat))
	        return false;
	    Heartbeat other = (Heartbeat)o;
	    boolean heartbeatCodeEquals = (this.id == null && other.id == null)
	      || (this.id != null && this.id.equals(other.id));
	    return this.data1 == other.data1 && heartbeatCodeEquals;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
