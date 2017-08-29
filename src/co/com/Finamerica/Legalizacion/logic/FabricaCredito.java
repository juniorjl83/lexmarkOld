/**
 * Finamerica. Copyright All Reserved. 13-may-2010. FabricaCredito.java
 */
package co.com.Finamerica.Legalizacion.logic;

import co.com.Finamerica.Legalizacion.service.AdminSettings;
import co.com.Finamerica.Legalizacion.service.SmbPathBuilder;
import co.com.Finamerica.Legalizacion.service.SmbService;

import com.lexmark.prtapp.scan.ScanConsumer;







import co.com.Finamerica.Legalizacion.Activator;

/**
 * <p>
 * Clase de logica de fabrica de credito
 * <p>
 * 
 * @author <a href="mailto:</a>
 * @version 1.0
 * @since 1.0
 * 
 */
public class FabricaCredito implements IFabricaCredito {

    /*
     * (non-Javadoc)
     * 
     * @see co.com.finamerica.fabricacredito.logic.IFabricaCredito#getScanConsumer()
     */


    public ScanConsumer getScanConsumero() {

        SmbPathBuilder pathBuilder = new SmbPathBuilder();

        pathBuilder.setUser((String) "HP");
        pathBuilder.setPassword((String) "carlos");
        String serverPath = null;
        String nameOffice = null;
        String dirC = null;        
        String codeOffice = null;
        serverPath = (String) "192.168.1.10";
        nameOffice = "conpartida";
        codeOffice = "archivoCreado3";
        dirC = "C";
       
       
        StringBuffer path = new StringBuffer();
        
        path.append(serverPath).append(SmbPathBuilder.SMB_TOKEN_SEPARATOR);
    //    path.append(dirC).append(SmbPathBuilder.SMB_USER_SEPARATOR).append(SmbPathBuilder.SMB_TOKEN_SEPARATOR).append(nameOffice).append(SmbPathBuilder.SMB_TOKEN_SEPARATOR);
           path.append(SmbPathBuilder.SMB_TOKEN_SEPARATOR).append(nameOffice).append(SmbPathBuilder.SMB_TOKEN_SEPARATOR);

        path.append(codeOffice).append(SmbService.PDF_EXT);
        pathBuilder.setDirectory(path.toString());
        
       // Activator.getLog().info(pathBuilder.getPath().toString());
        
        return new FabricaCreditoConsumer(pathBuilder.getPath());
    }
    
}
