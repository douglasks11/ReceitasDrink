package br.com.drink.exceptions.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DefaultMessage {
    @ApiModelProperty(notes = "Codigo de retorno", name = "Codigo", value = "200")
    private String code;
    @ApiModelProperty(notes = "Mensagem de retorno", name = "Mensagem", value = "Erro ao deletar")
    private String message;
    @ApiModelProperty(notes = "Objeto de retorno", name = "Objeto", value = "Generics")
    private Object objectGeneric;
}
