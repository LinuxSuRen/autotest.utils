/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.surenpi.autotest.utils;

/**
 * 常见数字类型生成工具类
 * @author suren
 * @since 2017年1月7日 下午6:09:13
 */
public class CommonNumberUtil
{
	/**
	 * @return 随机的邮编
	 */
	public static String postCode()
	{
		StringBuffer buf = new StringBuffer();
		
		for(int i = 0; i < 6; i++)
		{
			buf.append(RandomUtils.nextInt(0, 10));
		}
		
		return buf.toString();
	}
	
	/**
	 * @return 随机生成中国的手机号码
	 */
	public static String phoneNumber()
	{
		StringBuffer buf = new StringBuffer();
		buf.append("182");
		
		for(int i = 0; i < 8; i++)
		{
			buf.append(RandomUtils.nextInt(0, 10));
		}
		
		return buf.toString();
	}
}
