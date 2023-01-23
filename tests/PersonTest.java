import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person P1;

    @BeforeEach
    void setUp() {
        P1 = new Person("Chase", "Staggs", "000001", "Mr.", 2001);
    }

    @Test
    void setFirstName() {
        P1.setFirstName("Charles");
        assertEquals("Charles", P1.getFirstName());
    }

    @Test
    void setLastName() {
        P1.setLastName("Stagg");
        assertEquals("Stagg", P1.getLastName());
    }

    @Test
    void setID() {
        P1.setID("000002");
        assertEquals("000002", P1.getID());
    }

    @Test
    void setTitle() {
        P1.setTitle("Mr.");
        assertEquals("Mr.", P1.getTitle());
    }

    @Test
    void setYOB() {
        P1.setYOB(2000);
        assertEquals(2000, P1.getYOB());
    }

    @Test
    void fullName() {
        P1.setFirstName("Charles");
        P1.setLastName("Stagg");
        assertEquals("Charles Stagg", P1.fullName());
    }

    @Test
    void formalName() {
        P1.setFirstName("Charles");
        P1.setLastName("Stagg");
        P1.setTitle("Mr.");
        assertEquals("Mr. Charles Stagg", P1.formalName());
    }

    @Test
    void getAge() {
        P1.setYOB(2000);
        assertEquals("23", P1.getAge());
    }

    @Test
    void testGetAge() {
        P1.setYOB(2000);
        assertEquals("23", P1.getAge());
    }

    @Test
    void toCSVDataRecord() {
        P1.setFirstName("Charles");
        P1.setLastName("Stagg");
        P1.setID("000002");
        P1.setTitle("Mr.");
        P1.setYOB(2000);
        assertEquals("000002, Charles, Stagg, Mr., 2000", P1.toCSVDataRecord());
    }
}