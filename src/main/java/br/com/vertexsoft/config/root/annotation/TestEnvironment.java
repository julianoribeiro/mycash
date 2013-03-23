package br.com.vertexsoft.config.root.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Profile("test")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestEnvironment {

}