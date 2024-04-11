package com.fredson.datastructures.datakey;

import com.fredson.datastructures.datakey.models.Course;
import com.fredson.datastructures.datakey.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DataStoreTest {

    private Course cienciaComputacao;

    private Course medicina;

    private Student anaLuiza;

    private Student maria;

    private Student joana;

    @BeforeEach()
    void init() {
        cienciaComputacao = new Course("Ciência da Computação", "Computing");
        medicina = new Course("Medicina", "Health");
        anaLuiza = new Student("Ana Luiza", cienciaComputacao);
        maria = new Student("Maria", cienciaComputacao);
        joana = new Student("Joana", medicina);
    }

    @Test
    public void shouldCreatedDataStore() {
        DataKey dataStore = new DataStore("scholla-database");
        String expected = "{Database: scholla-database, Keys: [Student, Course], Size: 2}";
        dataStore.put(anaLuiza);
        dataStore.put(maria);
        dataStore.put(joana);
        dataStore.put(medicina);
        dataStore.put(cienciaComputacao);
        assertEquals("scholla-database", dataStore.getDatabaseName());
        assertEquals(2, dataStore.getKeys().length());
        assertEquals(3, dataStore.getValues("Student").length());
        assertEquals(2, dataStore.getValues("Course").length());
        assertEquals(anaLuiza, dataStore.get(anaLuiza.id()));
        assertEquals(maria, dataStore.get(maria.id()));
        assertEquals(joana, dataStore.get(joana.id()));
        assertEquals(medicina, dataStore.get(medicina.id()));
        assertEquals(cienciaComputacao, dataStore.get(cienciaComputacao.id()));
        assertEquals(expected, dataStore.toString());
    }

    @Test
    public void shouldCreateKeysInDataStore() {
        DataKey dataStore = new DataStore("scholla-database");
        String expected = "{Database: scholla-database, Keys: [Student, Course], Size: 2}";
        dataStore.createKey("Student");
        dataStore.createKey("Course");
        assertEquals(2, dataStore.getKeys().length());
        assertEquals(expected, dataStore.toString());
    }

    @Test
    public void shouldGetIdentifierValue() {
        DataKey dataStore = new DataStore("scholla-database");
        dataStore.put(anaLuiza);
        dataStore.put(maria);
        dataStore.put(joana);
        dataStore.put(medicina);
        dataStore.put(cienciaComputacao);
        assertEquals(anaLuiza.id(), dataStore.identifier(anaLuiza));
        assertEquals(maria.id(), dataStore.identifier(maria));
        assertEquals(joana.id(), dataStore.identifier(joana));
        assertEquals(medicina.id(), dataStore.identifier(medicina));
        assertEquals(cienciaComputacao.id(), dataStore.identifier(cienciaComputacao));
    }

    @Test
    public void shouldUpdateValueInDataStore() {
        DataKey dataStore = new DataStore("scholla-database");
        String nomeAlterado = "Ana Luiza Alterado";
        dataStore.put(anaLuiza);
        dataStore.put(maria);
        dataStore.put(joana);
        dataStore.put(medicina);
        dataStore.put(cienciaComputacao);
        anaLuiza.setCourse(medicina);
        anaLuiza.setName(nomeAlterado);
        Student entity = (Student) dataStore.get(anaLuiza.id());
        assertEquals(nomeAlterado, entity.getName());
        assertEquals(medicina, entity.getCourse());
    }

    @Test
    public void shouldRemoveValueInDataStore() {
        DataKey dataStore = new DataStore("scholla-database");
        dataStore.put(anaLuiza);
        dataStore.put(maria);
        dataStore.put(joana);
        dataStore.put(medicina);
        dataStore.put(cienciaComputacao);
        dataStore.remove(maria);
        assertNull(dataStore.get(maria));
        assertEquals(2, dataStore.getValues("Student").length());
    }

    @Test
    public void shouldReplaceDataStore() {
        DataKey dataStore = new DataStore("scholla-database");
        Student newStudent = new Student("Alterado", cienciaComputacao);
        dataStore.put(anaLuiza);
        dataStore.put(maria);
        dataStore.put(joana);
        dataStore.put(medicina);
        dataStore.put(cienciaComputacao);
        dataStore.put(maria, newStudent);
        assertNull(dataStore.get(maria));
        assertEquals(newStudent, dataStore.get(newStudent));
        assertEquals(3, dataStore.getValues("Student").length());
    }

    @Test
    public void shouldRemoveKey() {
        DataKey dataStore = new DataStore("scholla-database");
        String expected = "{Database: scholla-database, Keys: [Student], Size: 1}";
        dataStore.put(anaLuiza);
        dataStore.put(maria);
        dataStore.put(joana);
        dataStore.put(medicina);
        dataStore.put(cienciaComputacao);
        dataStore.removeKey("Course");
        assertEquals(1, dataStore.getKeys().length());
        assertTrue(dataStore.getValues("Course").isEmpty());
        assertNull(dataStore.get(medicina.id()));
        assertNull(dataStore.get(cienciaComputacao.id()));
        assertEquals(expected, dataStore.toString());
    }
}
