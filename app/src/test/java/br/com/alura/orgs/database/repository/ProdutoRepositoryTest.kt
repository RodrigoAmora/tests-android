package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.math.BigDecimal

internal class ProdutoRepositoryTest {

    @Test
    fun deveChamaroDaoQuandoSalvaUmProduto() = runTest {
        // Arrange
        val dao = mockk<ProdutoDao>()
        val repository = ProdutoRepository(dao)

        val produto = Produto(
            nome = "Limão",
            descricao = "Limão Siciliano",
            valor = BigDecimal("7.55")
        )

        coEvery {
            dao.salva(produto)
        }.returns(Unit)

        // Act
        repository.salva(produto)

        coEvery {
            dao.salva(produto)
        }
    }
}