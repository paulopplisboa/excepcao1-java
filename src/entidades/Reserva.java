package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		
		long dif = checkIn.getTime()-checkOut.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDate(Date chechIn, Date CheckOut) {
		this.checkIn=checkIn;
		this.checkOut=checkOut;
	}
	
	@Override
	public String toString() {
		
		return " Quarto " +numeroQuarto+ " , checkIn "+sdf.format(checkIn)+" , checkOut "
		+sdf.format(checkOut)+" , "+duracao()+" noites";
	}
	

}
