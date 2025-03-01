import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testFile1() throws IOException{
        String contents = Files.readString(Path.of("./test-file-1.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile2() throws IOException{
        String contents = Files.readString(Path.of("./test-file-2.md"));
        List<String> expect = List.of("thisisalink.com", "thisisanotherlink.org");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile3() throws IOException{
        String contents = Files.readString(Path.of("./test-file-3.md"));
        List<String> expect = List.of("link[1].com", "link[].org");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}