package io.github.whitedg.mybatis.crypto;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.nio.charset.StandardCharsets;

/**
 * 自定义数据库字段自动加解密处理类
 * @author yp
 */
public class CustomAESEncryptor implements IEncryptor {

    @Override
    public String encrypt(Object val2bEncrypted, String key) throws Exception {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes(StandardCharsets.UTF_8));
        // 实现这个方法返回加密后的数据
        return aes.encryptBase64((String) val2bEncrypted);
    }

    @Override
    public String decrypt(Object val2bDecrypted, String key) throws Exception {
        // 实现这个方法返回解密后的数据
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes(StandardCharsets.UTF_8));
        return aes.decryptStr((String)val2bDecrypted);
    }
}