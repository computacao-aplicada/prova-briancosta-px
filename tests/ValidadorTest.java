import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Faz as validações do CPF
//Os testes estão separados de acordo com o checklist de entrega
//Descrições dos testes estão nos nomes de cada metodo
public class ValidadorTest {
    @Test
    //Com máscara
    void deveValidarCPFValidoComMascara() {
        assertTrue(Validador.validarCPF("529.982.247-25"));
    }

    //Sem máscara
    @Test
    void deveValidarCPFValidoSemMascara() {
        assertTrue(Validador.validarCPF("52998224725"));
    }

    //Valor nulo
    @Test
    void deveRejeitarEntradasInvalidasNull() {
        assertFalse(Validador.validarCPF(null));
    }

    //Sem valor
    @Test
    void deveRejeitarEntradasInvalidasSemValor() {
        assertFalse(Validador.validarCPF(""));
    }

    //DV com máscara
    @Test
    void deveRejeitarEntradasInvalidasComMascara() {
        assertFalse(Validador.validarCPF("529.982.247-2X"));
    }

    //Apenas "zero"
    @Test
    void deveRejeitarEntradasInvalidasComZero() {
        assertFalse(Validador.validarCPF("00000000000"));
    }

    //Apenas "um"
    @Test
    void deveRejeitarEntradasInvalidasComUm() {
        assertFalse(Validador.validarCPF("11111111111"));
    }

    //Verifica os tamanhos dos CPF
    @Test
    void deveRejeitarTamanhosIncorretos() {
        assertFalse(Validador.validarCPF("935.411.347-8"));   // 10 dígitos
        assertFalse(Validador.validarCPF("935.411.347-800")); // 12 dígitos
    }

    //Verifica o DV incorreto
    @Test
    void deveRejeitarDVIncorretoDezDigitos() {
        assertFalse(Validador.validarCPF("529.982.247-24"));
    }

    //Verifica DV do CPF com doze dígitos
    @Test
    void deveRejeitarDVIncorretoDozeDigitos() {
            assertFalse(Validador.validarCPF("123.456.789-00"));
    }
}
