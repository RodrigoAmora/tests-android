package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Before
import org.junit.Test

class ProdutoActivityTest {

    @Before
    fun preparaAmbiente() {
        AppDatabase.instancia(InstrumentationRegistry.getInstrumentation().targetContext).clearAllTables()
    }

    @Test
    fun deveMostrarONomeDoAplicativo() {
        ActivityScenario.launch(ListaProdutosActivity::class.java)
        Espresso
            .onView(ViewMatchers.withText("Orgs"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun deveMostrarCamposNecessariosParaCriarUmProduto() {
        ActivityScenario.launch(FormularioProdutoActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome)).check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()))
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao)).check(
                ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor)).check(
                ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_botao_salvar)).check(
                ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun deveSerCapazDePrencherOsCamposESalvar(){
        ActivityScenario.launch(FormularioProdutoActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_nome))
            .perform(
                ViewActions.typeText("Laranja"),
                ViewActions.closeSoftKeyboard()
            )

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_descricao))
            .perform(
                ViewActions.typeText("Laranja Lima"),
                ViewActions.closeSoftKeyboard())

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_valor))
            .perform(
                ViewActions.typeText("6.99"),
                ViewActions.closeSoftKeyboard())

        Espresso
            .onView(ViewMatchers.withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(ViewActions.click())

        ActivityScenario.launch(ListaProdutosActivity::class.java)
        Espresso
            .onView(ViewMatchers.withText("Laranja"))
    }
}