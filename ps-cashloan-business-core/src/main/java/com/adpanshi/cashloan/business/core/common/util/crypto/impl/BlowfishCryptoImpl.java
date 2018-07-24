package com.adpanshi.cashloan.business.core.common.util.crypto.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Blowfish算法加解密实现
 */
public class BlowfishCryptoImpl extends AbstractCryptoImpl {
	
	public static final Logger logger = LoggerFactory.getLogger(BlowfishCryptoImpl.class);

	private static final String algorithm = "Blowfish";

	private static final String transformation = "Blowfish/ECB/PKCS5Padding";

	private String key = "1Ay6qVwz5ic-=8egkfsdt9f12dalfdz0kHgYuy1X";// default key

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	private static BlowfishCryptoImpl defaultInstance = new BlowfishCryptoImpl();
	
	public static BlowfishCryptoImpl getDefault(){
		return defaultInstance;
	}
	
	@Override
	protected Cipher getDecryptCipher() {
		Cipher cipher = null;
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), algorithm);
			cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			logger.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			logger.error(e.getMessage(), e);
		}
		return cipher;
	}

	@Override
	protected Cipher getEncryptCipher() {
		Cipher cipher = null;
		try {
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), algorithm);
			cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			logger.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			logger.error(e.getMessage(), e);
		}
		return cipher;
	}

}
