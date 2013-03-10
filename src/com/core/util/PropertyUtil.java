/**
 * 
 */
package com.core.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 
 * @ClassName  PropertyUtil
 * @package com.core.util
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-2-26 下午06:52:31
 *
 */
public class PropertyUtil {

	@SuppressWarnings("unchecked")
    private static Map instance = Collections.synchronizedMap(new HashMap());

	protected String sourceUrl;
	protected ResourceBundle resourceBundle;
	private static Map<String, String> convert = Collections
			.synchronizedMap(new HashMap<String, String>());

	protected PropertyUtil(String sourceUrl) {
		this.sourceUrl = sourceUrl;
		load();
	}

	@SuppressWarnings("unchecked")
    public static PropertyUtil getInstance(String sourceUrl) {
		synchronized (PropertyUtil.class) {
			PropertyUtil manager = (PropertyUtil) instance.get(sourceUrl);
			if (manager == null) {
				manager = new PropertyUtil(sourceUrl);
				instance.put(sourceUrl, manager);
			}
			return manager;
		}
	}

	private synchronized void load() {
		try {
			resourceBundle = ResourceBundle.getBundle(sourceUrl);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("sourceUrl = " + sourceUrl
					+ "file load error!", e);
		}
	}

	public String getProperty(String key) {
		return resourceBundle.getString(key);
	}


	@SuppressWarnings("unchecked")
    public Map<String, String> readyConvert() {
		Enumeration enu = resourceBundle.getKeys();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = resourceBundle.getString(key);
			convert.put(value, key);
		}
		return convert;
	}

	@SuppressWarnings("unchecked")
    public Map<String, String> readyConvert(ResourceBundle resourcebundle) {
		Enumeration enu = resourcebundle.getKeys();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = resourcebundle.getString(key);
			convert.put(value, key);
		}
		return convert;
	}
}
