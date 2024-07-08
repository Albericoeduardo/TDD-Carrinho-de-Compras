package Tests;

import static org.junit.Assert.assertEquals;


public class MockObservadorCarrinho implements ObservadorCarrinho{

    private String nomeRecebido;
    private int valorRecebido;
    private boolean bug = false;

    @Override
    public void produtoAdicionado(String nome, int valor) {
        if (bug) {
            throw new RuntimeException("Mock bug Ejector");
        }
        this.nomeRecebido = nome;
        this.valorRecebido = valor;
    }

    public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado) {
        assertEquals(nomeEsperado, nomeRecebido);
        assertEquals(valorEsperado, valorRecebido);
    }

    public void bugEjector() {
        bug = true;
    }

}
