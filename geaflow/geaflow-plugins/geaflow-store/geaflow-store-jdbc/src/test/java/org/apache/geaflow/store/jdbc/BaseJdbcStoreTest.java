/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.geaflow.store.jdbc;

import org.testng.annotations.Test;

/**
 * Test class for BaseJdbcStore NPE fixes.
 */
public class BaseJdbcStoreTest {

    /**
     * Test that close() method handles null ds gracefully (regression test for NPE fix).
     * Before the fix, calling close() before init() would throw NPE because ds was null.
     */
    @Test
    public void testCloseWithNullDataSource() {
        // Create a concrete implementation for testing
        BaseJdbcStore store = new BaseJdbcStore() {
            // No additional methods needed - using inherited methods
        };

        // This should not throw NPE even though ds is null
        // (init() was never called, so ds was never initialized)
        store.close();
    }
}
