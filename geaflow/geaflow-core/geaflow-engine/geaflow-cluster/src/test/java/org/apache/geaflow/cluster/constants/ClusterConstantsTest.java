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

package org.apache.geaflow.cluster.constants;

import org.apache.geaflow.common.config.Configuration;
import org.apache.geaflow.common.config.keys.ExecutionConfigKeys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClusterConstantsTest {

    private Configuration createDefaultConfig() {
        Configuration config = new Configuration();
        config.put(ExecutionConfigKeys.MASTER_PREFIX, "master-");
        config.put(ExecutionConfigKeys.DRIVER_PREFIX, "driver-");
        config.put(ExecutionConfigKeys.CONTAINER_PREFIX, "container-");
        config.put(ExecutionConfigKeys.MASTER_LOG_SUFFIX, "master.log");
        config.put(ExecutionConfigKeys.DRIVER_LOG_SUFFIX, "driver.log");
        config.put(ExecutionConfigKeys.CONTAINER_LOG_SUFFIX, "container.log");
        config.put(ExecutionConfigKeys.DEFAULT_MASTER_ID, 0);
        config.put(ExecutionConfigKeys.PROCESS_EXIT_CODE, -1);
        config.put(ExecutionConfigKeys.CONTAINER_START_COMMAND_TEMPLATE, "%java% %classpath% %jvmmem% %jvmopts% %logging% %class% %redirects%");
        return config;
    }

    @Test
    public void testDefaultValues() {
        Configuration config = createDefaultConfig();
        // Test default values
        Assert.assertEquals(ClusterConstants.getMasterName(config), "master-0");
        Assert.assertEquals(ClusterConstants.getDriverName(config, 1), "driver-1");
        Assert.assertEquals(ClusterConstants.getContainerName(config, 2), "container-2");
        
        Assert.assertEquals(ClusterConstants.getMasterLogSuffix(config), "master.log");
        Assert.assertEquals(ClusterConstants.getDriverLogSuffix(config), "driver.log");
        Assert.assertEquals(ClusterConstants.getContainerLogSuffix(config), "container.log");
        
        Assert.assertEquals(config.getInteger(ExecutionConfigKeys.DEFAULT_MASTER_ID), 0);
    }

    @Test
    public void testGetMasterName() {
        Configuration config = createDefaultConfig();
        String masterName = ClusterConstants.getMasterName(config);
        Assert.assertEquals(masterName, "master-0");
    }

    @Test
    public void testGetDriverName() {
        Configuration config = createDefaultConfig();
        Assert.assertEquals(ClusterConstants.getDriverName(config, 0), "driver-0");
        Assert.assertEquals(ClusterConstants.getDriverName(config, 1), "driver-1");
        Assert.assertEquals(ClusterConstants.getDriverName(config, 10), "driver-10");
    }

    @Test
    public void testGetContainerName() {
        Configuration config = createDefaultConfig();
        Assert.assertEquals(ClusterConstants.getContainerName(config, 0), "container-0");
        Assert.assertEquals(ClusterConstants.getContainerName(config, 1), "container-1");
        Assert.assertEquals(ClusterConstants.getContainerName(config, 100), "container-100");
    }

    @Test
    public void testConstants() {
        Configuration config = createDefaultConfig();
        // Test all constants are properly defined
        Assert.assertNotNull(ClusterConstants.getMasterLogSuffix(config));
        Assert.assertNotNull(ClusterConstants.getDriverLogSuffix(config));
        Assert.assertNotNull(ClusterConstants.getContainerLogSuffix(config));
        Assert.assertNotNull(ClusterConstants.CLUSTER_TYPE);
        Assert.assertNotNull(ClusterConstants.LOCAL_CLUSTER);
        Assert.assertNotNull(ClusterConstants.MASTER_ID);
        Assert.assertNotNull(ClusterConstants.CONTAINER_ID);
        Assert.assertNotNull(ClusterConstants.CONTAINER_INDEX);
    }
}
