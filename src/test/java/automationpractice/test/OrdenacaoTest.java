package automationpractice.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static automationpractice.factory.selenium.Interactions.*;
import static automationpractice.page.WomenPage.*;
import static org.junit.Assert.assertTrue;
import static storys.OrdenacaoStory.*;

@Epic(EPIC_ORDENACAO)
@Story(USER_STORY_ORDENACAO)
public class OrdenacaoTest extends BaseTest{

    @Test
    @Description(CT_ORDENACAO_01)
    public void testOrdenarProdutosPorMenorPreco(){
        /*CT001: Ordenar os produtos pelo menor preço
        DADO que estou na página inicial
        E clico no botão "Women"
        QUANDO preencho o campo "Sort by" com a opção "Price: Lowest first"
        ENTÃO o preço do primeiro produto exibido deve ser menor ou igual ao preço do segundo produto exibido
         */
        clicar(btnWomen);

        selectPorIndex(selectSortBy, 1);

        Double precoProduto1 = Double.valueOf(lerTexto(priceFirstProduct).replace("$", ""));
        Double precoProduto2 = Double.valueOf(lerTexto(priceSecondProduct).replace("$", ""));

        assertTrue(precoProduto1 < precoProduto2);
    }

    @Test
    @Description(CT_ORDENACAO_02)
    public void testOrdenarProdutosPorMaiorPreco(){
        /*CT002: Ordenar os produtos pelo maior preço
        DADO que estou na página inicial
        E clico no botão "Women"
        QUANDO preencho o campo "Sort by" com a opção "Price: Highest first"
        ENTÃO o preço do primeiro produto exibido deve ser maior ou igual ao preço do segundo produto exibido
         */
        clicar(btnWomen);

        selectPorIndex(selectSortBy, 2);

        Double precoProduto1 = Double.valueOf(lerTexto(priceFirstProduct).replace("$", ""));
        Double precoProduto2 = Double.valueOf(lerTexto(priceSecondProduct).replace("$", ""));

        assertTrue(precoProduto1 > precoProduto2);
    }

}
