package com.dt.dtpt.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

/**
 * 多国语言工具类
 * 
 * @author zhangy
 * 
 */
public class LocaleUtils {
	
	public static final String LOCALE_CN = "CN";
	
	public static String def_locale = LOCALE_CN;
	
	/**
	 * 根据Key获取对应的内容
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return get(key, null);
	}

	/**
	 * 根据Key获取对应的内容
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key, HttpServletRequest request) {
		String tlocale = ConfigUtils.get("defaultLang");
		Locale locale = request == null ? new Locale(tlocale == null?def_locale:tlocale) : request.getLocale();
		ResourceBundle resource = ResourceBundle.getBundle("messages", locale);
		String value = resource.getString(key);
		if (value.length() == 0) {
			value = key;
		}

		return value;
	}

	/**
	 * 根据Key 获取对应内容，并格式化内容
	 * 
	 * @param key
	 * @param args
	 * @return
	 */
	public static String format(String key, Object... args) {
		return String.format(get(key), args);
	}

	/**
	 * 根据Key 获取对应内容，并格式化内容
	 * 
	 * @param key
	 * @param request
	 * @param args
	 * @return
	 */
	public static String format(String key, HttpServletRequest request, Object... args) {
		return String.format(get(key, request), args);
	}
}
