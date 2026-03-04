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

package org.apache.geaflow.store.data;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.apache.geaflow.model.graph.edge.IEdge;
import org.apache.geaflow.model.graph.edge.impl.IDEdge;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GraphWriteBufferTest {

    private GraphWriteBuffer<String, String, Object> buffer;

    @BeforeMethod
    public void setUp() {
        buffer = new GraphWriteBuffer<>(100);
    }

    @Test
    public void testAddEdgesWithNullList() {
        // Test that null list is handled gracefully
        buffer.addEdges(null);
        assertEquals(buffer.getSize(), 0);
    }

    @Test
    public void testAddEdgesWithEmptyList() {
        // Test that empty list is handled gracefully (regression test for NPE fix)
        List<IEdge<String, Object>> emptyEdges = new ArrayList<>();
        buffer.addEdges(emptyEdges);
        assertEquals(buffer.getSize(), 0);
    }

    @Test
    public void testAddEdgesWithValidList() {
        // Test normal operation with valid edges
        List<IEdge<String, Object>> edges = new ArrayList<>();
        edges.add(new IDEdge<>("src1", "target1"));
        edges.add(new IDEdge<>("src1", "target2"));

        buffer.addEdges(edges);
        assertEquals(buffer.getSize(), 2);
    }
}
