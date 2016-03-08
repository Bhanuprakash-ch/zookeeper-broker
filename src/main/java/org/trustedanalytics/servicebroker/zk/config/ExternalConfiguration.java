/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.servicebroker.zk.config;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalConfiguration {

  @Value("${store.cluster}")
  @NotNull
  private String zkClusterHosts;

  @Value("${zk.broker.root}")
  @NotNull
  private String brokerRootNode;

  @Value("${store.user}")
  @NotNull
  private String user;

  @Value("${store.password}")
  @NotNull
  private String password;

  public String getZkClusterHosts() {
    return zkClusterHosts;
  }

  public void setZkClusterHosts(String zkClusterHosts) {
    this.zkClusterHosts = zkClusterHosts;
  }

  public String getBrokerRootNode() {
    return brokerRootNode;
  }

  public void setBrokerRootNode(String brokerRootNode) {
    this.brokerRootNode = brokerRootNode;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
