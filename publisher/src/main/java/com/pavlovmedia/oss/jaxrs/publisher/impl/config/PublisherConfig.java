package com.pavlovmedia.oss.jaxrs.publisher.impl.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import com.pavlovmedia.oss.jaxrs.publisher.impl.JerseyPublisher;

@ObjectClassDefinition(name="PublisherConfig", description="Configuration for Jersey Publisher")
public @interface PublisherConfig {
    @AttributeDefinition(name=JerseyPublisher.PATH, description = "Path to serve JAX-RS endpoints from")
    String jaxrsPublisherPath() default "/services";
}
