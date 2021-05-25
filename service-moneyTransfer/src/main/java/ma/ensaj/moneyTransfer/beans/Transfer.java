package ma.ensaj.moneyTransfer.beans;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transfer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cinSender;
	private Double amount;
	private String nameReceiver;
	private String cinReceiver;
	private long code;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSending;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReceiving;
	
	@Column(columnDefinition="BOOLEAN DEFAULT false")
	private Boolean isReceived;

	public Transfer() {
		super();
		this.code = new Random().nextLong() % (9999999999L - 1000000000L) + 9999999999L;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCinSender() {
		return cinSender;
	}

	public void setCinSender(String cinSender) {
		this.cinSender = cinSender;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNameReceiver() {
		return nameReceiver;
	}

	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}

	public String getCinReceiver() {
		return cinReceiver;
	}

	public void setCinReceiver(String cinReceiver) {
		this.cinReceiver = cinReceiver;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Date getDateSending() {
		return dateSending;
	}

	public void setDateSending(Date dateSending) {
		this.dateSending = dateSending;
	}

	public Date getDateReceiving() {
		return dateReceiving;
	}

	public void setDateReceiving(Date dateReceiving) {
		this.dateReceiving = dateReceiving;
	}

	public Boolean getIsReceived() {
		return isReceived;
	}

	public void setIsReceived(Boolean isReceived) {
		this.isReceived = isReceived;
	}
	
}
