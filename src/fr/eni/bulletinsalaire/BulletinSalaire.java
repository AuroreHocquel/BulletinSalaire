/**
 * @author Aurore HOCQUEL
 * @date 28 juillet 2023
 */
package fr.eni.bulletinsalaire;


import java.util.Scanner;

public class BulletinSalaire {

    static final int CADRE = 1;
    static final int EMPLOYE_BUREAU = 2;
    static final int AGENT_MAITRISE = 3;

    public static void main(String[] args) {

        // Déclaration et Initialisation variables
        String nom = null;
        String prenom = null;
        int statut = 0;
        int nbHeures = 0;
        float tauxHoraire = 0;
        int nbEnfant = 0;
        int primeEnfant = 0;
        float salaireBrut = 0;
        float cotisationsSociales;
        float salaireNet = 0;

        // Mise en place du scanner
        Scanner scanner = new Scanner(System.in);

        //Verification de la présence du nom du salarié et le demande si c'est vide
        // trim supprime les espaces vide et .isEmpty (est vide)
        while (nom == null || nom.trim().isEmpty()) {
            System.out.println("Nom de l'employé : ");
            nom = scanner.nextLine();
        }

        //Verification de la présence du prenom du salarié et le demande si c'est vide
        // trim supprime les espaces vide et .isEmpty (est vide)
        while (prenom == null || prenom.trim().isEmpty()) {
            System.out.println("Prénom de l'employé : ");
            prenom = scanner.nextLine();
        }

        //Verification de la présence du statut du salarié et le demande si c'est vide
        // trim supprime les espaces vide et .isEmpty (est vide)
        while (statut == 0) {
            System.out.println("Statut de l'employé : ");
            System.out.println("1 = Cadre, 2 = Employé, 3 = Agent");
            statut = scanner.nextInt();
        }

        // Calcul Salaire brut
        System.out.println("Combien d'heures ont été effectuées ?");
        nbHeures = scanner.nextInt();

        while (tauxHoraire <= 0) {
            System.out.println("Taux horaire brut: ");
            tauxHoraire = scanner.nextFloat();
        }

        // Calcul du salaire brut selon le nombre d'heures effectués → différents taux
        if (nbHeures <= 169) {
            // Heures Normales
            salaireBrut = (nbHeures * tauxHoraire);
            System.out.println("Le salaire brut est " + salaireBrut);

        } else if (nbHeures <= 180) {
            //Heure sup entre 169 et 180 h majorés à 50%
            salaireBrut = (float) (169 * tauxHoraire + (nbHeures - 169) * tauxHoraire * 1.5);
            System.out.println("Le salaire brut est " + salaireBrut);

        } else {
            // Heure sup > 180 h majorés à 60%
            salaireBrut = (float) (169 * tauxHoraire + (180 - 169) * tauxHoraire * 1.5 +
                    (nbHeures - 180) * tauxHoraire * 1.6);
            System.out.println("Le salaire brut est " + salaireBrut);
        }

        // Nombre d'enfants et prime
        System.out.println("Nombre d'enfants");
        nbEnfant = scanner.nextInt();

        if (nbEnfant == 1) {
            primeEnfant = 20;
        } else if (nbEnfant == 2) {
            primeEnfant = 50;
        } else {
            primeEnfant = 70 + (nbEnfant - 2) * 20;
        }
        System.out.println("le montant de la prime est de :" + primeEnfant);

        // Calcul des cotisations sociales
        cotisationsSociales = (float) (salaireBrut * (0.0349 + 0.0615 + 0.0095 + 0.0844 + 0.0305 + 0.0381 + 0.0102));
        System.out.println("Le montant des cotisations salariales est de : " + cotisationsSociales);

        // Calcul salaire net
        salaireNet = salaireBrut - cotisationsSociales + primeEnfant;
        System.out.println("Le salaire net est de :" + salaireNet);
    }
}
