/**
 * Finamerica. Copyright All Reserved. 14-may-2010. ScreenFabricaCredito.java
 */
package co.com.Finamerica.Legalizacion.screen;

import java.util.List;

import co.com.Finamerica.Legalizacion.Activator;
import co.com.Finamerica.Legalizacion.service.AdminSettings;
import co.com.Finamerica.Legalizacion.service.PropertyReader;
import co.com.Finamerica.Legalizacion.service.SmbPathBuilder;
import co.com.Finamerica.Legalizacion.service.SmbService;

import com.lexmark.core.IntegerElem;
import com.lexmark.prtapp.profile.BasicProfileContext;
import com.lexmark.prtapp.prompt.PromptFactory;
import com.lexmark.prtapp.prompt.PromptFactoryException;
import com.lexmark.prtapp.std.prompts.ComboPrompt;
import com.lexmark.prtapp.std.prompts.IntegerPrompt;
import com.lexmark.prtapp.std.prompts.IntegerPrompt;
import com.lexmark.prtapp.std.prompts.MessagePrompt;
import com.lexmark.ui.DocumentWorkflow;
import com.lexmark.ui.WorkflowFactory;
import com.lexmark.ui.WorkflowSetting;
import com.lexmark.ui.WorkflowSettingCollection;

/**
 * <p>

 * 
 */
public class ScreenFabricaCredito {

    private BasicProfileContext context;

    private PromptFactory promptFactory;

    private WorkflowFactory workFlowFactory;

    public ScreenFabricaCredito(BasicProfileContext context) {
        this.context = context;
        this.promptFactory = context.getPromptFactory();
        this.workFlowFactory = context.getWorkflowFactory();
    }

    /**
     * <p>
     * Retorna el combo que muestra a que servidor se debe enviar el archivo
     * </p>
     */
    public ComboPrompt getComboSelectionServer() throws PromptFactoryException {

        ComboPrompt comboPrompt = (ComboPrompt) promptFactory.newPrompt(ComboPrompt.ID);
        comboPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER));

        String[] options = new String[3];
        options[0] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT1);
        options[1] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT2);
        options[2] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT3);

        comboPrompt.setItems(options);
        comboPrompt.setSelection(0);

        return comboPrompt;
    }

    
    public ComboPrompt getComboSelectionServer0() throws PromptFactoryException {

        ComboPrompt comboPrompt = (ComboPrompt) promptFactory.newPrompt(ComboPrompt.ID);
        comboPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER2));

        String[] options = new String[3];
        options[0] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT4);
        options[1] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT5);
        options[2] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT6);

        comboPrompt.setItems(options);
        comboPrompt.setSelection(0);

        return comboPrompt;
    }
    
    
    public ComboPrompt getComboSelectionServer1() throws PromptFactoryException {

        ComboPrompt comboPrompt = (ComboPrompt) promptFactory.newPrompt(ComboPrompt.ID);
        comboPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER3));

        String[] options = new String[3];
        options[0] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT7);
        options[1] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT8);
        options[2] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT9);

        comboPrompt.setItems(options);
        comboPrompt.setSelection(0);

        return comboPrompt;
    }
    
    public ComboPrompt getComboSelectionServer2() throws PromptFactoryException {

        ComboPrompt comboPrompt = (ComboPrompt) promptFactory.newPrompt(ComboPrompt.ID);
        comboPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER4));

        String[] options = new String[3];
        options[0] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT10);
        options[1] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT11);
        options[2] = PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_COMBO_LABEL_SELSER_OPT12);

        comboPrompt.setItems(options);
        comboPrompt.setSelection(0);

        return comboPrompt;
    }



    
    
    
    /**
     * <p>
     * Retorna el prompt para ingresar la llave
     * </p>
     */
    public IntegerPrompt getIntegerSelectionId() throws PromptFactoryException {

    	IntegerPrompt integerPrompt = (IntegerPrompt) promptFactory.newPrompt(IntegerPrompt.ID);
        integerPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
                .getProperty(PropertyReader.PROMPT_INTEGER_LABEL_SELCED));

        return integerPrompt;
    }
    public IntegerPrompt getIntegerSelectionId2() throws PromptFactoryException {

    	IntegerPrompt integerPrompt = (IntegerPrompt) promptFactory.newPrompt(IntegerPrompt.ID);
    	integerPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
               .getProperty(PropertyReader.PROMPT_INTEGER_LABEL_SELCED2));

       return integerPrompt;
   }
    public IntegerPrompt getIntegerSelectionId0() throws PromptFactoryException {

       IntegerPrompt integerPrompt = (IntegerPrompt) promptFactory.newPrompt(IntegerPrompt.ID);
       integerPrompt.setLabel(PropertyReader.getInstance(context.getLocale())
               .getProperty(PropertyReader.PROMPT_INTEGER_LABEL_SELCED0));

       return integerPrompt;
   }

    /**
     * <p>
     * Retorna el Document Workflow para la aplicacion
     * </p>
     */
    public DocumentWorkflow getDocumentWorkFlow() {

        DocumentWorkflow dw = (DocumentWorkflow) workFlowFactory.create(WorkflowFactory.DOCUMENT);

        // Set Settings for Workflow
        WorkflowSettingCollection wfsettings = dw.getSettingCollection();
        List namesSettings = wfsettings.getSettingNames();

        for (int i = 0; i < namesSettings.size(); i++) {
            String nameSetting = (String) namesSettings.get(i);
            WorkflowSetting wfSetting = wfsettings.getSetting(nameSetting);
            wfSetting.lock();
        }

        WorkflowSetting stFileFormat1 = wfsettings.getSetting("fileFormat");
       stFileFormat1.setInfo(new IntegerElem(0));
        
        WorkflowSetting stFileFormat = wfsettings.getSetting("multiPageTiff");
        stFileFormat.setInfo(new IntegerElem(0));

        WorkflowSetting contentType = wfsettings.getSetting("contentType");
        contentType.setInfo(new IntegerElem(0));

        WorkflowSetting scanDuplex = wfsettings.getSetting("scanDuplex");
        scanDuplex.setInfo(new IntegerElem(2));

        WorkflowSetting orientation = wfsettings.getSetting("orientation");
        orientation.setInfo(new IntegerElem(0));

        WorkflowSetting resolution = wfsettings.getSetting("resolution");
        resolution.setInfo(new IntegerElem(200));

        WorkflowSetting originalMediaSize = wfsettings.getSetting("originalMediaSize");
        originalMediaSize.setInfo(new IntegerElem(9));
        
        WorkflowSetting fondo = wfsettings.getSetting("backgroundRemoval");     
      //  String background = (String)AdminSettings.getSetting(AdminSettings.SETTINGS_BACKGROUND);        
        //fondo.setInfo(new IntegerElem(Integer.parseInt(background)));
        
        
        String background = "04";        
        fondo.setInfo(new IntegerElem(Integer.parseInt(background)));
        
        
        WorkflowSetting scanPrev = wfsettings.getSetting("scanPreview");
        scanPrev.setInfo(new IntegerElem(1));

        return dw;
    }

    /**
     * <p>
     * Retorna el Message Prompt para la aplicacion cuando la configuracion no
     * esta establecida correctamente
     * </p>
     */
    public MessagePrompt getMessageSettingPrompt() throws PromptFactoryException {

      //  if (!AdminSettings.isAllSetSettings()) {
         //   String message = PropertyReader.getInstance(context.getLocale()).getProperty(PropertyReader.PROMPT_MESSAGE_LABEL_SETTINGNOTSET);
    	String message ="Esta encuesta la podrás diligenciar el número de veces que consideres necesario         +"
    			+ "                                               ¡Muchas gracias por ayudarnos a mejorar nuestro servicio!";
            MessagePrompt configurePrompt = (MessagePrompt) promptFactory
                    .newPrompt(MessagePrompt.ID);
            configurePrompt.setMessage(message);

            return configurePrompt;
            
            
  //     }

      //  return null;
    }

    /**
     * <p>
     * Retorna el Message Prompt para la aplicacion cuando el servidor
     * seleccionado no esta disponibles
     * </p>
     */
    public MessagePrompt getMessageServerPrompt(long idServerSelection)
            throws PromptFactoryException {

        try {
            SmbPathBuilder pathBuilder = new SmbPathBuilder();

            pathBuilder.setDomain((String) AdminSettings
                    .getSetting(AdminSettings.SETTINGS_DOMAIN_SERVER));

            pathBuilder.setUser((String) AdminSettings.getSetting(AdminSettings.SETTINGS_USER_SERVER));

            pathBuilder.setPassword((String) AdminSettings
                    .getSetting(AdminSettings.SETTINGS_PASSWORD_SERVER));

            if (idServerSelection == 0) {
                pathBuilder.setDirectory((String) AdminSettings
                        .getSetting(AdminSettings.SETTINGS_NEW_SERVER));
            } else if (idServerSelection == 1) {
                pathBuilder.setDirectory((String) AdminSettings
                        .getSetting(AdminSettings.SETTINGS_RE_SERVER));
            } else {
                pathBuilder.setDirectory((String) AdminSettings
                        .getSetting(AdminSettings.SETTINGS_COT_SERVER));
            }
            
            Activator.getLog().info("path: " + pathBuilder.getPath());
            
            if (!SmbService.existLocation(pathBuilder.getPath())) {
            	String message = PropertyReader.getInstance(context.getLocale())
                        .getProperty(PropertyReader.PROMPT_MESSAGE_LABEL_SERVERNOTSET);
                MessagePrompt configurePrompt = (MessagePrompt) promptFactory
                        .newPrompt(MessagePrompt.ID);
               configurePrompt.setMessage(message);
              return configurePrompt;
            }
            
            return null;

        } catch (PromptFactoryException e) {
            throw e;
        }
    }

    /**
     * <p>
     * Carlos Robayo
     * Retorna el Message Prompt para la aplicacion cuando el registro ingresado es distinto
     * </p>
     */
    public MessagePrompt getMessageRegisdiferent() throws PromptFactoryException {

        if (!AdminSettings.isAllSetSettings()) {
            String message = PropertyReader.getInstance(context.getLocale())
                    .getProperty(PropertyReader.PROMPT_MESSAGE_LABEL_REGISDIFEREN);

            MessagePrompt configurePrompt = (MessagePrompt) promptFactory
                    .newPrompt(MessagePrompt.ID);
            configurePrompt.setMessage(message);

            return configurePrompt;
        }

        return null;
    }

}