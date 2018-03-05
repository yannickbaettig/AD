/*
 * Copyright 2018 Roland Gisler, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw01.algorithmen;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("PMD.TooManyMethods")
public class AckermannTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(AckermannTest.class);

    @Before
    public void before(){
        Ackermann.counter = 0;
    }

    @Test
    public void testAck1() {
        long result = Ackermann.ack(2,2);
        long expected = 7;
        LOG.info(Ackermann.counter);
        assertEquals(expected, result);
    }

    @Test
    public void testAck2() {
        long result = Ackermann.ack(0,2);
        long expected = 3;
        LOG.info(Ackermann.counter);
        assertEquals(expected, result);
    }


    @Test
    public void testAck3() {
        long result = Ackermann.ack(3,0);
        long expected = 5;
        LOG.info(Ackermann.counter);
        assertEquals(expected, result);
    }
}
