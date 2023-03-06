package ittimfn.sample.juniversalchardet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilTest {
    @Test
    public void shiftjisFileTest() {
        try {
            Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "shiftjis.txt");
            System.out.println(path.toString());
            assertThat("SHIFT_JIS", is(Util.getCharset(path.toString())));
        } catch (IOException e) {
            fail(e);
        }
    }

    @Test
    public void utf9FileTest() {
        try {
            Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "utf8.txt");
            System.out.println(path.toString());
            assertThat("UTF-8", is(Util.getCharset(path.toString())));
        } catch (IOException e) {
            fail(e);
        }

    }
}
