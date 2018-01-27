package Metier;

public class TestCredit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	CreditMetier cm= new CreditMetier();
	double mensualite= cm.calculMensualite(200000, 240,4.5);
	System.out.println(mensualite);
	
	}

}
