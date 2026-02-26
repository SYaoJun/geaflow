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

import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.CONTAINER_LOG_SUFFIX;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.CONTAINER_PREFIX;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.CONTAINER_START_COMMAND_TEMPLATE;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.DEFAULT_MASTER_ID;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.DRIVER_LOG_SUFFIX;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.DRIVER_PREFIX;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.MASTER_LOG_SUFFIX;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.MASTER_PREFIX;
import static org.apache.geaflow.common.config.keys.ExecutionConfigKeys.PROCESS_EXIT_CODE;

import org.apache.geaflow.common.config.Configuration;

public class ClusterConstants {

    public static final String CLUSTER_TYPE = "clusterType";
    public static final String LOCAL_CLUSTER = "LOCAL";

    public static final String ENV_AGENT_PORT = "AGENT_PORT";
    public static final String ENV_SUPERVISOR_PORT = "SUPERVISOR_PORT";

    public static final String MASTER_ID = "GEAFLOW_MASTER_ID";
    public static final String CONTAINER_ID = "GEAFLOW_CONTAINER_ID";
    public static final String CONTAINER_INDEX = "GEAFLOW_CONTAINER_INDEX";
    public static final String AUTO_RESTART = "GEAFLOW_AUTO_RESTART";
    public static final String IS_RECOVER = "GEAFLOW_IS_RECOVER";
    public static final String JOB_CONFIG = "GEAFLOW_JOB_CONFIG";
    public static final String CONTAINER_START_COMMAND = "CONTAINER_START_COMMAND";
    public static final String AGENT_PROFILER_PATH = "AGENT_PROFILER_PATH";
    public static final String CONFIG_FILE_LOG4J_NAME = "log4j.properties";

    public static String getMasterName(Configuration config) {
        return String.format("%s%s", config.getString(MASTER_PREFIX), config.getInteger(DEFAULT_MASTER_ID));
    }

    public static String getDriverName(Configuration config, int id) {
        return String.format("%s%s", config.getString(DRIVER_PREFIX), id);
    }

    public static String getContainerName(Configuration config, int id) {
        return String.format("%s%s", config.getString(CONTAINER_PREFIX), id);
    }

    public static String getMasterLogSuffix(Configuration config) {
        return config.getString(MASTER_LOG_SUFFIX);
    }

    public static String getDriverLogSuffix(Configuration config) {
        return config.getString(DRIVER_LOG_SUFFIX);
    }

    public static String getContainerLogSuffix(Configuration config) {
        return config.getString(CONTAINER_LOG_SUFFIX);
    }

    public static int getExitCode(Configuration config) {
        return config.getInteger(PROCESS_EXIT_CODE);
    }

    public static String getContainerStartCommandTemplate(Configuration config) {
        return config.getString(CONTAINER_START_COMMAND_TEMPLATE);
    }

}
