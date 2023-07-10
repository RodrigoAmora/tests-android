package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProdutoTest {

    @Test
    fun deveRetornarVerdadeiroQuandoOValorForValido() {
        val produtoValido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("7.55")
        )

        val valorEhValido = produtoValido.valorValido

        Assert.assertTrue(valorEhValido)
    }

    @Test
    fun deveRetornarFalsoQuandoOValorForNegativo() {
        val produtoInvalido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("-3.50")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertFalse(valorEhValido)
    }

    @Test
    fun deveRetornarFalsoQuandoOValorForMaiorQueCem() {
        val produtoInvalido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("777.99")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertFalse(valorEhValido)
    }

    @Test
    fun deveRetornarFalsoQuandoOValorForIgualZero() {
        val produtoInvalido = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("0.0")
        )

        val valorEhValido = produtoInvalido.valorValido

        Assert.assertFalse(valorEhValido)
    }
}