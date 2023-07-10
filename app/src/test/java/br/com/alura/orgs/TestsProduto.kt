package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class TestsProduto {

    @Test
    fun aoCriarUmProdutoComValorCertoOValorDeveriaSerValido() {
        val produtoValido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("7.55")
        )

        val valorEhValido = produtoValido.valorValido

        Assert.assertTrue(valorEhValido)
    }

    @Test
    fun aoCriarUmProdutoComValorErradoOValorDeveriaSerInvalido() {
        val produtoInvalido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("-3.50")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertFalse(valorEhValido)
    }

    @Test
    fun aoCriarUmProdutoComValorMaiorQueCemReaisDeveDarErro() {
        val produtoInvalido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("777.99")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertFalse(valorEhValido)
    }

    @Test
    fun aoCriarUmProdutoComValorIgualZero() {
        val produtoInvalido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("0.0")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertFalse(valorEhValido)
    }
}