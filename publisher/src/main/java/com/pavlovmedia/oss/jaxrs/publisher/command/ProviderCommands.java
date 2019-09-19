/*
 * Copyright 2017 Pavlov Media
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pavlovmedia.oss.jaxrs.publisher.command;
 

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.Logger;
import org.osgi.service.log.LoggerFactory;
import org.osgi.service.metatype.annotations.Designate;

import com.pavlovmedia.oss.jaxrs.publisher.api.Publisher;
import com.pavlovmedia.oss.jaxrs.publisher.impl.config.ProviderCommandConfig;

/**
 * Commands to facilitate debugging of the JAX-RS system.
 * 
 * @author Shawn Dempsay {@literal <sdempsay@pavlovmedia.com>}
 *
 */
@Component(
    property= {
        Publisher.SCAN_IGNORE + "=true"
    }) 
@Designate(ocd = ProviderCommandConfig.class)
public class ProviderCommands {
    @Reference
    Publisher publisher;
    
    @Reference(service = LoggerFactory.class)
    Logger logger;
    
    @Activate
    private ProviderCommandConfig config;
    /**
     * Lists all the registred endpoints
     */
    public void getEndpoints() {
        logger.debug("JAX-RS Endpoint mappings: ");
        publisher.getEndpoints().forEach((k,v) -> {
            logger.debug(k);
            v.forEach(e -> logger.debug(String.format("\t%s", e)));
        });
    }
    
    /**
     * Lists all the registered features
     */
    public void getFeatures() {
        logger.debug("JAX-RS Features:");
        publisher.getFeatures().forEach(f -> logger.debug(f.getClass().getName()));
    }
    
    /**
     * Lists all the registered providers
     */
    public void getProviders() {
        logger.debug("JAX-RS Providers:");
        publisher.getProviders().forEach(p -> {
            logger.debug(String.format("%s with the following interfaces:", p.getClass().getName()));
            for (Class<?> i :p.getClass().getInterfaces()) {
                logger.debug(String.format("\t%s", i.getName()));
            }
        });
    }
}
