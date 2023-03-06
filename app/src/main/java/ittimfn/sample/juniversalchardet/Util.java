package ittimfn.sample.juniversalchardet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

public class Util {
    
    public static String getCharset(String path) throws FileNotFoundException, IOException {
        UniversalDetector detector = new UniversalDetector(null);

        try(FileInputStream in = new FileInputStream(path)){
            byte[] buf = new byte[4096];
            int read;
            while((read = in.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, read);
            }
            detector.dataEnd();
        }
        return detector.getDetectedCharset();
    }

    private Util(){}
}
