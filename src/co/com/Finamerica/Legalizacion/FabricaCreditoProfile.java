package co.com.Finamerica.Legalizacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Date;
import java.util.Locale;
import java.util.Dictionary;

import com.lexmark.prtapp.std.prompts.BooleanPrompt;
import com.lexmark.core.BooleanElem;
import com.lexmark.core.IntegerElem;
import com.lexmark.core.MapElem;
import com.lexmark.prtapp.profile.BasicProfileContext;
import com.lexmark.prtapp.profile.PrtappProfile;
import com.lexmark.prtapp.profile.PrtappProfileException;
import com.lexmark.prtapp.std.prompts.BooleanPrompt;
import com.lexmark.prtapp.std.prompts.ComboPrompt;



import com.lexmark.ui.Workflow;
import com.lexmark.ui.WorkflowFactory;
import com.lexmark.ui.WorkflowSetting;
import com.lexmark.ui.WorkflowSettingCollection;

import java.util.Locale;

import com.lexmark.prtapp.std.prompts.MessagePrompt;
import com.lexmark.prtapp.prompt.PromptException;
import com.lexmark.prtapp.prompt.PromptFactory;
import com.lexmark.prtapp.util.Messages;
import com.lexmark.ui.Workflow;
import com.lexmark.ui.WorkflowFactory;
import com.lexmark.ui.WorkflowSetting;
import com.lexmark.ui.WorkflowSettingCollection;

import jcifs.smb.SmbFile;

import java.text.SimpleDateFormat;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import jcifs.smb.SmbFileInputStream;

import org.ungoverned.gravity.servicebinder.ServiceBinderContext;

import co.com.Finamerica.Legalizacion.logic.FabricaCredito;
import co.com.Finamerica.Legalizacion.logic.IFabricaCredito;
import co.com.Finamerica.Legalizacion.screen.ScreenFabricaCredito;
import co.com.Finamerica.Legalizacion.service.AdminSettings;
import co.com.Finamerica.Legalizacion.service.PropertyReader;
import co.com.Finamerica.Legalizacion.service.SmbService;
import co.com.Finamerica.Legalizacion.service.SmbPathBuilder;


import co.com.Finamerica.Legalizacion.EasyPrompt;

import com.lexmark.prtapp.profile.BasicNavigator;
import com.lexmark.prtapp.profile.BasicProfileContext;
import com.lexmark.prtapp.profile.PrtappProfile;
import com.lexmark.prtapp.profile.PrtappProfileException;
import com.lexmark.prtapp.profile.WelcomeScreenable;
import com.lexmark.prtapp.scan.ScanConsumer;
import com.lexmark.prtapp.std.prompts.ComboPrompt;
import com.lexmark.prtapp.std.prompts.IntegerPrompt;
import com.lexmark.prtapp.std.prompts.MessagePrompt;
import com.lexmark.prtapp.std.prompts.MultipleSelectionListPrompt;
import com.lexmark.ui.DocumentWorkflow;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import com.lexmark.prtapp.newcharacteristics.DeviceCharacteristicsService;
import com.lexmark.prtapp.prompt.PromptException;
import com.lexmark.prtapp.prompt.PromptFactory;
import com.lexmark.prtapp.prompt.PromptFactoryException;
import com.lexmark.prtapp.settings.SettingDefinition;
import com.lexmark.prtapp.settings.SettingDefinitionMap;
import com.lexmark.prtapp.settings.SettingsAdmin;
import com.lexmark.prtapp.util.BundleUtilities;
import com.lexmark.prtapp.util.Messages;
import com.lexmark.prtapp.welcomescreen.Placeholder;
import com.lexmark.prtapp.welcomescreen.ProfileButton;
import com.lexmark.prtapp.welcomescreen.ScreenLayout;
import com.lexmark.prtapp.welcomescreen.Spacer;
import com.lexmark.prtapp.welcomescreen.StandardFunctionButton;
import com.lexmark.prtapp.welcomescreen.WelcomeScreen;
import com.lexmark.prtapp.welcomescreen.WelcomeScreenButton;
import com.lexmark.prtapp.welcomescreen.WelcomeScreenButton.BoundingRect;
import com.lexmark.ui.WorkflowFactory;
import com.lexmark.ui.WorkflowSetting;
import com.lexmark.prtapp.profile.BasicProfileContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;

import com.lexmark.prtapp.imageserver.ImageServer;
import com.lexmark.prtapp.profile.BasicProfileContext;
import com.lexmark.prtapp.profile.PrtappProfile;
import com.lexmark.prtapp.profile.PrtappProfileException;
import com.lexmark.prtapp.prompt.PromptException;
import com.lexmark.prtapp.prompt.PromptFactory;
import com.lexmark.prtapp.std.prompts.MessagePrompt;
import com.lexmark.prtapp.std.prompts.StringPrompt;
import com.lexmark.prtapp.storagedevice.StorageDevice;
import com.lexmark.prtapp.util.Messages;
import com.lexmark.prtapp.webdav.ProxyHelper;

import com.lexmark.prtapp.profile.BasicProfileContext;
import com.lexmark.prtapp.profile.PrtappProfile;
import com.lexmark.prtapp.profile.PrtappProfileException;
import com.lexmark.prtapp.std.prompts.MessagePrompt;
import com.lexmark.prtapp.prompt.PromptException;
import com.lexmark.prtapp.prompt.PromptFactory;
import com.lexmark.prtapp.prompt.PromptUtil;
import com.lexmark.prtapp.util.Messages;


public class FabricaCreditoProfile implements PrtappProfile, WelcomeScreenable {
	
	
	 WelcomeScreen _welcomeScreenService = null;
	 
	// private JobService jobService = null;

    /*
     * El ID (unico) de profile para la fabrica de credito
     */
    private static final String ID_PROFILE = "FabricaCreditoProfile1";

    private static final String icon = "/icon2.gif";
    private static final String icon2 = "/icon3.gif";
    
    private static final int BUFFER_SIZE = 32767;

    protected ServiceBinderContext _sbc = null;
    //carlos 28 de junio.
    private String _shareName = null;

    //para smb
    private final String appName;


    private SettingsAdmin settingsAdmin = null;
    private DeviceCharacteristicsService characteristicsService = null;
    
    /**
     * Constructor called by Service Binder. We need to keep track of the
     * context, since it allows us access to our own bundle.
     */
    public FabricaCreditoProfile(ServiceBinderContext sbc) {
        _sbc = sbc;
        appName = BundleUtilities.getName(sbc.getBundleContext().getBundle());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.PrtappProfile#getId()
     */
    public String getId() {
        return ID_PROFILE;
    }
    
    //mio


    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.PrtappProfile#getName(java.util.Locale)
     */
    public String getName(Locale locale) {
    	Activator.getLog().info("e:   ");
        String profileName = PropertyReader.getInstance(locale).getProperty("profile.name");
        return profileName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.PrtappProfile#getShortcut()
     */
    public int getShortcut() {
        return 0;
    }


    public void go(BasicProfileContext context) throws PrtappProfileException {
    	
        try
        {
            SettingDefinitionMap settings = settingsAdmin.getGlobalSettings("Survey");
            SettingDefinition dominioConf = settings.get("settings.promptDominio");
            SettingDefinition userConf = settings.get("settings.promptUser");
            SettingDefinition passConf = settings.get("settings.promptPassword");
            SettingDefinition pathConf = settings.get("settings.promptPath");
            String path = "";
            String user = "";
            String pass = "";
            String dominio = "";
            
            try
            {
               path = (String)pathConf.getCurrentValue(context.getLocale());
               user = (String)userConf.getCurrentValue(context.getLocale());
               pass = (String)passConf.getCurrentValue(context.getLocale());
               dominio = (String)dominioConf.getCurrentValue(context.getLocale());
               
            }
            catch(NoSuchMethodError e)
            {
               path = (String)pathConf.getCurrentValue();
               user = (String)userConf.getCurrentValue();
               pass = (String)passConf.getCurrentValue();
               dominio = (String)dominioConf.getCurrentValue();
            }
            
            
        	int resul=0;
        	int buresul=0;
        	
        	if ( path == null || path.length() == 0 ){
        	   //path="smb://AMDEPRN02;administrator:admin2008*@172.28.3.4//Encuesta/Registros.txt";
        	   path="smb://Giovanny:carlos14@192.168.1.64//Imagenes_Onbase/1030-Pasivo/01B.txt";
        	   Activator.getLog().info("path de emergencia");
        	   Activator.getLog().info(path);
        	}else{
        	   Activator.getLog().info("path configurado");
        	   path="smb://" + dominio + ";" + user + ":" + pass + "@" + path;
        	   Activator.getLog().info(path);
        	}
        	
        	//String path="smb://AMDEPRN02;administrator:admin2008*@172.28.3.4//Encuesta/Registros.txt";
			//String path="smb://Bancolombia;SVCRFX01:Pa$$word2009*@10.8.45.33//Aplicaci/Registros.txt";
			//String path="smb://Giovanny:carlos14@192.168.1.64//Imagenes_Onbase/1030-Pasivo/01B.txt";
        		   
    		do{
    		   StringBuffer sb = new StringBuffer("");
    		   boolean enviaCorreo = false;
			   PromptFactory pf = context.getPromptFactory();
			   EasyPrompt ep = new EasyPrompt();
			   context.displayPrompt(ep);
			   resul=ep.cualsel();

	           ScreenFabricaCredito screen = new ScreenFabricaCredito(context);
	           MessagePrompt messageValidation = screen.getMessageSettingPrompt();

	           int selectServer00=10;
	           int selectServer11=10;
	           int selectServer22=10;

			   //bueno
			   if (resul==1) {
				   sb.append("A");
				   BuenoPrompt bn = new BuenoPrompt();
	               context.displayPrompt(bn);
	    		   buresul=bn.bcualsel();
			   }
			   //medio
    		   else if (resul==2) {
    			   sb.append("B");
	               medio md = new medio();
	               context.displayPrompt(md);
	               buresul=md.bcualsel();
	           //  return;
    	       }
    		   else if (resul==3) { 
    			   sb.append("C");
         		   enviaCorreo = true;
    	           malo ml = new malo();
	               context.displayPrompt(ml);
	               buresul=ml.bcualsel();
    	       }
			   
			   FinalPrompt fp = new FinalPrompt();
			   boolean showFinalProm = false;
			    
			   if(buresul==1){
			      Activator.getLog().info("A");
				   sb.append("A");
				   showFinalProm = true;
	      	   }else if (buresul==2){
	      	    Activator.getLog().info("B");
	      		   sb.append("B");
	      		   showFinalProm = true;
	      	   }else if (buresul==3){
	      	    Activator.getLog().info("C");
	      		   sb.append("C");
	      		   showFinalProm = true;
	      	   }
			   if ( showFinalProm ){
	      		   sendLog(sb, path, enviaCorreo); 
                   context.displayPrompt(fp);
			   }
        			   
            }while(buresul==5); 
			
            return;
        
        } catch (Exception e) {
            Activator.getLog().info(e.getMessage());
            return;
        }  
      }

    public void sendLog(StringBuffer sb, final String path, final boolean enviaCorreo){
		
    	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      	sb.append(",");
      	sb.append(dt.format(new Date()));
      	String ip = "192.168.1.65";
      	 
      	try{
      		ip = characteristicsService.get("serialNumber");
      		Activator.getLog().info("serial number");
      	}catch(Exception e){
      		Activator.getLog().info("error serial number");
      	}
      	 
      	sb.append(",");
      	sb.append(ip);
    	
      	final String msg = sb.toString();
    	
		   /*new Thread(new Runnable() {
			public void run() {*/

				try{
				   Activator.getLog().info("antes de abril el archivo");
					SmbFile sFile = new SmbFile(path);
					if ( sFile.exists() ){
					   Activator.getLog().info("Existe");
					}else{
					   Activator.getLog().info("No existe");
					}
					
	        		 SmbFileInputStream sfis = new SmbFileInputStream(sFile);
		   			 BufferedReader br = new BufferedReader(new InputStreamReader(sfis));
		   			 String line= "";
		   			 StringBuffer sb1 = new StringBuffer("");
		   			
		   			 while ((line = br.readLine()) != null){
		   		     	sb1.append(line);
		   				sb1.append("\n");
		   			 }
		   			 br.close();
		       		 
		           	 sb1.append(msg);
		           	 OutputStream ipSbmoutTecno = sFile.getOutputStream();
		   			 ipSbmoutTecno.write(sb1.toString().getBytes());
		   			 ipSbmoutTecno.close();
		       		 
		   			 if ( enviaCorreo ){
		   				 Activator.getLog().info("enviar correo");
		       		 }
		   			 
		   			 Activator.getLog().info("envio satisfactorio");
		   			 
					}catch (Exception e){
						Activator.getLog().info("Error escribiendo log");
						
						StackTraceElement[] stack = e.getStackTrace();
						
						for (int i=0; i < stack.length;i++){
						   
						   Activator.getLog().info(stack[i].toString());
						}
						
					}
				
			//}
		//}).start();
    	
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.WelcomeScreenable#getUpIcon()
     */
    public InputStream getUpIcon() {
        InputStream iconStream = getClass().getResourceAsStream(icon);
        return iconStream;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.WelcomeScreenable#getDownIcon()
     */
    public InputStream getDownIcon() {
        InputStream iconStream = getClass().getResourceAsStream(icon2);
        return iconStream;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.WelcomeScreenable#getIconText(java.util.Locale)
     */
    public String getIconText(Locale locale) {
        return PropertyReader.getInstance(locale).getProperty(PropertyReader.ICON_NAME);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.profile.WelcomeScreenable#getWorkflowOveride()
     */
    public String getWorkflowOveride() {
        return null;
    }
   
    // TODO: metodo nuevo
    public boolean showInHeldJobsList() {
        return false;
    }
///para smb
    

    /**
     * ServiceBinder method - called when SettingsAdmin arrives
     */
    public void addSettingsAdmin(SettingsAdmin svc)
    {
       settingsAdmin = svc;
    }

    /**
     * ServiceBinder method - called when SettingsAdmin leaves town
     */
    public void removeSettingsAdmin(SettingsAdmin svc)
    {
       settingsAdmin = null;
    }


    /**
     * ServiceBinder method - called when DeviceCharacteristicsService arrives
     */
    public void addDeviceCharacteristics(DeviceCharacteristicsService svc)
    {
       characteristicsService = svc;
    }   
    
    /**
     * ServiceBinder method - called when DeviceCharacteristicsService leaves town
     */
    public void removeDeviceCharacteristics(DeviceCharacteristicsService svc)
    {
       characteristicsService = null;
    }   
    
    /* (non-Javadoc)
     * @see org.osgi.service.cm.ManagedService#updated(java.util.Dictionary)
     */
    public void updated(Dictionary arg0) throws ConfigurationException
    {
       // This is required for an app that receives settings. But we just
       // access the settings through Settings Admin, so no need to do
       // anything here.
    }
    private void setCannedLayout(Locale locale) throws IOException
    {
       // Copy with the standard text and icon.
       StandardFunctionButton copy = new StandardFunctionButton(null, StandardFunctionButton.STD_COPY);

       // NOTE: A placeholder might be filled if an "extra" button or button added
       // through WelcomeScreenable is added.
       Placeholder spot = new Placeholder();
       
       // This one uses a custom icon. Note that we do it differently depending on whether
       // we're running on quarter VGA or full VGA.
       // Another way to do this would be to set up two binary settings - one for
       // up icon and one for down - and use those.  That way the user becomes 
       // responsible for putting up the correct icon.
       // We have to either have both or have neither
       byte[] buttonUp = null;
       byte[] buttonDown = null;
       BoundingRect bounds = null;
       
   
       
          buttonUp = BundleUtilities.getResourceAsBinary(_sbc.getBundleContext().getBundle(), "smiley_up.gif");
          buttonDown = BundleUtilities.getResourceAsBinary(_sbc.getBundleContext().getBundle(), "smiley_down.gif");

       
       ProfileButton profile = new ProfileButton("Set Layout", getName(locale), buttonUp, buttonDown, bounds);

       // Spacer - this will always be a space and nothing can take its place.
       Spacer space = new Spacer();
       
       // E-mail with modified text.
       StandardFunctionButton email = new StandardFunctionButton("E-e-mail!", StandardFunctionButton.STD_EMAIL);
       
       // Now shove all these buttons in an array and set the welcome screen.
       WelcomeScreenButton[] buttons = new WelcomeScreenButton[]
       { copy, spot, profile, email, space };
       
       // Fixed layout ensures no more than the number of buttons specified
       // (here, 5) will show up on the first screen.  Any additional buttons
       // (such as those created with WelcomeScreenable) will show up first
       // in any explicit placeholders, and then on the next screen.
       
       // See the ScreenLayout javadoc for info on other layout types.
       ScreenLayout layout = ScreenLayout.newFixedLayout(5);
       
       _welcomeScreenService.setScreenInfo(layout, buttons);
    }
/*    
    public void addJobService(JobService svc)
    {
       jobService = svc;
    }
    
    *//**
     * ServiceBinder method called when we lose the Job Service
     *//*
    public void removeJobService(JobService svc)
    {
       jobService = null;
    }*/
}
