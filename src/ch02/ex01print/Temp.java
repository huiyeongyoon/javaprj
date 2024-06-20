package ch02.ex01print;

public class Temp {
  public static void main(String[] args) {
    int kor1;
    int kor2;
    int kor3;
    int total;
    double avg;

    kor1 = 30;
    kor2 = 40;
    kor3 = 100;

    total = kor1 + kor2 + kor3;
    avg = total / 3.0;

    System.out.println("┌───────────────────────────────┐");
    System.out.println("│            성적출력           │");
    System.out.println("└───────────────────────────────┘");

    System.out.println("kor1 : " + kor1);
    System.out.println("kor2 : " + kor2);
    System.out.println("kor3 : " + kor3);
    System.out.println("total : " + total);
    System.out.printf("avg: %.2f", avg);

    String view = """
        ┌───────────────────────────────┐
        │            성적출력           │
        └───────────────────────────────┘


        kor1 : %d
        kor2 : %d
        kor3 : %d
        total : %d
        avg : %.2f
        """;

    System.out.println();
    System.out.printf(view, kor1, kor2, kor3, total, avg);
    System.out.println();
  }
}
