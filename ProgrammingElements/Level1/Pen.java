public class Pen {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        int pens = totalPens / students;
        int Pens = totalPens % students;
        System.out.println("The Pen Per Student is " + pens + " and the remaining pen not distributed is " + Pens);
    }
}


