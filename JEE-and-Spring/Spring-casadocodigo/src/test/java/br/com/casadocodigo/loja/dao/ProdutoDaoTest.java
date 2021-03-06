package br.com.casadocodigo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class, ProdutoDao.class, DataSourceConfigurationTest.class })
@ActiveProfiles("test")
public class ProdutoDaoTest {

    @Autowired
    private ProdutoDao produtoDao;

	@Test
    @Transactional
	public void deveSomarTodosPrecosPorTipoLivro(){
		List<Produto> livrosImpressos = ProdutoBuilder
				.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(3).buildAll();
		
		List<Produto> livrosEbook = ProdutoBuilder
				.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(3).buildAll();
		
		livrosImpressos.stream().forEach(produtoDao::gravar);
	    livrosEbook.stream().forEach(produtoDao::gravar);
		
	    BigDecimal valor = produtoDao.somaPrecosPorTipo(TipoPreco.EBOOK);	    
	    //Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
	    Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
	}

}
