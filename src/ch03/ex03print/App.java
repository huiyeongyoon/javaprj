package ch03.ex03print;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {

    String line;
    int menu;
    boolean flag = true;
    System.out.println("""
        ┌───────────────────────────────┐
        │            성적관리           │
        └───────────────────────────────┘

        1. 목록보기
        2. 성적추가
        3. 성적로드
        4. 성적저장
        5. 종료
            """);

    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine().trim();

    while (flag) {
      if (isNumeric(input)) {
        menu = Integer.parseInt(input);
      } else {
        menu = 0;
      }

      switch (menu) {
        // 목록보기
        case 1: {
          System.out.println("목록보기");
        }

        // 성적추가
        case 2: {
          System.out.println("성적추가");
        }

        // 성적로드
        case 3: {
          System.out.println("성적로드");
        }

        // 성적저장
        case 4: {
          System.out.println("성적저장");
        }

        // 종료
        case 5: {
          System.out.println("종료");
        }

        default: {
          System.out.println("예외");
          break;
        }
      }

      if (menu == 1) {

      } else if (menu == 2) {

      } else if (menu == 3) {
        System.out.println("┌───────────────────────┐");
        System.out.println("│       성적 출력       │");
        System.out.println("└───────────────────────┘");

        FileInputStream fis = new FileInputStream("res/data.csv");
        Scanner scan2 = new Scanner(fis);

        String[] name = scan2.nextLine().split(",");

        for (int i = 0; i < name.length; i++) {
          System.out.printf("%s\t", name[i]);
        }

        while (scan2.hasNextLine()) {
          line = scan.nextLine();

          String[] tokens = line.split(",");
          String userName = tokens[0];
          int subject;
          int total = 0;
          double svg;
          String grade = "F";
          System.out.println();

          for (int i = 0; i < name.length - 3; i++) {

            if (i == 0) {
              System.out.printf("%s\t", userName);
            }

            subject = !isNumeric(tokens[i]) ? 0 : Integer.parseInt(tokens[i]);
            subject = 0 <= subject && subject <= 100 ? subject : 0;
            total += subject;

            if (total != 0)
              System.out.printf("%d\t", subject);
          }

          svg = total / 3;

          if (svg >= 90) {
            grade = "A";
          } else if (svg >= 80) {
            grade = "B";
          } else if (svg >= 70) {
            grade = "C";
          } else if (svg >= 60) {
            grade = "D";
          } else {
            grade = "F";
          }

          System.out.printf("%d\t %.2f\t %s", total, svg, grade);
        }

        scan2.close();
        fis.close();
      } else if (menu == 4) {

      } else if (menu == 5) {
        flag = false;
      } else {
        System.out.println("1~5만 넣어주세요");
        flag = true;
      }
    }
  }

  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}