import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckSumTest {
    @Test
    @DisplayName("Test sample checksum")
    void testCheckSum() {
        CheckSum checkSum = new CheckSum("4578423013769219");
        assertEquals( true, checkSum.doCheckSum());
    }
}