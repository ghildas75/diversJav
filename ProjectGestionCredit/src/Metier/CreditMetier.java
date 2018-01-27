package Metier;

public class CreditMetier {

	
public double calculMensualite(double capital, int duree, double taux) {
	
	double t=taux/100;
	double t1=capital*t/12;
	double t2=1-Math.pow((1+t/12),-1*duree);
	return t1/t2;
}
	
}
