public class SmartHome {
    public static void main(String[] args) {
        Runnable motion = () -> System.out.println("Lights ON - Motion Pattern");
        Runnable time = () -> System.out.println("Lights ON - Evening Pattern");
        Runnable voice = () -> System.out.println("Lights ON - Voice Command");
        motion.run();
        time.run();
        voice.run();
    }
}
