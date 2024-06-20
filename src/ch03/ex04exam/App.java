package ch03.ex04exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {
    Boolean flag = true;
    while (flag) {

      int menu = -1;
      {
        String line;
        String str = """
                ┌───────────────────────────────┐
                │           음료관리 메뉴       │
                └───────────────────────────────┘

                1. 음료목록
                2. 음료추가
                3. 종료
                (번호입력)>
            """;
        System.out.println(str);
        Scanner scan = new Scanner(System.in);

        line = scan.nextLine();
        menu = Integer.parseInt(line);
      }

      {
        FileInputStream fis = new FileInputStream("res/data1.csv");
        Scanner scan = new Scanner(fis);

        String[] temp = scan.nextLine().split(",");

        System.out.println("┌────────────────┬───────┬───────┐");

        System.out.print("|");
        for (int i = 0; i < temp.length; i++) {
          int length = temp[i].length();
          if (length == 3) {
            System.out.printf("%s\t\t ", temp[i]);
          } else if (length == 2) {
            System.out.printf("%s\t ", temp[i]);
          }
          System.out.print("|");
        }
        String line;

        System.out.println("");
        while (scan.hasNextLine()) {
          line = scan.nextLine();
          String[] tokens = line.split(",");
          String item;
          for (int i = 0; i < tokens.length; i++) {
            item = tokens[i];
            System.out.print("|");
            System.out.printf("%s\t ", item);
          }
          System.out.println("|");
        }

        System.out.println("└────────────────┴───────┴───────┘");

        fis.close();
        scan.close();
      }

      {
        if (menu == 1) {
          System.out.println(menu);
        } else if (menu == 2) {
          System.out.println("음료추가 메뉴 선택");
        } else if (menu == 3) {
          System.out.println("Bye~");
          return;
        }
      }
    }
  }
}
