/**
 * http://surenpi.com
 */
package com.surenpi.autotest.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author suren
 * @since 2017年1月7日 下午6:59:15
 */
public class StringUtilTest
{
	@Test
	public void email()
	{
		String server = "126.com";
		
		String email = StringUtils.email(server);
		
		System.out.println(email);
		Assert.assertNotNull(email);
		Assert.assertTrue(email.endsWith(server));
		
		email = StringUtils.email();
		System.out.println(email);
		Assert.assertNotNull(email);
	}
}
