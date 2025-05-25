
import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

       // test Albero binario ordinato
       System.out.println("JavaTree started!");

       Tree<String> tree = new Tree<>();

       File file = new File("data/province.txt");
       try (Scanner scan = new Scanner(file)) {
              while (scan.hasNextLine()) {
                  String line = scan.nextLine();
                  tree.add(line);
              }
       }
       System.out.println(tree);

       tree.print();


    }
}
