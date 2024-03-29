package es.iessoterohernandez.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonaTest {

    private Persona persona;

    @BeforeEach
    void iniciar() {
    	persona = new Persona("Manuel", 21, 'H', 70, 1.79);
    }

    @AfterEach
    void finalizar() {
    	persona = null;
    }

    @Test
    void testPersonaCreada() {
    	assertThat(persona, notNullValue());
    }

    @Test
    void testMayorDeEdad() {
        assertTrue(persona.esMayorDeEdad());
    }

    @Test
    void testMenorDeEdad() {
    	persona.setEdad(15);
        assertFalse(persona.esMayorDeEdad());
    }

    @Test
    void testEdadPositiva() {
        assertDoesNotThrow(() -> persona.setEdad(48));
    }

    @Test
    void testEdadNegativa() {
        assertThrows(AssertionError.class, () -> persona.setEdad(-2));
    }

    @Test
    void testPesoIdeal() {
    	assertThat(persona.calcularIMC(), is(Persona.PESO_IDEAL));
    }
    
    @Test
    void testSobrepesoNuevoPeso() {
        persona.setPeso(100);
        assertThat(persona.calcularIMC(), is(Persona.SOBREPESO));
    }

    @Test
    void testSobrepesoNuevaAltura() {
        persona.setAltura(1.4);
        assertThat(persona.calcularIMC(), is(Persona.SOBREPESO));
    }

    @Test
    void testInfrapesoNuevaAltura() {
        persona.setAltura(2);
        assertThat(persona.calcularIMC(), is(Persona.INFRAPESO));
    }
    
    @Test
    void testInfrapesoNuevoPeso() {
        persona.setPeso(20);
        assertThat(persona.calcularIMC(), is(Persona.INFRAPESO));
    }



}
