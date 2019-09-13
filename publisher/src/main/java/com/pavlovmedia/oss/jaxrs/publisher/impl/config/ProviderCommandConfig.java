package com.pavlovmedia.oss.jaxrs.publisher.impl.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="ProviderCommandConfig", description="Configuration for Provider Command")
public @interface ProviderCommandConfig {
    @AttributeDefinition(name="osgi.command.scope")
    String commandScope() default "jax";
    
    @AttributeDefinition(name="osgi.command.function")
    String[] commandFunction() default { "getEndpoints", "getFeatures", "getProviders" };
}