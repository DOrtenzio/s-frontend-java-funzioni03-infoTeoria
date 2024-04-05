package matrici;
public class Matrici {
    public static void invertiIndiciColonne(int [][] m,int n1,int n2){
        int temp;
        for (int i=0;i<m.length;i++){
            temp=m[i][n1];
            m[i][n1]=m[i][n2];
            m[i][n2]=temp;
        }
    }
    public static void invertiIndiciRighe(int [][] m,int n1,int n2){
        int temp;
        for (int i=0;i<m[0].length;i++){
            temp=m[n1][i];
            m[n1][i]=m[n2][i];
            m[n2][i]=temp;
        }
    }
    public static boolean isSimmetricaDiagMaggiore (int [][] m){
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
    public static void matriceTrasposta (int [][] m){
        int temp;
        for (int i = 0; i < m[0].length; i++) {
            for (int p = 0; p < m.length; p++) {
                temp=m[i][p];
                m[i][p]=m[p][i];
                m[p][i]=temp;
            }
        }
    }
    public static void matriceSommaRighe (int [][] m, int [] somma){
        for (int i = 0; i < m.length; i++) { //Indice della riga
            for (int p = 0; p < m[0].length; p++) { //Indice della colonna
                somma[i]+=m[i][p];
            }
        }
    }
    public static void matriceSommaColonne (int [][] m, int [] somma){
        for (int i = 0; i < m[0].length; i++) { //Indice della colonna
            for (int p = 0; p < m.length; p++) { //Indice della riga
                somma[i]+=m[p][i];
            }
        }
    }
    public static void matriceRiempitiva (int [][] m){
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
    public static void matriceRiempitivaContraria (int [][] m){
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
    public static boolean isSottoLaDiagonale (int [][] m){
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
