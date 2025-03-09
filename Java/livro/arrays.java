import static java.lang.System.out;

public class arrays {
    public static void main(String args[]){
        String[]nomes = new String[4];
        nomes[0]="Manoel";
        nomes[1]="Izabel";
        nomes[2]="Ítalo";
        nomes[3]="Bosco";
        for (int i=0; i<nomes.length; i++){
            out.print(nomes[i]+" ");
        }

        String[][]nomes2={ /*[a] altura [l] largura*//*nomes2.length = primeiro [x][]*//*nomes2[a].length = segundo [][x]*/
            {"Manoel","Izabel","Ítalo","Bosco"},
            {"Enzo","Poli","Bruno","Jaoa"},
            {"André","Benjamin","Bone","Eri"}};
        for(int a=0;a<nomes2.length;a++){
            out.println();
            out.println();
            for(int l=0;l<nomes2[a].length;l++){
                out.print(nomes2[a][l]+" ");
            }
        }
    }
}