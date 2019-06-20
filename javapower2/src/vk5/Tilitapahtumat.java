/**
 * 
 */
package vk5;

import java.util.*;
import java.text.NumberFormat;

/**
 * @author Marko
 *
 */

class Tili {
	private static final double KORKO = 0.045; // Korkotaso 4.5%
	private static final double PALVELUMAKSU = 9.00; // Kuukausittainen sopimusmaksu
	private long tilinumero;
	private double saldo;
	private String nimi;

	public Tili(String nimi, int tilinumero, double saldo) {
		this.nimi = nimi;
		this.tilinumero = tilinumero;
		this.saldo = saldo;
	}

	public void tallenna(double talletus) {
		this.saldo = this.saldo + talletus;

	} // kasvattaa saldoa summalla

	public void nosto(double poisto) {
		this.saldo = this.saldo - poisto;
	} // v‰hent‰‰ saldoa summalla

	public void laskeKorko() {
		this.saldo = saldo * (1 + KORKO);

	} // laskee saldolle koron ja lis‰‰ sen saldoon

	public void palvelumaksu() {
		this.saldo = this.saldo - PALVELUMAKSU;
	}// v‰hent‰‰ salodosta palvelumaksun

	public long getTilinumero() {
		return this.tilinumero;
	}

	public double getSaldo() {
		return this.saldo;
	} // palauttaa tilin saldon
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return tilinumero + "\t" + nimi + "\t" + fmt.format(saldo);
		
	}
}

public class Tilitapahtumat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tili tili1 = new Tili("Kake K", 123456, 1024.56);
		Tili tili2 = new Tili("Kaarina L", 654321, 510.00);

		tili1.tallenna(25.86);
		tili2.tallenna(500.00);
		System.out.format("Tilinro: %d, saldo %.2f %n", tili1.getTilinumero(), tili1.getSaldo());
		System.out.format("Tilinro: %d, saldo %.2f %n", tili2.getTilinumero(), tili2.getSaldo());

		tili2.nosto(355.75);
		System.out.format("Tilinro: %d, saldo %.2f %n", tili2.getTilinumero(), tili2.getSaldo());

		tili2.tallenna(230.75);
		System.out.format("Tilinro: %d, saldo %.2f %n", tili2.getTilinumero(), tili2.getSaldo());

		tili1.laskeKorko();
		tili2.laskeKorko();

		System.out.format("Tilinro: %d, saldo %.2f %n", tili1.getTilinumero(), tili1.getSaldo());
		System.out.format("Tilinro: %d, saldo %.2f %n", tili2.getTilinumero(), tili2.getSaldo());

		tili1.palvelumaksu();
		tili2.palvelumaksu();
		System.out.format("Tilinro: %d, saldo %.2f %n", tili1.getTilinumero(), tili1.getSaldo());
		System.out.format("Tilinro: %d, saldo %.2f %n", tili2.getTilinumero(), tili2.getSaldo());
		System.out.println(tili1);
	}

}
