package com.chinasofti.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用来进行密码加密的md5公用参数
 * @author zhaow
 *
 */
public class MD5Digest {

	private MessageDigest m_md5 = null;

	private StringBuffer m_strDigestBuffer = null;

	public MD5Digest() throws NoSuchAlgorithmException {
		m_md5 = MessageDigest.getInstance("MD5");
		m_strDigestBuffer = new StringBuffer();
	}

	public String md5crypt(String s) {
		m_strDigestBuffer.setLength(0);
		byte abyte0[] = m_md5.digest(s.getBytes());
		for (int i = 0; i < abyte0.length; i++)
			m_strDigestBuffer.append(toHex(abyte0[i]));

		return m_strDigestBuffer.toString();
	}

	public String toHex(byte one) {
		String HEX = "0123456789ABCDEF";
		char[] result = new char[2];
		result[0] = HEX.charAt((one & 0xf0) >> 4);
		result[1] = HEX.charAt(one & 0x0f);
		String mm = new String(result);
		return mm;
	}
}
