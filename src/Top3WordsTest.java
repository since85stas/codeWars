import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Top3WordsTest {

    @Test
    public void test01() {
        assertEquals(Arrays.asList("won't", "wont"),  Top3Words.top3("  //wont won't won't "));
    }

    @Test
    public void test02() {
        assertEquals(Arrays.asList(),  Top3Words.top3("  ...  "));
    }

    @Test
    public void test03() {
        assertEquals(Arrays.asList("as'",""),  Top3Words.top3("  l'' as' as sa ' / as'"));
    }

}