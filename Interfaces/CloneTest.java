class Prototype implements Cloneable {
    String name = "Original";
    public Object clone() throws CloneNotSupportedException { return super.clone(); }
}
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype) p1.clone();
        System.out.println(p2.name);
    }
}
