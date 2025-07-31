import java.io.*;

public class FileCopyComparison {
    public static void main(String[] args) throws IOException {
        String sourceFile = "source.dat";
        String destBuffered = "dest_buffered.dat";
        String destUnbuffered = "dest_unbuffered.dat";

        long start, end;

        start = System.nanoTime();
        copyUsingBufferedStreams(sourceFile, destBuffered);
        end = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        end = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (end - start) / 1_000_000 + " ms");
    }

    static void copyUsingBufferedStreams(String source, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();
    }

    static void copyUsingUnbufferedStreams(String source, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis.close();
        fos.close();
    }
}
