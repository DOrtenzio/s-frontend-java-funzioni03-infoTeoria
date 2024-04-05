import javax.sql.rowset.BaseRowSet;
import java.util.Random;
import java.util.Scanner;

public class Matrici {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Random generatore = new Random();
        int n1,n2,colonne,righe;
        System.out.println("Inserisci il numero di righe");
        righe=in.nextInt();
        System.out.println("Inserisci il numero di colonne");
        colonne=in.nextInt();
        int [][] m=new int[righe][colonne];
        if (colonne==righe){
            System.out.println("E' necessaria una matrice rettangolare!");
        }
        else {
            for (int i = 0; i < m.length; i++) {
                for (int p = 0; p <m[0].length; p++) {
                    m[i][p] = generatore.nextInt(200);
                    System.out.print(m[i][p]+" ");
                }
                System.out.println();
            }
            //Prima funzione
            System.out.println("Inserire due indici di colonna da scambiare --> Il primo :");
            n1=in.nextInt();
            System.out.println("Inserire due indici di colonna da scambiare --> Il secondo :");
            n2=in.nextInt();
            invertiIndiciColonne(m,n1,n2);
            //Stampa
            for (int i = 0; i < m.length; i++) {
                for (int p = 0; p < m[0].length; p++) {
                    System.out.print(m[i][p]+" ");
                }
                System.out.println();
            }
            //Seconda funzione
            System.out.println("Inserire due indici di riga da scambiare --> Il primo :");
            int r1=in.nextInt();
            System.out.println("Inserire due indici di riga da scambiare --> Il secondo :");
            int r2=in.nextInt();
            invertiIndiciRighe(m,r1,r2);
            //Stampa
            for (int i = 0; i < m.length; i++) {
                for (int p = 0; p < m[0].length; p++) {
                    System.out.print(m[i][p]+" ");
                }
                System.out.println();
            }
            //Terza funzione
            int [][] m2={
                    {0,7,3,8},
                    {7,0,4,11},
                    {3,4,0,13},
                    {8,11,13,0}
            };
            if(isSimmetrycaByDiagonalsPrincipals(m2))
                System.out.println("Ok");
            else
                System.out.println("Non ok");
            //Quarta funzione
            int [][] m3={
                    {0,15,13,18},
                    {57,0,54,211},
                    {3,4,0,163},
                    {8,11,13,0}
            };
            matriceTrasponded(m3);
            //Stampa
            for (int i = 0; i < m3.length; i++) {
                for (int p = 0; p < m3[0].length; p++) {
                    System.out.print(m3[p][i]+" ");
                }
                System.out.println();
            }
            //Quinta funzione
            int [] sommariga=new int[m.length];
            matriceSumsRights(m,sommariga);
            for (int i=0;i< sommariga.length;i++){
                System.out.println("La somma della riga "+i+" è "+sommariga[i]);
            }
            //Sesta funzione
            int [] sommacolonna=new int[m[0].length];
            matriceSumsColons(m,sommacolonna);
            for (int i=0;i< sommacolonna.length;i++){
                System.out.println("La somma della colonna "+i+" è "+sommacolonna[i]);
            }
            //Settima funzione
            int [][] m4={
                    {0,15,13,18},
                    {57,0,54,211},
                    {3,4,0,163},
                    {8,11,13,0}
            };
            matriceRiempid(m4);
            for (int i = 0; i < m4.length; i++) {
                for (int p = 0; p < m4[0].length; p++) {
                    System.out.print(m4[i][p]+" ");
                }
                System.out.println();
            }
            //Ottava funzione
            matriceRiempidContraria(m4);
            for (int i = 0; i < m4.length; i++) {
                for (int p = 0; p < m4[0].length; p++) {
                    System.out.print(m4[i][p]+" ");
                }
                System.out.println();
            }
            //Nona funzione
            int [][] m5={
                    {0,15,13,18},
                    {5,0,54,211},
                    {5,5,0,163},
                    {5,5,5,0}
            };
            if(sottoLaDiagonale(m5))
                System.out.println("Ok");
            else
                System.out.println("Non ok");
            if(sottoLaDiagonale(m3))
                System.out.println("Ok");
            else
                System.out.println("Non ok");
        }
    }
    private static void invertiIndiciColonne(int [][] m,int n1,int n2){
        int temp;
        for (int i=0;i<m.length;i++){
            temp=m[i][n1];
            m[i][n1]=m[i][n2];
            m[i][n2]=temp;
        }
    }
    private static void invertiIndiciRighe(int [][] m,int n1,int n2){
        int temp;
        for (int i=0;i<m[0].length;i++){
            temp=m[n1][i];
            m[n1][i]=m[n2][i];
            m[n2][i]=temp;
        }
    }
    private static boolean isSimmetrycaByDiagonalsPrincipals(int [][] m){
        boolean isEquals=true;
        for (int i = 0; i < m[0].length; i++) {
            for (int p = 0; p < m.length; p++) {
                if (m[p][i]!=m[i][p]){
                    isEquals=false;
                    break;
                }
            }
        }
        return isEquals;
    }
    private static void matriceTrasponded (int [][] m){
        int temp;
        for (int i = 0; i < m[0].length; i++) {
            for (int p = 0; p < m.length; p++) {
                temp=m[i][p];
                m[i][p]=m[p][i];
                m[p][i]=temp;
            }
        }
    }
    private static void matriceSumsRights (int [][] m, int [] somma){
        for (int i = 0; i < m.length; i++) { //Indice della riga
            for (int p = 0; p < m[0].length; p++) { //Indice della colonna
                somma[i]+=m[i][p];
            }
        }
    }
    private static void matriceSumsColons (int [][] m, int [] somma){
        for (int i = 0; i < m[0].length; i++) { //Indice della colonna
            for (int p = 0; p < m.length; p++) { //Indice della riga
                somma[i]+=m[p][i];
            }
        }
    }
    //Non va
    private static void matriceRiempid (int [][] m){
        for (int i=0;i<m[0].length;i++) {
            for (int p=i;p<m.length;p++) {
                m[p][i]=1;
            }
        }
        for (int i = 0; i < m[0].length; i++) { //Colonna
            for (int p=0;p<i;p++) { //Riga
                m[p][i]=0;
            }
        }
    }
    private static void matriceRiempidContraria (int [][] m){
        for (int i=0;i<m[0].length;i++) {
            for (int p=i;p<m.length;p++) {
                m[p][i]=0;
            }
        }
        for (int i = 0; i < m[0].length; i++) { //Colonna
            for (int p=0;p<=i;p++) { //Riga
                m[p][i]=1;
            }
        }
    }
    private static boolean sottoLaDiagonale (int [][] m){
        boolean isEquals=true;
        for (int i=0;i<m[0].length;i++) {
            for (int p=i;p<m.length;p++) {
                if (p!=i){
                    if (m[p][i]!=m[1][0]){
                        isEquals=false;
                        break;
                    }
                }
            }
            if (!isEquals)
                break;
        }
        return isEquals;
    }
}
