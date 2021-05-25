package ma.ensaj.phoneRecharge.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Recharge {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String numTel;
	private String typeRecharge;
	@Min(value = 5)
	private Double amount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String operator;
	
	public Recharge() {
		
	}
	public Recharge(String numTel, String typeRecharge, Double amount, Date date,String operator) {
		super();
		this.numTel = numTel;
		this.typeRecharge = typeRecharge;
		this.amount = amount;
		this.date = date;
		this.operator = operator;
	}
	
	public Recharge(int id, String numTel, String typeRecharge, Double amount, Date date,String operator) {
		super();
		this.id = id;
		this.numTel = numTel;
		this.typeRecharge = typeRecharge;
		this.amount = amount;
		this.date = date;
		this.operator = operator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getTypeRecharge() {
		return typeRecharge;
	}
	public void setTypeRecharge(String typeRecharge) {
		this.typeRecharge = typeRecharge;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@Override
	public String toString() {
		return "Recharge [id=" + id + ", numTel=" + numTel + ", typeRecharge=" + typeRecharge + ", amount=" + amount
				+ ", date=" + date + ", operator=" + operator + "]";
	}
		
}
