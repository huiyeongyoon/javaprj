package toy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Toy {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    String fileName = "res/data2.csv";

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

    FileOutputStream fos = new FileOutputStream(fileName);
    PrintStream fout = new PrintStream(fos, true, "utf-8");

    Scanner userInputScanner = new Scanner(System.in);

    String line = userInputScanner.nextLine();

    int menu = -1;

    ArrayList<String> subject = new ArrayList<>();
    ArrayList<String> score = new ArrayList<>();

    // while (flag) {
    menu = Integer.parseInt(line);
    switch (menu) {
      case 1: {
        break;
      }
      case 2: {
        System.out.println("과목을 입력해주세요");
        line = userInputScanner.nextLine();
        subject.add(line);
        fout.print(subject);

        System.out.println("점수를 입력해주세요");
        line = userInputScanner.nextLine();
        score.add(line);
        fout.print(score);
        break;
      }
      case 5: {
        System.out.println("종료");
        return;
      }
      default: {
        break;
      }
    }
    // }
  }
}
