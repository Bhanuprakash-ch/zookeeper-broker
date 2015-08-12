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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
public class ExternalConfiguration {

  @Value("${metadata.imageUrl}")
  @NotNull
  private String imageUrl;

  @Value("${zk.cluster}")
  @NotNull
  private String zkClusterHosts;

  @Value("${cf.serviceid}")
  @NotNull
  private String cfServiceId;

  @Value("${cf.servicename}")
  @NotNull
  private String cfServiceName;

  @Value("${zk.brokerusername}")
  @NotNull
  private String zkBrokerUserName;

  @Value("${zk.brokeruserpass}")
  @NotNull
  private String zkBrokerUserPass;

  @Value("${broker.store.node}")
  @NotNull
  private String brokerStoreNode;

  @Value("${broker.root.node}")
  @NotNull
  private String brokerRootNode;

  @Value("${kerberos.kdc}")
  @NotNull
  private String kerberosKdc;

  @Value("${kerberos.realm}")
  @NotNull
  private String kerberosRealm;

  @Value("${cf.baseId}")
  @NotNull
  private String cfBaseId;

  public String getZkClusterHosts() {
    return zkClusterHosts;
  }

  public void setZkClusterHosts(String zkClusterHosts) {
    this.zkClusterHosts = zkClusterHosts;
  }

  public String getCfServiceId() {
    return cfServiceId;
  }

  public void setCfServiceId(String cfServiceId) {
    this.cfServiceId = cfServiceId;
  }

  public String getCfServiceName() {
    return cfServiceName;
  }

  public void setCfServiceName(String cfServiceName) {
    this.cfServiceName = cfServiceName;
  }

  public String getZkBrokerUserName() {
    return zkBrokerUserName;
  }

  public void setZkBrokerUserName(String zkBrokerUserName) {
    this.zkBrokerUserName = zkBrokerUserName;
  }

  public String getZkBrokerUserPass() {
    return zkBrokerUserPass;
  }

  public void setZkBrokerUserPass(String zkBrokerUserPass) {
    this.zkBrokerUserPass = zkBrokerUserPass;
  }

  public String getBrokerStoreNode() {
    return brokerStoreNode;
  }

  public void setBrokerStoreNode(String brokerStoreNode) {
    this.brokerStoreNode = brokerStoreNode;
  }

  public String getBrokerRootNode() {
    return brokerRootNode;
  }

  public void setBrokerRootNode(String brokerRootNode) {
    this.brokerRootNode = brokerRootNode;
  }

  public String getKerberosKdc() {
    return kerberosKdc;
  }

  public void setKerberosKdc(String kerberosKdc) {
    this.kerberosKdc = kerberosKdc;
  }

  public String getKerberosRealm() {
    return kerberosRealm;
  }

  public void setKerberosRealm(String kerberosRealm) {
    this.kerberosRealm = kerberosRealm;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getCfBaseId() {
    return cfBaseId;
  }

  public void setCfBaseId(String cfBaseId) {
    this.cfBaseId = cfBaseId;
  }

  @Override
  public String toString() {
    return "ExternalConfiguration{" +
           "zkClusterHosts='" + zkClusterHosts + '\'' +
           ", cfServiceId='" + cfServiceId + '\'' +
           ", cfServiceName='" + cfServiceName + '\'' +
           ", zkBrokerUserName='" + zkBrokerUserName + '\'' +
           ", zkBrokerUserPass='" + zkBrokerUserPass + '\'' +
           ", brokerStoreNode='" + brokerStoreNode + '\'' +
           ", brokerRootNode='" + brokerRootNode + '\'' +
           ", kerberosKdc='" + kerberosKdc + '\'' +
           ", kerberosRealm='" + kerberosRealm + '\'' +
           '}';
  }

}