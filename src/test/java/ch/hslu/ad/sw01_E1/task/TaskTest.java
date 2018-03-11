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
package ch.hslu.ad.sw01_E1.task;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("PMD.TooManyMethods")
public class TaskTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(TaskTest.class);

    @Test
    public void testTask() {
        Long time = System.currentTimeMillis();
        Task taskRunner = new Task();
        taskRunner.task(5);
        Long duration = System.currentTimeMillis() - time;
        LOG.info(duration);
        LOG.info(taskRunner.toString());
    }

    @Test
    public void testTask2() {
        Long time = System.currentTimeMillis();
        Task taskRunner = new Task();
        taskRunner.task(10);
        Long duration = System.currentTimeMillis() - time;
        LOG.info(duration);
        LOG.info(taskRunner.toString());
    }

    @Test
    public void testTask3() {
        Long time = System.currentTimeMillis();
        Task taskRunner = new Task();
        taskRunner.task(20);
        Long duration = System.currentTimeMillis() - time;
        LOG.info(duration);
        LOG.info(taskRunner.toString());
    }

}
