package ch03.ex03print;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {

    String line;
    int menu;
    boolean flag = true;

    // continue 다음 반복문으로 밑에꺼 실행안함
    // break 라벨 오류 잡을떄만 사용합니다^^;
    EXIT_LOOP: while (flag) {

      clear();
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
      {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();

        if (isNumeric(input)) {
          menu = Integer.parseInt(input);
        } else {
          menu = 0;
        }
      }

      {
        Scanner scan = new Scanner(System.in);
        switch (menu) {
          // 목록보기
          case 1: {
            clear();
            System.out.println("목록보기화면");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("plz press any key to continue");
            scan.nextLine();
            break;
          }

          // 성적추가
          case 2: {
            clear();
            System.out.println("성적추가화면");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("plz press any key to continue");
            scan.nextLine();
            break;
          }
          // 검색
          // 페이지 현재페이지
          // 상위메뉴
          // 성적로드
          case 3: {
            clear();
            System.out.println("성적로드화면");
            System.out.println("┌───────────────────────┐");
            System.out.println("│       성적 출력       │");
            System.out.println("└───────────────────────┘");

            FileInputStream fis = new FileInputStream("res/data.csv");
            Scanner scan2 = new Scanner(fis);

            String[] name = scan2.nextLine().split(",");

            for (int i = 0; i < name.length; i++) {
              System.out.printf("%s\t", name[i]);
            }

            // int studentNum = 0;
            // while (scan2.hasNextLine()) {
            // if (scan2.nextLine().equals("")) {
            // } else {
            // studentNum += 1;
            // }
            // }
            // System.out.println(studentNum);
            int page = 0;
            int userInput;

            userInput = Integer.parseInt(scan.nextLine());
            for (int count = 0; scan2.hasNextLine() && count < userInput; count++) {
              line = scan2.nextLine();

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
                  continue;
                }

                subject = !isNumeric(tokens[i]) ? 0 : Integer.parseInt(tokens[i]);
                subject = 0 <= subject && subject <= 100 ? subject : 0;
                total += subject;

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
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("상위메뉴로 가려면 1 메인메뉴로 가려면 아무키를 입력하세요");
            userInput = Integer.parseInt(scan.nextLine());

            if (userInput == 1) {
              System.out.println("상위메뉴로 이동");
              break;

            } else {

              break;
            }
          }

          // 성적저장
          case 4: {
            clear();
            System.out.println("성적저장화면");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("plz press any key to continue");
            scan.nextLine();
            break;
          }

          // 종료
          case 5: {
            System.out.println("종료");
            flag = false;
            break EXIT_LOOP;
          }

          default: {
            System.out.println("1~5만 넣어주세요");
            System.out.println("예외");
            break;
          }
        }
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

  public static void clear() {
    try {
      String operatingSystem = System.getProperty("os.name");
      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}