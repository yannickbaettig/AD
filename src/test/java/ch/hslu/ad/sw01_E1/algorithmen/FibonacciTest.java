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
package ch.hslu.ad.sw01_E1.algorithmen;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("PMD.TooManyMethods")
public class FibonacciTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(FibonacciTest.class);

    @Test
    public void testFiboRec_1() {
        int result = Fibonacci.fiboRec1(30);
        int expected = 832040;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec_2() {
        int result = Fibonacci.fiboRec1(1);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec_3() {
        int result = Fibonacci.fiboRec1(0);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec2_1() {
        long result = Fibonacci.fiboRec2(30);
        long expected = 832040;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec2_2() {
        long result = Fibonacci.fiboRec2(1);
        long expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec2_3() {
        long result = Fibonacci.fiboRec2(0);
        long expected = 0;
        assertEquals(expected, result);
    }


    @Test
    public void testFiboIter1() {
        int result = Fibonacci.fiboIter(30);
        int expected = 832040;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboIter2() {
        int result = Fibonacci.fiboIter(1);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboIter3() {
        int result = Fibonacci.fiboIter(0);
        int expected = 0;
        assertEquals(expected, result);
    }
}
