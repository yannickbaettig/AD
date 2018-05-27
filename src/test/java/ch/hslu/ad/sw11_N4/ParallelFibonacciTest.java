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
package ch.hslu.ad.sw11_N4;


import ch.hslu.ad.sw11_N4.Aufgabe3.ParallelFibonacci;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("PMD.TooManyMethods")
public class ParallelFibonacciTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ParallelFibonacciTest.class);


    @Test
    public void testFiboRec_1() {
        ParallelFibonacci fibonacci = new ParallelFibonacci(40);
        int result = fibonacci.invoke();
        int expected = 102334155;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec_2() {
        ParallelFibonacci fibonacci = new ParallelFibonacci(1);
        int result = fibonacci.invoke();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec_3() {
        ParallelFibonacci fibonacci = new ParallelFibonacci(0);
        int result = fibonacci.invoke();
        int expected = 0;
        assertEquals(expected, result);
    }

}
