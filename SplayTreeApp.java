
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class SplayTreeApp {
   public SplayTreeApp() {
   }

   public static void main(String[] var0) {
      SplayTree var1 = new SplayTree();
      Scanner var2 = new Scanner(System.in);
      System.out.println("Inserting initial elements: 10, 20, 30, 40, 50");
      var1.insert(10);
      var1.insert(20);
      var1.insert(30);
      var1.insert(40);
      var1.insert(50);
      System.out.println("Initial Tree Structure:");
      var1.printTree();

      int var3;
      do {
         System.out.println("\nMenu:");
         System.out.println("1. Insert");
         System.out.println("2. Search");
         System.out.println("3. Delete");
         System.out.println("4. Level Order Traversal");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         var3 = var2.nextInt();
         int var4;
         switch (var3) {
            case 1:
               System.out.print("Enter key to insert: ");
               var4 = var2.nextInt();
               var1.insert(var4);
               System.out.println("Tree after insertion of " + var4 + ":");
               var1.printTree();
               break;
            case 2:
               System.out.print("Enter key to search: ");
               var4 = var2.nextInt();
               int[] var5 = new int[1];
               int var6 = var1.search(var4, var5);
               System.out.println("Splay operation took " + var5[0] + " steps. Closest key is " + var6);
               System.out.println("Tree after search operation:");
               var1.printTree();
               break;
            case 3:
               System.out.print("Enter key to delete: ");
               var4 = var2.nextInt();
               var1.delete(var4);
               System.out.println("Key " + var4 + " deleted (if existed).");
               System.out.println("Tree after deletion of " + var4 + ":");
               var1.printTree();
               break;
            case 4:
               System.out.println("Level order traversal:");
               var1.levelOrderTraversal();
               break;
            case 5:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
      } while (var3 != 5);

      var2.close();
   }
}
