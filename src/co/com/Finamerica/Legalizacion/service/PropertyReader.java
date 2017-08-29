/**
 * Finamerica. Copyright All Reserved. 12-may-2010. AdminProperties.java
 */
package co.com.Finamerica.Legalizacion.service;

import java.util.Locale;

import co.com.Finamerica.Legalizacion.Activator;

import com.lexmark.prtapp.util.Messages;

/**
 * <p>
 * Permite leer el archivo de propiedades correspondiente al bundle del eSF.
 * </p>
 * 
 * @author <a href="mailto:">luno</a>
 * @version 1.0
 * @since 1.0
 * 
 */
public class PropertyReader {

    private static final String PROPERTY_FILE_NAME = "Resources";
    
    public static final String PROMPT_COMBO_LABEL_SELSER_OPT1 = "prompt.combo.label.selser.opt1";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT2 = "prompt.combo.label.selser.opt2";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT3 = "prompt.combo.label.selser.opt3";
    
    
    public static final String PROMPT_COMBO_LABEL_SELSER_OPT4 = "prompt.combo.label.selser.opt4";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT5 = "prompt.combo.label.selser.opt5";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT6 = "prompt.combo.label.selser.opt6";
    
    
    public static final String PROMPT_COMBO_LABEL_SELSER_OPT7 = "prompt.combo.label.selser.opt7";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT8 = "prompt.combo.label.selser.opt8";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT9 = "prompt.combo.label.selser.opt9";
    
    
    public static final String PROMPT_COMBO_LABEL_SELSER_OPT10 = "prompt.combo.label.selser.opt10";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT11 = "prompt.combo.label.selser.opt11";

    public static final String PROMPT_COMBO_LABEL_SELSER_OPT12 = "prompt.combo.label.selser.opt12";
    
    

    public static final String PROMPT_COMBO_LABEL_SELSER = "prompt.combo.label.selser";
    
    public static final String PROMPT_COMBO_LABEL_SELSER2 = "prompt.combo.label.selser2";
    
    public static final String PROMPT_COMBO_LABEL_SELSER3 = "prompt.combo.label.selser3";
    
    public static final String PROMPT_COMBO_LABEL_SELSER4 = "prompt.combo.label.selser4";
    
    public static final String PROMPT_INTEGER_LABEL_SELCED0 = "prompt.integer.label.selced0";

    public static final String PROMPT_INTEGER_LABEL_SELCED = "prompt.integer.label.selced";
    
    public static final String PROMPT_INTEGER_LABEL_SELCED2 = "prompt.integer.label.selced2";
    
    public static final String PROMPT_MESSAGE_LABEL_SETTINGNOTSET = "prompt.message.label.settingnotset";
    
    public static final String ICON_NAME = "icon.name";

    public static final String PROMPT_MESSAGE_LABEL_SERVERNOTSET = "prompt.message.label.servernotset";
    
    public static final String PROMPT_MESSAGE_LABEL_REGISDIFEREN = "prompt.message.label.regisdiferent";
    
    private static PropertyReader instance;

    private Messages messages;

    /**
     * <p>
     * Retorna la instancia unica
     * </p>
     */
    public static PropertyReader getInstance(Locale locale) {
        if (instance == null) {
            instance = new PropertyReader(locale);
        }

        return instance;
    }

    /**
     * <p>
     * El constructor es privado, ya que se implementa un patron Singleton sobre
     * la clases
     * </p>
     */
    private PropertyReader(Locale locale) {
        try {
            messages = new Messages(PROPERTY_FILE_NAME, locale, getClass().getClassLoader());
        } catch (RuntimeException e) {
            Activator.getLog().info("Error obteniendo el archivo de propiedades", e);
            throw new ServiceException("El archivo de propiedades no puede ser obtenido");
        }
    }

    /**
     * <p>
     * Permite obtener una propiedad d el archivo de propiedades
     * </p>
     * 
     * @param key
     *            La clave que identifica la propiedad
     * @return El valor de la propiedad identificada por <code>key</code> en
     *         caso contrario retorna null
     */
    public String getProperty(String key) {

        if (messages == null) {
            throw new ServiceException(
                                       new IllegalStateException(
                                                                 "El archivo de propiedades no puede ser obtenido"));
        }
        return messages.getString(key);
    }
}
