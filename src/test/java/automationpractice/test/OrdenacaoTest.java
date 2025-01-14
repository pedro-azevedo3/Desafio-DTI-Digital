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

        clicar(btnWomen);

        selectPorIndex(selectSortBy, 1);

        Double precoProduto1 = Double.valueOf(lerTexto(priceFirstProduct).replace("$", ""));
        Double precoProduto2 = Double.valueOf(lerTexto(priceSecondProduct).replace("$", ""));

        assertTrue(precoProduto1 < precoProduto2);
    }

    @Test
    @Description(CT_ORDENACAO_02)
    public void testOrdenarProdutosPorMaiorPreco(){

        clicar(btnWomen);

        selectPorIndex(selectSortBy, 2);

        Double precoProduto1 = Double.valueOf(lerTexto(priceFirstProduct).replace("$", ""));
        Double precoProduto2 = Double.valueOf(lerTexto(priceSecondProduct).replace("$", ""));

        assertTrue(precoProduto1 > precoProduto2);
    }

}
