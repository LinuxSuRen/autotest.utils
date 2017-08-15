/**
 * http://surenpi.com
 */
package com.surenpi.autotest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

/**
 * 用于获取全局的文件根目录的工具类
 * @author suren
 * @since 2016年12月27日 上午8:12:18
 */
public abstract class PathUtil
{
	/** properties文件后缀 */
	public static final String PRO_SUFFIX = ".properties";

	/**
	 * @return 用于保存框架缓存数据的根目录，如果不存在会自动创建
	 */
	public static File getRootDir()
	{
		String rootDir = System.getProperty("user.home", ".");
		File rootFile = new File(rootDir, ".autotest");
		if(!rootFile.isDirectory())
		{
			rootFile.mkdirs();
		}
		
		return rootFile;
	}
	
	public static File getFile(String fileName)
	{
		return new File(PathUtil.getRootDir(), fileName);
	}
	
	public static boolean isFile(String fileName)
	{
		return getFile(fileName).isFile();
	}

    /**
     * @see #proStore(Properties, String, String)
     * @param pro pro
     * @param fileName fileName
     */
    public static void proStore(Properties pro, String fileName)
    {
        proStore(pro, fileName, "auto generate by phoenix framework, do not modify it.");
    }

	/**
	 * 保存Properties文件到框架根目录中
	 * @param pro 不能为空
	 * @param fileName 无需带后缀，例如：demo的话，会保存到demo.properties中
     * @param comment 注释
     */
	public static void proStore(Properties pro, String fileName, String comment)
	{
		try(OutputStream out = new FileOutputStream(
				new File(PathUtil.getRootDir(), fileName + PRO_SUFFIX)))
		{
			pro.store(out, comment);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
     * @see #proStore(Properties, String, String)
     * @param pro 不能为空
	 * @param fileName fileName
     * @return 读取成功返回true，否则false
     */
	public static boolean proLoad(Properties pro, String fileName)
	{
        File targetFile = new File(PathUtil.getRootDir(), fileName + PRO_SUFFIX);
        if(!targetFile.isFile())
        {
            return false;
        }

		try(InputStream in = new FileInputStream(targetFile))
		{
			pro.load(in);

            return true;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

        return false;
	}
	
	/**
	 * 如果存在，则跳过，不复制
	 * @param input input
	 * @param fileName fileName
	 * @return fileName
	 */
	public static File copyFileToRoot(InputStream input, String fileName)
	{
		File rootFile = PathUtil.getRootDir();
		File targetFile = new File(rootFile, fileName);
		if(!targetFile.isFile())
		{
			copyFileToRoot(input, targetFile);
		}
		
		return targetFile;
	}
	
	/**
	 * 把目标文件拷贝到框架的缓存根目录中
	 * @param input 需要调用者自行调用该输入流的close方法
	 * @param targetFile targetFile
	 * @return targetFile
	 */
	public static boolean copyFileToRoot(InputStream input, File targetFile)
	{
		try(OutputStream output = new FileOutputStream(targetFile))
		{
			IOUtils.copy(input, output);
			
			return true;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
