package br.com.attornatus.peoples.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.attornatus.peoples.repository.EnderecoRepository;

public class ValidaEnderecoPrimario implements ConstraintValidator<PrimaryAddress, Boolean> {
	
	    @Autowired
	    private EnderecoRepository enderecoRepository;

	    @Override
	    public boolean isValid(Boolean isPrimary, ConstraintValidatorContext context) {
	        if (!isPrimary) {
	            return true;
	        }
	        Endereco primaryAddress = enderecoRepository.findByEnderecoPrimario(true);
	        if (primaryAddress != null) {
	            context.buildConstraintViolationWithTemplate("Somente um endereço pode ser primário!")
	                .addConstraintViolation();
	            return false;
	        }
	        return true;
	    }
	}