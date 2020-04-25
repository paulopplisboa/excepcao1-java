package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira o número do quarto ");
		int numero = sc.nextInt();
		System.out.println("Check-In data (DD/MM/YYYY");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out data (DD/MM/YYYY");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de checkout tem de ser posterior a data de checkIn");
		} else {

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println("");
			System.out.println("Check-In data (DD/MM/YYYY");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (DD/MM/YYYY");
			checkOut = sdf.parse(sc.next());

			Date dataAtual = new Date();
			if (checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
				System.out.println("Erro na reserva: as datas têm de ser posteriores a data actual");
				System.out.println("");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data checkOut tem de se posterior a data de checkIn");
			} else {
				reserva.updateDate(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}

}
