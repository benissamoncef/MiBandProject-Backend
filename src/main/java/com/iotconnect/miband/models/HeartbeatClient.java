package com.iotconnect.miband.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class HeartbeatClient {
	
	@NotNull
	private String mac;
	
	@NotNull
	private String data1;
	
	private String data2;
	
	private String data3;
	
	private String data4;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS]")
	private LocalDateTime date_prelevement;

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
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
	
	
}
