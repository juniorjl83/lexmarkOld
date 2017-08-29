/**
 * Finamerica. Copyright All Reserved. 14-jul-2010. SmbPathBuilder.java
 */
package co.com.Finamerica.Legalizacion.service;

/**
 * <p>
 * Esta clase permite construir paths para el protocolo Smb
 * </p>
 * 
 * @author <a href="mailto:">Carlos.robayo@carvajal.com</a>
 * @version 2.0
 * @since 2.0
 */
public class SmbPathBuilder {

    private static final String EMPTY_PROPERTY_PATH = "";

    private static final String SMB_PASSWORD_SEPARATOR = "@";

 //   private static final String SMB_USER_SEPARATOR = ":";
    
    public static final String SMB_USER_SEPARATOR = ":";

    private static final String SMB_DOMAIN_SEPARATOR = ";";

    public static final String SMB_TOKEN_SEPARATOR = "/";

    public static final String SMB_INIT_TOKEN = "smb://";
  

    private String directory;

    private String user;

    private String password;

    private String domain;

    /**
     * <p>
     * Establece el directorio para el path incluido el servidor
     * </p>
     * 
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * <p>
     * Establece el usuario de autenticacion
     * </p>
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * <p>
     * Establece el password de autenticacion
     * </p>
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>
     * Establece el dominio donde se encuentra la carpeta compartida
     * </p>
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * <p>
     * Devuelve el Path SMB de la localizacion
     * </p>
     */
    public String getPath() {

        StringBuffer pathBuffer = new StringBuffer();

        pathBuffer.append(SmbPathBuilder.SMB_INIT_TOKEN);

        if (domain != null && !domain.equals(EMPTY_PROPERTY_PATH)) {
            pathBuffer.append(domain).append(SMB_DOMAIN_SEPARATOR);
        }

        if (user != null &&!user.equals(EMPTY_PROPERTY_PATH)) {
            pathBuffer.append(user).append(SMB_USER_SEPARATOR).append(password).append(SMB_PASSWORD_SEPARATOR);
        }

        pathBuffer.append(directory);

        return pathBuffer.toString();
    }

}
