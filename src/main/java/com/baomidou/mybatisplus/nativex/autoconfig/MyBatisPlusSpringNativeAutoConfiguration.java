/*
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.baomidou.mybatisplus.nativex.autoconfig;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.SqlSessionFactoryBeanCustomizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.nativex.MyBatisScannedResourcesHolder;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * The configuration class that configure automatically for spring-native.
 *
 * @author Kazuki Shimizu
 */
@Configuration
@ConditionalOnClass({org.apache.ibatis.session.Configuration.class, SqlSessionFactoryBeanCustomizer.class})
@AutoConfigureBefore(MybatisPlusAutoConfiguration.class)
public class MyBatisPlusSpringNativeAutoConfiguration {
    private static final Log LOG = LogFactory.getLog(MyBatisPlusSpringNativeAutoConfiguration.class);

    /*@ConditionalOnBean(MyBatisScannedResourcesHolder.class)
    @Bean
    ConfigurationCustomizer mybatisScannedResourcesHolderConfigurationCustomizer(
            List<MyBatisScannedResourcesHolder> holders) {
        return configuration -> holders.forEach(holder -> {
            holder.getTypeAliasesClasses().forEach(configuration.getTypeAliasRegistry()::registerAlias);
            holder.getTypeHandlerClasses().forEach(configuration.getTypeHandlerRegistry()::register);
        });
    }*/

    @ConditionalOnBean(MyBatisScannedResourcesHolder.class)
    @Bean
    SqlSessionFactoryBeanCustomizer mybatisScannedResourcesHolderSqlSessionFactoryBeanCustomizer(
            List<MyBatisScannedResourcesHolder> holders) {
        LOG.info("MyBatisScannedResourcesHolder instance size:" + holders.size());
        return factoryBean -> {
            LOG.info("start set mapperLocations");
            Resource[] resources = holders.stream()
                    .flatMap(holder -> holder.getMapperLocations().stream().map(ClassPathResource::new)).toArray(Resource[]::new);
            LOG.info("set mapperLocations size:" + resources.length);

            if (resources.length > 0) {
                factoryBean.setMapperLocations(resources);
            }
        };
    }

}
