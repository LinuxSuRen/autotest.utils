/**
 * http://surenpi.com
 */
package com.surenpi.autotest.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author suren
 * @since 2017年1月4日 上午10:25:36
 */
public class IDCardUtilTest
{
	@Test
	public void test()
	{
		String code = IDCardUtil.generate();
		
		Assert.assertNotNull(code);
		
		System.out.println(code);
	}
}
