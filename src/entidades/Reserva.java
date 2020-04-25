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

		long dif = checkIn.getTime() - checkOut.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

	}

	public String updateDate(Date chechIn, Date CheckOut) {
		Date dataAtual = new Date();
		if (checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
			return "Erro na reserva: as datas têm de ser posteriores a data actual";
		}
		if (!checkOut.after(checkIn)) {

			return "Erro na reserva: a data checkOut tem de se posterior a data de checkIn";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {

		return " Quarto " + numeroQuarto + " , checkIn " + sdf.format(checkIn) + " , checkOut " + sdf.format(checkOut)
				+ " , " + duracao() + " noites";
	}

}
