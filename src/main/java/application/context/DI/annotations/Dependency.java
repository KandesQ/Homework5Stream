package application.context.DI.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// аналог бина в спринге

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dependency {

}
