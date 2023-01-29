package br.univali.campo.minado.model;

import br.univali.campo.minado.exception.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {

    private Campo campo;
    static List<Campo> vizinhos = new ArrayList<>();

    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3,3);
    }

    @Test
    void adicionarVizinho() {
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void adicionarVizinho2(){
        Campo vizinho2 = new Campo(4,4);
        assertTrue(campo.adicionarVizinho(vizinho2));
    }

    @Test
    void adicionarVizinhoErrado(){
        Campo vizinhoErrado = new Campo(5,5);
        assertFalse(campo.adicionarVizinho(vizinhoErrado));
    }

    @Test
    void marcacaoT(){
        assertTrue(campo.alterarMarcacao());
    }

    @Test
    void marcacaoF(){
        campo.abrir();
        assertFalse(campo.alterarMarcacao());
    }

    @Test
    void lose(){
        Campo mina = new Campo(3,4);
        mina.minar();
        assertThrows(ExplosaoException.class,() ->{
            mina.abrir();
        });
    }

    @Test
    void naoAbrir(){
        Campo naoAbrir = new Campo(4,4);
        naoAbrir.abrir();
        assertFalse(naoAbrir.abrir());
    }

    @Test
    void isAberto(){
        campo.abrir();
        assertTrue(campo.isAberto());
    }

    @Test
    void isFechado(){
        assertTrue(campo.isFechado());
    }

    @Test
    void isMarcado(){
        campo.alterarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void isNaoMarcado(){
        assertTrue(campo.isFechado());
    }

    @Test
    void getLinha(){
        assertEquals(3,campo.getLinha());
    }

    @Test
    void getColuna(){
        assertEquals(3,campo.getColuna());
    }

    @Test
    void objetivo(){
        campo.abrir();
        assertTrue(campo.objetivoAlcancado());
    }

    @Test
    void objetivo2(){
        campo.minar();
        campo.alterarMarcacao();
        assertTrue(campo.objetivoAlcancado());
    }

    @Test
    void reiniciar1(){
        campo.reiniciar();
        assertFalse(campo.isAberto());
    }

    @Test
    void reiniciar2(){
        campo.reiniciar();
        assertFalse(campo.isMarcado());
    }

    @Test
    void reiniciar3(){
        campo.reiniciar();
        assertFalse(campo.isMarcado());
    }

    @Test
    void marca1(){
        campo.alterarMarcacao();
        assertEquals("X",campo.toString());
    }

    @Test
    void marca2(){
        campo.abrir();
        campo.minar();
        assertEquals("*",campo.toString());
    }

    @Test
    void marca4(){
        campo.abrir();
        assertEquals(" ",campo.toString());
    }

    @Test
    void marca5(){
        assertEquals("?",campo.toString());
    }
}