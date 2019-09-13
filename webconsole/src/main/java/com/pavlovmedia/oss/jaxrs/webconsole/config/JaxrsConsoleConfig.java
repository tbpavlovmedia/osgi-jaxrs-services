package com.pavlovmedia.oss.jaxrs.webconsole.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import com.pavlovmedia.oss.jaxrs.publisher.api.Publisher;
import com.pavlovmedia.oss.jaxrs.webconsole.JaxrsConsole;

@ObjectClassDefinition(name="JaxrsConsoleConfig", description="Configuration for Jaxrs Console")
public @interface JaxrsConsoleConfig {
    @AttributeDefinition(name="felix.webconsole.label")
    String jaxrsPublish() default JaxrsConsole.LABEL;
}
