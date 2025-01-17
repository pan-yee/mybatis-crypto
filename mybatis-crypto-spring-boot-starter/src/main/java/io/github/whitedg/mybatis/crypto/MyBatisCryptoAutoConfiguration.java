package io.github.whitedg.mybatis.crypto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author White
 */
@Configuration
@ConditionalOnProperty(value = "mybatis-crypto.enabled", havingValue = "true", matchIfMissing = false)
@EnableConfigurationProperties(MybatisCryptoProperties.class)
public class MyBatisCryptoAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(MybatisEncryptionPlugin.class)
    public MybatisEncryptionPlugin encryptionInterceptor(MybatisCryptoProperties properties) {
        return new MybatisEncryptionPlugin(properties.toMybatisCryptoConfig());
    }

    @Bean
    @ConditionalOnMissingBean(MybatisDecryptionPlugin.class)
    public MybatisDecryptionPlugin decryptionInterceptor(MybatisCryptoProperties properties) {
        return new MybatisDecryptionPlugin(properties.toMybatisCryptoConfig());
    }

}
