/**
 * Finamerica. Copyright All Reserved. 12-may-2010. AdminSettings.java
 */
package co.com.Finamerica.Legalizacion.service;

import java.util.Dictionary;
import java.util.Iterator;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import co.com.Finamerica.Legalizacion.Activator;

import com.lexmark.prtapp.settings.SettingDefinition;
import com.lexmark.prtapp.settings.SettingDefinitionMap;
import com.lexmark.prtapp.settings.SettingsAdmin;

/**
 * <p>
 * Esta clase permite administrar el servicio de configuracion de la MFP, y
 * obtener las opciones para este bundle. Esta clase solo tiene una instancia a
 * la vez
 * </p>
 * 
 * @author <a href="mailto:">mmmm</a>
 * @version 1.0
 * @since 1.0
 * 
 */
public class AdminSettings implements ManagedService {

    public static final String BUNDLE_NAME = "Finamerica1";
    
    
    

    public static final String SETTINGS_NAME_OFFICE_C = "settings.oficina.nombreCreditos";
    
    public static final String SETTINGS_NAME_OFFICE_P = "settings.oficina.nombreProductos";
    
    public static final String SETTINGS_NAME_OFFICE_A = "settings.oficina.nombreAdministrativos";
    
    
    
    
    public static final String SETTINGS_CODE_OFFICE = "settings.oficina.codigo";

    public static final String SETTINGS_RE_SERVER = "settings.server.creditos";

    public static final String SETTINGS_COT_SERVER = "settings.server.productos";

    public static final String SETTINGS_NEW_SERVER = "settings.server.administrativos";

    public static final String SETTINGS_WINS_SERVER = "settings.wins.server";

    public static final String SETTINGS_DOMAIN_SERVER = "settings.domain.server";

    public static final String SETTINGS_USER_SERVER = "settings.user.server";

    public static final String SETTINGS_PASSWORD_SERVER = "settings.password.server";
    
    public static final String SETTINGS_BACKGROUND = "settings.background";

    public static final String SETTING_EMPTY = "";

    private static SettingsAdmin _settingsAdmin = null;

    /**
     * <p>
     * Obtiene un valor de la configuracion dado su nombre
     * </p>.
     * 
     * @param settingName
     *            El nombre de una opcion de la configuracion
     */
    public static Object getSetting(String settingName) {
    	

        try {
            SettingDefinitionMap settings = _settingsAdmin.getGlobalSettings(BUNDLE_NAME);
            SettingDefinition shareNameDef = settings.get(settingName);
            return shareNameDef.getCurrentValue();
        } catch (RuntimeException e) {
        	
            Activator.getLog().info("Error obteniendo el servicio de configuracion ");
            throw new ServiceException("El servicio de configuracion no puede ser obtenido");
        }
    }

    /**
     * ServiceBinder method - Llamado cuando el ServiceAdmin llega
     */
    public void addSettingsAdmin(SettingsAdmin svc) {
        Activator.getLog().info("Estableciendo el servicio de configuracion");
        _settingsAdmin = svc;
    }

    /**
     * ServiceBinder method - Llamado cuando el ServiceAdmin abandona el
     * componente
     */
    public void removeSettingsAdmin(SettingsAdmin svc) {
        Activator.getLog().info("Eliminando el servicio de configuracion");
        _settingsAdmin = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.service.cm.ManagedService#updated(java.util.Dictionary)
     */
    public void updated(Dictionary settings) throws ConfigurationException {
        Activator.getLog().info("Metodo de actualizacion de configuraciones no implementado");
    }

    /**
     * <p>
     * Permite determinar si todas las opciones de configuracion estan
     * establecidad
     * </p>
     */
    public static boolean isAllSetSettings() {

        SettingDefinitionMap settings = _settingsAdmin.getGlobalSettings(BUNDLE_NAME);
        Iterator iterSetting = settings.iterator();

        while (iterSetting.hasNext()) {
            SettingDefinition settingDef = (SettingDefinition) iterSetting.next();

            if (settingDef.getMinLength() > 0) {
                if (settingDef.getCurrentValue().equals(settingDef.getDefaultValue())) {
                    return false;
                }
            }
        }

        return true;
    }

}
