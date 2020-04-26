package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.exception.DomainException;
import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Insira o número do quarto ");
			int numero = sc.nextInt();
			System.out.println("Check-In data (DD/MM/YYYY");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (DD/MM/YYYY");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println("");
			System.out.println("Check-In data (DD/MM/YYYY");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (DD/MM/YYYY");
			checkOut = sdf.parse(sc.next());
	
			reserva.updateDate(checkIn, checkOut);
	
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Inseriu uma data invalida ");
			
		}
		catch (DomainException e){
			
			System.out.println("Erro na reserva "+e.getMessage());
		}
		sc.close();
	}

}
