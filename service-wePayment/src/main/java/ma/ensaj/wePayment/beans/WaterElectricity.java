package ma.ensaj.wePayment.beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class WaterElectricity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String contractNbr;
	private String agency;
	private int month;
	private int year;
	private Double amount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(columnDefinition="BOOLEAN DEFAULT false")
	private Boolean isPaid;
	
	public WaterElectricity() {
		super();
	}
	public WaterElectricity(int id, String contractNbr, String agency, int month,int year, Double amount, Date date) {
		super();
		this.id = id;
		this.contractNbr = contractNbr;
		this.agency = agency;
		this.month = month;
		this.amount = amount;
		this.date = date;
		this.year = year;
	}
	
	
	
	public WaterElectricity(String contractNbr, String agency, int month,int year, Double amount, Date date) {
		super();
		this.contractNbr = contractNbr;
		this.agency = agency;
		this.month = month;
		this.amount = amount;
		this.date = date;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContractNbr() {
		return contractNbr;
	}
	public void setContractNbr(String contractNbr) {
		this.contractNbr = contractNbr;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Override
	public String toString() {
		return "WaterElectricity [id=" + id + ", contractNbr=" + contractNbr + ", agency=" + agency + ", month=" + month
				+ ", year=" + year + ", amount=" + amount + ", date=" + date + ", isPaid=" + isPaid + "]";
	}
	
	
	
}
