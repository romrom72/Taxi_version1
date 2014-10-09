package MonPackageEnJava;

import java.util.Scanner;

public class Fonction 
{

	//Variables
			static Scanner saisie = new Scanner(System.in);
			static String typeduTrajet, jour, heure;
			static int dept, dureeDepl, nbkm;
			
			
			//Constantes
			static double[][] tarifdep =
			{
			 // Dept -- PriseCharge -- TarifARJ -- TarifASJ -- TarifHoraireJ -- TarifNuitAR -- TarifNuitAS -- TarifHoraireNuitWE
				{21,        2,            0.86,      1.72,        21.93,           1.29,           2.58,            21.93},
				
				{25,       2.1,           0.83,      1.66,        22.5,            1.2,            2.4,             22.5},
				
				{39,       2.1,           0.83,      1.66,        22.5,            1.23,           2.46,            25},
				
				{44,       2.2,           0.79,      1.58,        24.19,           1.19,           2.37,            24.19},
				
				{72,       2.15,          0.79,      1.58,        22.86,           1.19,           2.38,            22.86},
				
				{73,       2.4,           0.84,      1.68,        25.4,            1.26,           2.52,            25.4},
				
				{74,       3.15,          0.92,      1.84,        17.3,            1.38,           2.76,            17.3},
				
				{75,       2.5,           1,         1.24,        0.0,             1.5,            1.5,             0.0},
				
				{85,       2.3,           0.8,       1.6,         22.2,            1.2,            2.4,             22.2},
				
				{90,       2.2,           0.83,      1.66,        21,              1.15,           2.3,             21}
			};
			
			
			public static void SaisieDept() //Methode saisie entrées
			{
				System.out.print("Veuillez saisir le numero de departement (21 - 25 - 39 - 44 - 72 - 73 - 74 - 75 - 85 - 90 : ");
		        dept = saisie.nextInt();
		        
		        System.out.print("Veuillez saisir le type de votre déplacement (AS -- AR) : ");
		        typeduTrajet = saisie.next();
		        
		        System.out.print("Veuillez saisir le jour de votre déplacement (S: Semaine / W: Week-end) : ");
		        jour = saisie.next();
		        
		        System.out.print("Veuillez saisir l'heure de votre déplacement (J - Jours: < 20h -- N - Nuit: > 20h) : ");
		        heure = saisie.next();
		        
		        System.out.print("Veuillez saisir la durée de votre déplacement en Minutes : ");
		        dureeDepl = saisie.nextInt();
		        
		        System.out.print("Veuillez saisir le nombre de kilomètres parcourus lors de votre déplacement : ");
		        nbkm = saisie.nextInt();
		               
		        
			}
			
			public static void controleSaisie() //Methode saisie entrées
			{
				if(typeduTrajet.equals("") || jour.equals("") || heure.equals(""))
				{
					System.out.print("Erreur de saisie, veuillez recommencez SVP ");
				}
			}
			
			public static double CalculTarifDepl(int dept) //calculer les frais
			{
				double prix = 0.0;
				
				if(typeduTrajet.equals("AS"))
				{ //Aller - Simple
					
		            if(jour.equals("S") && heure.equals("J"))
		            {
		                prix = tarifdep[dept][1] + (nbkm * tarifdep[dept][3]);
		                if(dureeDepl > 60) //Et de plus d'une heure
		                    prix = (int)(dureeDepl/60) * tarifdep[dept][4];
		        }
		            else
		            {
		            	
		                prix = tarifdep[dept][1] + (nbkm * tarifdep[dept][6]);
		                if(dureeDepl > 60) 
		                    prix = (int)(dureeDepl/60) * tarifdep[dept][7];
		            }
		        }
		        else if(typeduTrajet.equals("AR"))
		        	
		        { //Aller - Retour
		            if(jour.equals("S") && heure.equals("J"))
		            {
		                prix = tarifdep[dept][1] + (nbkm * tarifdep[dept][2]);
		                if(dureeDepl > 60)
		                    prix = (int)(dureeDepl/60) * tarifdep[dept][4];
		        }
		            else
		            	
		            {
		                prix = tarifdep[dept][1] + (nbkm * tarifdep[dept][5]);
		                if(dureeDepl > 60)
		                    prix = (int)(dureeDepl/60) * tarifdep[dept][7];
		            }
		        }
				
				return prix;
			}
}
