package br.com.drink.exceptions.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.drink.exception.NotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroComum> Validation(MethodArgumentNotValidException exception) {
		List<ErroComum> erro = new ArrayList<>();
		
		List<FieldError> campoErro = exception.getBindingResult().getFieldErrors();
		
		campoErro.forEach(e -> {
			
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());

			erro.add(new ErroComum(e.getField(), mensagem));
		});
		return erro;
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErroComum threatNotFoundException(NotFoundException ex) {
		return ErroComum.builder()
					.message(ex.getMessage())
					.code(String.valueOf(HttpStatus.NOT_FOUND.value()))
					.build();
	}
}
