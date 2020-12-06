package practiceOL.Beans;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Bean represent the item table 
 * @author alon seftel
 *
 */
@Entity
@Scope("prototype")
@Component
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	@Column
	private String name;
	@Column
	private int amount;
	@Column
	private int code;

	public Item(int number, String name, int amount, int code) {
		super();
		this.number = number;
		this.name = name;
		this.amount = amount;
		this.code = code;
	}
	

	public Item(String name, int amount, int code) {
		super();
		this.name = name;
		this.amount = amount;
		this.code = code;
	}


	public Item() {
		super();
	
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


@Override
	public String toString() {
		return "Item [number=" + number + ", name=" + name + ", amount=" + amount + ", code=" + code + "]";
	}


@Override
public int hashCode() {
	return Objects.hash(amount, code, name, number);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	return amount == other.amount && code == other.code && Objects.equals(name, other.name) && number == other.number;
}
}
