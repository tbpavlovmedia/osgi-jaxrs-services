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
package com.pavlovmedia.oss.jaxrs.publisher.impl.swagger;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import com.pavlovmedia.oss.jaxrs.publisher.api.Publisher;

/**
 * This class represents the meta-data that can be served by
 * swagger.
 * 
 * @author Shawn Dempsay {@literal <sdempsay@pavlovmedia.com>}
 *
 */
@Component(immediate=true, metatype=true)
@Service(SwaggerConfiguration.class)
@Properties({
    @Property(name=Publisher.SCAN_IGNORE, value="true", propertyPrivate=true),
    @Property(name="com.eclipsesource.jaxrs.publish", boolValue=false, propertyPrivate=true),
    @Property(name="title", label="Title", value="JAX-RS Project"),
    @Property(name="description", label="Description"),
    @Property(name="apiVersion", label="API Version", description="The version of this api", value="1.0"),
    @Property(name="contactName", label="Contact Name"),
    @Property(name="contactUrl", label="Contact URL"),
    @Property(name="contactEmail", label="Contact Email"),
    @Property(name="licenseName", label="License Name", description="Something like 'Apache 2.0'"),
    @Property(name="licenseUrl", label="License URL")
})
public class SwaggerConfiguration {
    
    public String title;
    public String description;
    public String apiVersion;
    public String contactName;
    public String contactUrl;
    public String contactEmail;
    public String licenseName;
    public String licenseUrl;
    
    @Activate
    protected void activate(final Map<String,Object> properties) {
        parse(properties);
    }
    
    @Modified
    protected void modified(final Map<String,Object> properties) {
        parse(properties);
    }
    
    private void parse(final Map<String,Object> properties) {
        title = (String) properties.get("title");
        description = (String) properties.get("description");
        apiVersion = (String) properties.get("apiVersion");
        contactName = (String) properties.get("contactName");
        contactUrl = (String) properties.get("contactUrl");
        contactEmail = (String) properties.get("contactEmail");
        licenseName = (String) properties.get("licenseName");
        licenseUrl = (String) properties.get("licenseUrl");
    }
}
