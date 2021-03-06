/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.spring.management;

import org.apache.camel.FailedToCreateRouteException;
import org.apache.camel.NoSuchEndpointException;
import org.apache.camel.spring.SpringTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.fail;

@DisabledOnOs(OS.AIX)
public class SpringCamelContextStartingFailedEventTest extends SpringTestSupport {

    @Override
    protected boolean useJmx() {
        return true;
    }

    @Override
    protected AbstractXmlApplicationContext createApplicationContext() {
        try {
            new ClassPathXmlApplicationContext(
                    "org/apache/camel/spring/management/SpringCamelContextStartingFailedEventTest.xml");
            fail("Should thrown an exception");
        } catch (Exception e) {
            FailedToCreateRouteException ftcre = assertIsInstanceOf(FailedToCreateRouteException.class, e);
            assertIsInstanceOf(NoSuchEndpointException.class, ftcre.getCause());
            // expected
        }

        // fallback to load another file that works
        return new ClassPathXmlApplicationContext("/org/apache/camel/spring/disableJmxConfig.xml");
    }

    @Test
    public void testReady() {
        // noop
    }
}
