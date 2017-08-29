package co.com.Finamerica.Legalizacion;

import org.osgi.framework.BundleContext;

import com.lexmark.prtapp.util.AppLogRef;
import com.lexmark.prtapp.util.PrtAppActivator;
import org.osgi.framework.BundleContext;

/**
 * This is the activator for  bundle.
 */

public class Activator extends PrtAppActivator {
	static private AppLogRef _log = null;

	// Return AppLogRef so logging can be done easily. Should not be null.
	public static AppLogRef getLog() {
		return _log;
	}

	// Set up the log ref and then do the regular activation
	public void start(BundleContext bc) throws Exception {
		_log = new AppLogRef(bc);

		super.start(bc);
	}
}
