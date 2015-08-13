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

import org.trustedanalytics.cfbroker.store.zookeeper.service.ZookeeperClient;
import org.trustedanalytics.cfbroker.store.zookeeper.service.ZookeeperClientBuilder;
import org.trustedanalytics.hadoop.kerberos.KrbLoginManager;
import org.trustedanalytics.hadoop.kerberos.KrbLoginManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

import javax.security.auth.login.LoginException;

@Configuration
public class ZkClientConfig {

  private final static Logger LOGGER = LoggerFactory.getLogger(ZkClientConfig.class);

  @Autowired
  private ExternalConfiguration conf;

  @Bean(initMethod = "init", destroyMethod = "destroy")
  @Qualifier(Qualifiers.BROKER_INSTANCE)
  public ZookeeperClient getZkClientForBrokerInstance() throws IOException, LoginException {
    krbAut();
    ZookeeperClient zkClient =
        new ZookeeperClientBuilder(conf.getZkClusterHosts(),
                                   conf.getZkBrokerUserName(),
                                   conf.getZkBrokerUserPass(),
                                   conf.getBrokerRootNode()).build();
    return zkClient;
  }

  @Bean(initMethod = "init", destroyMethod = "destroy")
  @Profile("cloud")
  @Qualifier(Qualifiers.BROKER_STORE)
  public ZookeeperClient getZkClientForBrokerStore() throws IOException, LoginException {
    krbAut();
    ZookeeperClient zkClient = new ZookeeperClientBuilder(conf.getZkClusterHosts(),
                                                   conf.getZkBrokerUserName(),
                                                   conf.getZkBrokerUserPass(),
                                                   conf.getBrokerStoreNode()).build();
    return zkClient;
  }

  private void krbAut() throws LoginException {
    if (conf.getKerberosKdc().isEmpty()
        || conf.getKerberosRealm().isEmpty()) {
      return;
    }
    LOGGER.info("Trying to authenticate");
    KrbLoginManager loginManager =
        KrbLoginManagerFactory.getInstance().getKrbLoginManagerInstance(
            conf.getKerberosKdc(),
            conf.getKerberosRealm());
    loginManager.loginWithCredentials(conf.getZkBrokerUserName(), conf.getZkBrokerUserPass().toCharArray());
  }
}
