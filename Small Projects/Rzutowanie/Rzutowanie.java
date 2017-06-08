/**
 * Created by Edyta on 21.01.2017.
 */
public class Rzutowanie {
    public static void demo(){
        //rzutowanie int na double
        int a=5;
        double b=2.0;
        double c=a/b;
        ///int c=a/b; to sie nie skompiluje;
        System.out.println(c);

        char letterA = 'a';
        char letterB = 'b';
        int A = letterA;
        int B = letterB;
        System.out.println("a jako int to " + A);
        System.out.println("b jako int to " + B);


    };
    public static void ASCITable(int numberOfCharacters){

        System.out.println("Przypisanie liter do liczb w tablicy ASCII dla pierwszych "+ numberOfCharacters + " znaków jest następujące: ");

        char[] charTable = new char[numberOfCharacters];
        for(int i=0;i<charTable.length;i++){
            charTable[i] = (char)i;
        }
        for (char ch:charTable) {//wywołanie pętli for each
            System.out.println(ch + " " + (int)ch);
        }

    }

    public static void main(String[] args) {
        Rzutowanie.demo();
        Rzutowanie.ASCITable(150);

    }
}
