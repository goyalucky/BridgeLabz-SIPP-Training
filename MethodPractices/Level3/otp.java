import java.util.Arrays;

public class otp {

    public static int generateOTP() {
        return (int)(100000 + Math.random() * 900000);  
    }

    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 1; i < otps.length; i++) {
            if (otps[i] != otps[0]) {
                return true;  
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        
        System.out.println("Generated OTPs: " + Arrays.toString(otps));

        
        if (areOTPsUnique(otps)) {
            System.out.println("OTP numbers are unique.");
        } else {
            System.out.println("OTP numbers are NOT unique (all are the same).");
        }
    }
}
