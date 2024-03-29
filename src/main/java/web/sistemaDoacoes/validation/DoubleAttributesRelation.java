package web.sistemaDoacoes.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import web.sistemaDoacoes.validation.util.AttributesRelation;
import web.sistemaDoacoes.validation.validator.DoubleAttributesRelationValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DoubleAttributesRelationValidator.class)
@Documented
public @interface DoubleAttributesRelation {

	String attribute1();

	String attribute2();

	AttributesRelation relation();

	double epsilon() default 0.0001;

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		DoubleAttributesRelation[] value();
	}

}