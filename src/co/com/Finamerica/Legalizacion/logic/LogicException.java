/**
 * Finamerica. Copyright All Reserved. 13-may-2010. LogicException.java
 */
package co.com.Finamerica.Legalizacion.logic;

/**
 * <p>
 * Excepcion para los componentes de logica
 * </p>
 * 
 * @author <a href="mailto:">Administrador</a>
 * @version 1.0
 * @since 1.0
 * 
 */
public class LogicException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    /**
     * @see RuntimeException(<code>String</code>)
     */
    public LogicException(String message) {
        super(message);
    }

    /**
     * @see RuntimeException(<code>String</code>, <code>Throwable</code>)
     */
    public LogicException(String message, Exception throwable) {
        super(message + throwable);
    }

    /**
     * @see RuntimeException(<code>Throwable</code>)
     */
    public LogicException(Exception throwable) {
        super(throwable.getMessage());
    }
}
