package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.ComponentePojo;
import pojo.ProdutoPojo;
import pojo.UsuarioPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo de Produto")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeEach(){
        // Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        // port = 8080
        basePath = "/lojinha-bugada";
        // Obter o token do usuario admin


        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioAdministrador())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");

    }


    @Test
    @DisplayName("Validar que o valor d produtor igual a 00 nao é permitido")
    public void testValidarLimitesZeradoProibidoValorProduto(){



        System.out.println(token);

       // Tentar inserir um produto com vlor 0.00 e validar que a mensagem de errofoi apesentada e o
       // status code retornado 422



        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComumComValorIgualA(0.00))
                .when()
                    .post("/v2/produtos")
                .then()
                    .assertThat()
                        .body("error",equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);


    }

    @Test
    @DisplayName("Validar que valro do produto igual a 7001 nao é permitido")
    public void testValidarLimitesMaiorQueSeteMilProibidoValorProduto(){



        System.out.println(token);

        // Tentar inserir um produto com vlor 7001.00 e validar que a mensagem de errofoi apesentada e o
        // status code retornado 422
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComumComValorIgualA(7001.00))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                    .body("error",equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);


    }



}
