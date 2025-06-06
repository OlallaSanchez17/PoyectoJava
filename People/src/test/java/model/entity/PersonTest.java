package model.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.ImageIcon;
import java.util.Date;
import model.entity.Person;

class PersonTest {

    private Person person;
    private Person personWithFullData;
    private String nif = "12345678X";
    private String name = "John Doe";
    private String phone = "888888888";
    private String postalCode = "111111111";
    private Date dateOfBirth = new Date();
    private ImageIcon photo = new ImageIcon();
    private String email = "person1@gmail.com";

    @BeforeEach
    void setUp() {
        person = new Person(nif);
        personWithFullData = new Person(nif, name, phone, postalCode,email, dateOfBirth, photo);
    }

    @Test
    void testConstructorNifOnly() {
        assertEquals(nif, person.getNif());
        assertNull(person.getName());
        assertNull(person.getPhone());
        assertNull(person.getPostalCode());
        assertNull(person.getDateOfBirth());
        assertNull(person.getPhoto());
            assertNull(person.getEmail());
    }

    @Test
    void testConstructorNameAndNif() {
        Person personWithNameAndNif = new Person(nif, name, phone,postalCode, email);
        assertEquals(nif, personWithNameAndNif.getNif());
        assertEquals(name, personWithNameAndNif.getName());
        assertEquals(phone, personWithNameAndNif.getPhone());
         assertEquals(postalCode, personWithNameAndNif.getPostalCode());
        assertEquals(email, personWithNameAndNif.getEmail());

    }

    @Test
    void testConstructorFullData() {
        assertEquals(nif, personWithFullData.getNif());
        assertEquals(name, personWithFullData.getName());
        assertEquals(phone, personWithFullData.getPhone());
        assertEquals(postalCode, personWithFullData.getPostalCode());
        assertEquals(dateOfBirth, personWithFullData.getDateOfBirth());
        assertEquals(photo, personWithFullData.getPhoto());
          assertEquals(email, personWithFullData.getEmail());
    }

    @Test
    void testGettersAndSetters() {
        person.setName("Jane Doe");
        assertEquals("Jane Doe", person.getName());
        
        person.setPhone("888888888");
        assertEquals("888888888", person.getPhone());
        
        person.setPostalCode("999999999");
        assertEquals("999999999", person.getPostalCode());

         person.setEmail("person1@gmail.com");
        assertEquals("person1@gmail.com", person.getEmail());
        
        Date newDateOfBirth = new Date(0);
        person.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, person.getDateOfBirth());

        ImageIcon newPhoto = new ImageIcon("path/to/photo.jpg");
        person.setPhoto(newPhoto);
        assertEquals(newPhoto, person.getPhoto());

        byte[] photoBytes = new byte[]{1, 2, 3};
        person.setPhotoOnlyJPA(photoBytes);
        assertArrayEquals(photoBytes, person.getPhotoOnlyJPA());
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(person.equals(person));
    }

    @Test
    void testEqualsDifferentObject() {
        Person anotherPerson = new Person(nif);
        assertTrue(person.equals(anotherPerson));

        Person differentPerson = new Person("98765432Z");
        assertFalse(person.equals(differentPerson));
    }

    @Test
    void testEqualsNullAndDifferentClass() {
        assertFalse(person.equals(null));
        assertFalse(person.equals("not a Person"));
    }

    @Test
    void testHashCode() {
        Person anotherPerson = new Person(nif);
        assertEquals(person.hashCode(), anotherPerson.hashCode());

        Person differentPerson = new Person("98765432Z");
        assertNotEquals(person.hashCode(), differentPerson.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Person {NIF = " + nif + ", Name = " + name + ", Phone = " + phone + ", PostalCode = " + postalCode + ", Email = " + email + ", DateOfBirth = " + dateOfBirth + ", Photo = true}";
        assertEquals(expected, personWithFullData.toString());
    }
}
