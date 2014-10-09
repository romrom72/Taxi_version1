package MonPackageEnJava;
public class MaPremiereClasseEnJava {
	
				public static void main(String[] args){		        
		        int departement = 0;
		        
		        Fonction.SaisieDept(); //Saisie de l'utilisateur
		        Fonction.controleSaisie(); // controle des saisies
		        for(int i = 0; i<10; i++){ // si le departement correspond à celui saisie lors de la fonction
		            if(Fonction.tarifdep[i][0] == Fonction.dept)
		                departement = i;
		        }

		        System.out.print("\n\nLa tarif de votre déplacement est de : " + String.valueOf(Fonction.CalculTarifDepl(departement)) + "€"); //Affichage du prix + aide de google
		    }
	}