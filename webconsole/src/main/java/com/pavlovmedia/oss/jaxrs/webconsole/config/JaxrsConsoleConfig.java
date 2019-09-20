package com.pavlovmedia.oss.jaxrs.webconsole.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="JaxrsConsoleConfig", description="Configuration for JaxrsConsole")
public @interface JaxrsConsoleConfig {
    @AttributeDefinition(name="felix.webconsole.label")
    String felix_webconsole_label() default "JAXRS";
}