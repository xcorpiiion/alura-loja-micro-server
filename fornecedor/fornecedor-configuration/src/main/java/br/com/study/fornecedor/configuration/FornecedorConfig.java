package br.com.study.fornecedor.configuration;

import br.com.study.fornecedor.model.Info;
import br.com.study.fornecedor.model.Produto;
import br.com.study.fornecedor.repository.InfoRepository;
import br.com.study.fornecedor.repository.ProdutoRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;

@Configuration
public class FornecedorConfig {

    @Getter
    @Autowired
    private ProdutoRepository produtoRepository;

    @Getter
    @Autowired
    private InfoRepository infoRepository;

    @Bean
    public void cadastroFornecedor() {
        Info info = new Info();
        info.setId(1L);
        info.setNome("Fornecedor - DF");
        info.setEstado("DF");
        info.setEndereco("DF fornecedor endereço");
        this.getInfoRepository().save(info);
    }

    @Bean
    public void cadastroProduto() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setDescricao("Rosas");
        produto.setEstado("DF");
        produto.setNome("Rosas");
        produto.setPreco(valueOf(10.99));

        Produto produto2 = new Produto();
        produto2.setId(1L);
        produto2.setDescricao("Orquidia");
        produto2.setEstado("DF");
        produto2.setNome("Orquidia");
        produto2.setPreco(valueOf(1.99));

        Produto produto3 = new Produto();
        produto3.setId(1L);
        produto3.setDescricao("Girassol");
        produto3.setEstado("DF");
        produto3.setNome("Girassol");
        produto3.setPreco(valueOf(6.99));

        this.getProdutoRepository().saveAll(asList(produto, produto2, produto3));
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
