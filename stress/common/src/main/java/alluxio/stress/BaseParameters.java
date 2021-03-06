/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.stress;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * This holds all the parameters. All fields are public for easier json ser/de without all the
 * getters and setters.
 */
public final class BaseParameters {
  public static final String CLUSTER_FLAG = "--cluster";
  public static final String CLUSTER_LIMIT_FLAG = "--cluster-limit";
  public static final String DISTRIBUTED_FLAG = "--distributed";
  public static final String ID_FLAG = "--id";
  public static final String IN_PROCESS_FLAG = "--in-process";
  public static final String JAVA_OPT_FLAG = "--java-opt";
  public static final String START_MS_FLAG = "--start-ms";

  public static final long UNDEFINED_START_MS = -1;

  // Public flags
  @Parameter(names = {CLUSTER_FLAG},
      description = "If true, runs the benchmark via the job service cluster. Otherwise, runs "
          + "locally.")
  public boolean mCluster = false;

  @Parameter(names = {CLUSTER_LIMIT_FLAG},
      description = "If greater than 0, it will only run on that number of workers. If 0 or less,"
          + " will run on all available cluster workers.")
  public int mClusterLimit = 0;

  @Parameter(names = {ID_FLAG},
      description = "Any string to uniquely identify this invocation", hidden = true)
  public String mId = "local-task-0";

  @Parameter(names = {JAVA_OPT_FLAG},
      description = "The java options to add to the command line to for the task. This can be "
          + "repeated. The options must be quoted and prefixed with a space, to avoid getting "
          + "passed to the JVM. For example: --java-opt \" -Xmx4g\" --java-opt \" -Xms2g\"")
  public List<String> mJavaOpts = new ArrayList<>();

  // Hidden flags
  @Parameter(names = {DISTRIBUTED_FLAG},
      description = "If true, this is a distributed task, not a local task. This is "
          + "automatically added for a cluster job.",
      hidden = true)
  public boolean mDistributed = false;

  @Parameter(names = {START_MS_FLAG},
      description = "The time (ms since epoch) in the future to start the test. -1 means start "
          + "immediately.", hidden = true)
  public long mStartMs = UNDEFINED_START_MS;

  @Parameter(names = {IN_PROCESS_FLAG},
      description = "If true, runs the task in process. Otherwise, will spawn a new process to "
          + "execute the task",
      hidden = true)
  public boolean mInProcess = false;
}
