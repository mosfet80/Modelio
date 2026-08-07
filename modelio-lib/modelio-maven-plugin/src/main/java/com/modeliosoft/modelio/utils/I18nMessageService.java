
package com.modeliosoft.modelio.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Message service 
 * <br>Use of "i18n/messages"
 *
 */
public class I18nMessageService {

	private final static String FILE_NAME_MESSAGES = "res/message";

	private static I18nMessageService instance;

	private ResourceBundle messageResource;

	/**
	 * Constructor.
	 */
	private I18nMessageService() {
		Locale locale = Locale.getDefault();
		this.messageResource = ResourceBundle.getBundle(FILE_NAME_MESSAGES, locale);
	}

	/**
	 * Singleton creation.
	 */
	private static I18nMessageService getInstance() {
		if (null == instance) { // Premier appel
			instance = new I18nMessageService();
		}
		return instance;
	}

	/**
	 * @return the messageResource
	 */
	private ResourceBundle getMessageResource() {
		return this.messageResource;
	}

	/**
	 * Get message value from key.
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return getInstance().getMessageResource().getString(key);
	}

	/**
	 * Get list of messages values from key with parameters.
	 * 
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getString(String key, String... params) {
		String message = null;
		try {
			String value = getString(key);
			message = MessageFormat.format(value, (Object[]) params);
		} catch (MissingResourceException e) {
			message = '!' + key + '!';
		}
		return message;
	}
}
