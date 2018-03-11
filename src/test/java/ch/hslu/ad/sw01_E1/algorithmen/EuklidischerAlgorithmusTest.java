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

import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@SuppressWarnings("PMD.TooManyMethods")
public class EuklidischerAlgorithmusTest {
    private static int a,b, expected;
    private static EuklidischerAlgorithmus euk;

    @BeforeClass
    public static void setup(){
        a = 28;
        b = 68;
        expected = 4;
        euk = new EuklidischerAlgorithmus();
    }

    @Test
    public void testGgtIterativ1() {
        int result = EuklidischerAlgorithmus.ggtIterativ1(a,b);
        assertEquals(expected, result);
    }

    @Test
    public void testGgtIterativ2() {
        int result = EuklidischerAlgorithmus.ggtIterativ2(a,b);
        assertEquals(expected, result);
    }

    @Test
    public void testGgtRekursiv() {
        int result = EuklidischerAlgorithmus.ggtRekursiv(a,b);
        assertEquals(expected, result);
    }


}
