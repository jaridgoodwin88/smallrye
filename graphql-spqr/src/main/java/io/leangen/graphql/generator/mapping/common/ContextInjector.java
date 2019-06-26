package io.leangen.graphql.generator.mapping.common;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Parameter;

import org.eclipse.microprofile.graphql.Source;

import io.leangen.graphql.generator.mapping.ArgumentInjectorParams;

/**
 * @author Bojan Tomic (kaqqao)
 */
public class ContextInjector extends InputValueDeserializer {

    @Override
    public Object getArgumentValue(ArgumentInjectorParams params) {
        return params.getInput() == null ? params.getResolutionEnvironment().context : super.getArgumentValue(params);
    }

    @Override
    public boolean supports(AnnotatedType type, Parameter parameter) {
        return parameter != null && parameter.isAnnotationPresent(Source.class);
    }
}
