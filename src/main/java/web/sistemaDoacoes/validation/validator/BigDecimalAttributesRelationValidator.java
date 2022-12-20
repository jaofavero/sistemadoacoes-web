package web.sistemaDoacoes.validation.validator;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import web.sistemaDoacoes.validation.BigDecimalAttributesRelation;
import web.sistemaDoacoes.validation.util.AttributesRelation;

public class BigDecimalAttributesRelationValidator implements ConstraintValidator<BigDecimalAttributesRelation, Object> {

	private String attribute1;
	private String attribute2;
	private AttributesRelation relation;

	@Override
	public void initialize(final BigDecimalAttributesRelation annotation) {
		attribute1 = annotation.attribute1();
		attribute2 = annotation.attribute2();
		relation = annotation.relation();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext ctx) {
		if (value == null) {
			return true;
		}
		Field field1, field2;
		try {
			field1 = value.getClass().getDeclaredField(attribute1);
			field2 = value.getClass().getDeclaredField(attribute2);
		} catch (final Exception ignore) {
			throw new RuntimeException("It was impossible to get the attributes from it's names");
		}
		if (field1.getType() != BigDecimal.class || field2.getType() != BigDecimal.class) {
			throw new IllegalArgumentException("Attributes should be of type BigDecimal");
		}
		field1.setAccessible(true);
		field2.setAccessible(true);

		BigDecimal value1, value2;
		try {
			value1 = (BigDecimal) field1.get(value);
			value2 = (BigDecimal) field2.get(value);
		} catch (final Exception ignore) {
			throw new RuntimeException("It was impossible to get attributes values");
		}

		String message = "";
		boolean valid = false;
		switch (relation) {
		case EQUAL:
			valid = value1.equals(value2);
			if (!valid) {
				message = "Os valores dos atributos são diferentes";
			}
			break;
		case DIFFERENT:
			valid = !value1.equals(value2);
			if (!valid) {
				message = "Os valores dos atributos são iguais";
			}
			break;
		case GREATERTHAN:
			valid = value1.compareTo(value2) == 1;
			if (!valid) {
				message = "O " + attribute1 + " não é maior que " + attribute2;
			}
			break;
		case LESSTHAN:
			valid = value1.compareTo(value2) == -1;
			if (!valid) {
				message = "O " + attribute1 + " não é menor que " + attribute2;
			}
			break;
		case GREATEROREQUAL:
			valid = value1.compareTo(value2) >= 0;
			if (!valid) {
				message = "O " + attribute1 + " não é maior ou igual a " + attribute2;
			}
			break;
		case LESSOREQUAL:
			valid = value1.compareTo(value2) <= 0;
			if (!valid) {
				message = "O " + attribute1 + " não é menor ou igual a " + attribute2;
			}
			break;
		}

		if (!valid) {
			ctx.disableDefaultConstraintViolation();
			ctx.buildConstraintViolationWithTemplate(message).addPropertyNode(attribute1).addConstraintViolation();
		}
		return valid;

	}

}