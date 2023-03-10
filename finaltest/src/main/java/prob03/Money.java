package prob03;

import java.util.Objects;

public class Money {
	private int amount;
	
	public Money(int i) {
		this.amount = i;
	}

	public Object add(Money three) {
		return new Money(amount + three.amount);
	}

	public Object minus(Money two) {
		return new Money(amount - two.amount);
	}

	public Object multiply(Money two) {
		return new Money(amount * two.amount);
	}

	public Object devide(Money five) {
		return new Money(amount / five.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(amount);
//	}

	
//	@Override
//	public boolean equals(Object obj) {
//		// money 타입 확인 && 타입이 같다면 금액이 동일한지 확인
//		if(obj instanceof Money && amount == ((Money)obj).amount)
//			return true;
//		else return false;
//	}

	
	
	/* 코드 작성 */
}
