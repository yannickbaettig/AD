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
import ch.hslu.ad.sw11_N4.Aufgabe4.FindFile;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("PMD.TooManyMethods")
public class FindFileTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(FindFileTest.class);


    @Test
    public void testFindFile() {
        FindFile findFile = new FindFile("C211File.txt",new File("/Users/yannickbattig/Projekte/HSLU Projects/ad_exercises/src/test/resources/FindFile"));
        String result = findFile.invoke();
        LOG.info(result);
    }

}
