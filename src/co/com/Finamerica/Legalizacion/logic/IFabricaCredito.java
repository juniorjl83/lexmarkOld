/**
 * Finamerica. Copyright All Reserved. 13-may-2010. IFabricaCredito.java
 */
package co.com.Finamerica.Legalizacion.logic;

import com.lexmark.prtapp.scan.ScanConsumer;


public interface IFabricaCredito {
    
    
    /**
     * <p>
     * Permite obtener el scan consumer para realizar la digitalizacion de la
     * fabrica de credito
     * </P>
     */
   // ScanConsumer getScanConsumer(int idServerSelection, String idUser);
    
    ScanConsumer getScanConsumero();
    
}
