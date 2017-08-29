/**
 * Finamerica. Copyright All Reserved. 13-may-2010. ServiceException.java
 */
package co.com.Finamerica.Legalizacion.service;

/**
 * <p>
 * Excepcion para los componentes de servicio
 * </p>
 * 
 * @author <a href="mailto:">ghjkl</a>
 * @version 1.0
 * @since 1.0
 * 
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
   /**
    * @see RuntimeException(<code>String</code>)
    */
    public ServiceException(String message) {
        super(message);
    }
    
    /**
     * @see RuntimeException(<code>String</code>, <code>Throwable</code>)
     */
    public ServiceException(String message, Exception throwable) {
        super(message + throwable);
    }
    
    /**
     * @see RuntimeException(<code>Throwable</code>)
     */
    public ServiceException(Exception throwable) {
        super(throwable.getMessage());
    }

}
