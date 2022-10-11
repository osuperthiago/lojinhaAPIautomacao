package dataFactory;


import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdutoComumComValorIgualA(double valor) {

        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("jacare");
        produto.setProdutoValor(valor);

        List<String> cores = new ArrayList<>();
        cores.add("Vantablack");
        cores.add("tan");
        produto.setProdutoCores(cores);

        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("Pata");
        componente.setComponenteQuantidade(4);

        componentes.add(componente);

        ComponentePojo segundocomponente = new ComponentePojo();
        segundocomponente.setComponenteNome("Rabo");
        segundocomponente.setComponenteQuantidade(1);

        componentes.add(segundocomponente);


        produto.setComponentes(componentes);

        return produto;

    }
}
