/**
 * Finamerica. Copyright All Reserved. 12-may-2010. SvcService.java
 */
package co.com.Finamerica.Legalizacion.service;

import jcifs.Config;
import jcifs.smb.SmbFile;
import co.com.Finamerica.Legalizacion.Activator;

/**
 * <p>
 * Esta clase permite enviar archivos a carpetas compartidas.
 * </p>
 * 
 * @author <a href="mailto:">hhh</a>
 * @version 1.0
 * @since 1.0
 */
public class SmbService {

   private static final String JCIFS_NETBIOS_WINS = "jcifs.netbios.wins";

   public static final String PDF_EXT = ".tif";

   public static final String SMB_SEPARATOR_TOKEN = "-";

   public static final String PDF_EXT_U = ".U";

   public static void setWinsSever(String ip) {
       Config.setProperty(JCIFS_NETBIOS_WINS, ip);
   }

   /**
    * <p>
    * Permite determinar si existe un archivo en la carpeta compartida
    * </p>
    */
   public static boolean existLocation(String path) {
       try {
           SmbFile smb = new SmbFile(path);
           return smb.exists();
       } catch (Exception e) {
         //  Activator.getLog().info(e.getMessage());
           return false;
       }
   }
  
   
   
}