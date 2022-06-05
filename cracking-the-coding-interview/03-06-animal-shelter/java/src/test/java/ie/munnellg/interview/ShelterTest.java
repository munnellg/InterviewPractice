package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ShelterTest {

    @Test
    public void test() {
        Shelter shelter = new Shelter();
        shelter.enqueue(new Shelter.Dog("Jumjum"));
        shelter.enqueue(new Shelter.Cat("Negamunchie"));
        shelter.enqueue(new Shelter.Dog("Ganon the Destroyer"));
        shelter.enqueue(new Shelter.Dog("Bigglesworth"));
        shelter.enqueue(new Shelter.Cat("Mr. Fuzzybuns"));

        assertEquals("Negamunchie", shelter.dequeueCat().name);
        assertEquals("Jumjum", shelter.dequeueDog().name);
        assertEquals("Mr. Fuzzybuns", shelter.dequeueCat().name);
        assertEquals("Ganon the Destroyer", shelter.dequeueAny().name);
        assertEquals("Bigglesworth", shelter.dequeueAny().name);
        assertNull(shelter.dequeueAny());
        assertNull(shelter.dequeueDog());
        assertNull(shelter.dequeueCat());
    }
}
