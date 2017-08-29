package co.com.Finamerica.Legalizacion;

import java.util.Random;

import com.lexmark.core.Element;
import com.lexmark.prtapp.prompt.BaseVlmlPrompt;
import com.lexmark.prtapp.prompt.Prompt;
import com.lexmark.prtapp.prompt.PromptEventResult;
import com.lexmark.prtapp.prompt.PromptException;
import com.lexmark.prtapp.profile.VlmlNavigator;
import com.lexmark.prtapp.prompt.DisplayType;
import com.lexmark.prtapp.prompt.VlmlPrompt;
import com.lexmark.prtapp.prompt.VlmlPromptContext;


public class medio implements VlmlPrompt
{
   /** We need to keep track of the VLML prompt context ourselves here */
   VlmlPromptContext context = null;
   
   /** Name of the top level VLML layout */
   String vlmlName = "medio";
   
   /** Keep track of how we are dismissed so the profile can know */
   String dismissButton = "";
   
   int bsel=0;
   
   /**
    * Gratuitous constructor.  Initialization work is usually done in "init".
    */
   public medio()
   {
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.VlmlPrompt#getVlml()
    */
   public String getVlml()
   {
      // The prompt must provide all of the VLML.  While there are ways to get the navigator bar
      // VLML, usually if you want to do that, you'd use the BaseVlmlPrompt, as is done in the
      // EasyPrompt
      StringBuffer screen = new StringBuffer();
      
      screen.append("  <FixedLayout name=\"main\">\n");
      screen.append("  <!--  STANDARD NAVIGATION BAR   -->\n");
      
      
      
      screen.append("  <GridLayout name=\"buen\" distribution=\"homogeneous\" columns=\"10\" rows=\"10\" spacing=\"0\" verticalScroll=\"never\" horizontalScroll=\"never\">\n");
      
      

      
      screen.append("  <AttachChild left=\"0\" right=\"9\" top=\"1\" bottom=\"2\"  xGFill=\"expandFill\" yGFill=\"expandFill\">\n");
    		  screen.append("  <Label name=\"label\" pointSize=\"22\" text=\" ¿ Cuál es la razón para estar satisfecho ?\" lineWrap=\"false\" justification=\"center\" style=\"normal\" color=\"FF7F00\"/>\n");
    		  screen.append("  </AttachChild>\n");    		  
    		  
            screen.append("  <AttachChild left=\"0\" right=\"9\" top=\"4\" bottom=\"9\" xFill=\"shrink\" xPadding=\"100\" yFill=\"expand\" yPadding=\"0\">\n");
    		  screen.append("  <SelectionGroup name=\"testSelectionGroup\" orientation=\"vertical\" maxSelections=\"1\">\n");
    		  screen.append("  <Defaults>\n\");redscreen.append(\"  </Defaults>\n");
    		  screen.append("  <Selection name=\"red\">\n");
    		  screen.append("  <DeselectedImage imageName=\"commonListButtonUp\"/>\n");
    		  screen.append("  <SelectedImage imageName=\"commonListButtonDown\"/>\n");
    		  screen.append("  <Label text=\"Algunas opciones no son faciles de usar\" location=\"left\"/>\n");
    		  screen.append("  </Selection>\n");
    		  screen.append("  <Selection name=\"orange\">\n");
    		  screen.append("  <DeselectedImage imageName=\"commonListButtonUp\"/>\n");
    		  screen.append("  <SelectedImage imageName=\"commonListButtonDown\"/>\n");
    		  screen.append("  <Label text=\"Algunas veces no está disponible\" location=\"left\"/>\n");
    		  screen.append("  </Selection>\n");
    		  screen.append("  <Selection name=\"yellow\">\n");
    		  screen.append("  <DeselectedImage imageName=\"commonListButtonUp\"/>\n");
    		  screen.append("  <SelectedImage imageName=\"commonListButtonDown\"/>\n");
    		  screen.append("  <Label text=\"No siempre cumple con las necesidades\" location=\"left\"/>\n");
    		  screen.append("  </Selection>\n");
    		  screen.append("  </SelectionGroup>\n");
    		  screen.append("  </AttachChild>\n");      
           
    		  screen.append("  </GridLayout>\n");
      
      
      
      
      
      screen.append("  <AttachChild xCoordinate=\"0\" yCoordinate=\"408\">\n");
      screen.append("  <Image name=\"separatorBar\" imageName=\"NavRowBottomLine\"/>\n");
      screen.append("  </AttachChild>\n");
      screen.append("  <AttachChild xCoordinate=\"0\" yCoordinate=\"410\">\n");
      screen.append("  <GridLayout name=\"nav\" rows=\"1\" columns=\"640\" distribution=\"homogeneous\" color=\"b2b2b2\">\n");
      screen.append("  <!--  HELP BUTTON   -->\n");
      screen.append("  <AttachChild xFill=\"shrink\" yFill=\"shrink\" yPadding=\"2\" left=\"2\" right=\"52\" top=\"0\" bottom=\"1\">\n");
      screen.append("  <LabeledImageButton name=\"help\">\n");
      screen.append("  <Normal imageName=\"tipUp\" text=\"\"/>\n");
      screen.append("  <Selected imageName=\"tipDown\"/>\n");
      screen.append("  </LabeledImageButton>\n");
      screen.append("  </AttachChild>\n");
      screen.append("  <!--  CANCEL BUTTON   -->\n");
      screen.append("  <AttachChild xFill=\"shrink\" yFill=\"shrink\" xPadding=\"0\" yPadding=\"2\" left=\"284\" right=\"344\" top=\"0\" bottom=\"1\">\n");
      screen.append("  <LabeledImageButton name=\"cancel\">\n");
      screen.append("  <Normal imageName=\"homeUp\" text=\"\"/>\n");
      screen.append("  <Selected imageName=\"homeDown\"/>\n");
      screen.append("  </LabeledImageButton>\n");
      screen.append("  </AttachChild>\n");
      screen.append("  <!--  BACK BUTTON   -->\n");
      screen.append("  <AttachChild xFill=\"shrink\" yFill=\"shrink\" xPadding=\"0\" yPadding=\"2\" left=\"344\" right=\"438\" top=\"0\" bottom=\"1\">\n");
      screen.append("  <LabeledImageButton name=\"back\" overlayPointSize=\"16\" overlayStyle=\"bold\" state=\"NORMAL\">\n");
      screen.append("  <Normal imageName=\"optionsMiddleUp\" text=\"atrás\"/>\n");
      screen.append("  <Selected imageName=\"optionsMiddleDown\" text=\"atrás\"/>\n");
      screen.append("  <Inactive imageName=\"optionsMiddleNa\"/>\n");
      screen.append("  </LabeledImageButton>\n");
      screen.append("  </AttachChild>\n");
      screen.append("  <!--  NEXT BUTTON   -->\n");
      screen.append("  <AttachChild xFill=\"shrink\" yFill=\"shrink\" xPadding=\"0\" yPadding=\"2\" left=\"438\" right=\"540\" top=\"0\" bottom=\"1\">\n");
      screen.append("  <LabeledImageButton name=\"next\" overlayPointSize=\"16\" overlayStyle=\"bold\" state=\"NORMAL\">\n");
      screen.append("  <Normal imageName=\"navRowOptionsUp\" text=\"siguiente\"/>\n");
      screen.append("  <Selected imageName=\"navRowOptionsDown\" text=\"siguiente\"/>\n");
      screen.append("  <Inactive imageName=\"navRowOptionsNa\"/>\n");
      screen.append("  </LabeledImageButton>\n");
      screen.append("  </AttachChild>\n");
      screen.append("  </GridLayout>\n");
      screen.append("  </AttachChild>\n");
      screen.append("  </FixedLayout>\n");
      
      ;
      
      return screen.toString();
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.VlmlPrompt#handleEvent(java.lang.String, java.lang.String, com.lexmark.core.Element)
    */
   public PromptEventResult handleEvent(String component, String event,
         Element data) throws PromptException
   {
	   
	   //Activator.getLog().info("dattt:   "+component);
      /**
       * Since there is no navigator bar when we directly implement VlmlPrompt, we get all
       * the events, and if we don't handle something, nobody will.  The exception is the
       * hard Home button - it automatically cancels the prompt.
       */
      PromptEventResult result = null;      // NULL means we didn't handle the event

     // Activator.getLog().debug("EasyPrompt: got a VLML event!\n\tComponent = " + component + "\n\tEvent = " + event + "\n\t" + data.print("Data"));

      // If a hardware key was pressed, display something in one of our labels.
      
    //  result = PromptEventResult.RETURN;
     // return result;
      
      
      
      if ( component.equals("main.buen.testSelectionGroup") ){

         if ( data.getNumChildren() > 0 ){
            
            Activator.getLog().info(data.getChild(0).stringValue());
            
            if(data.getChild(0).stringValue().equals("red"))
            {

               bsel=1;
              
            }else if(data.getChild(0).stringValue().equals("orange")){
                
                bsel=2;
          
                
            }else if(data.getChild(0).stringValue().equals("yellow")){
                
                bsel=3;
          
            }
         }
         
      }
      
      if(component.equals("main.nav.next"))
      {

    	  
         result = PromptEventResult.RETURN;
         return result;
        // 
      }else if(component.equals("main.nav.back")){
    	  
    	  bsel=5;
          result = PromptEventResult.RETURN;
          return result;
    	  
      }else if(component.equals("main.nav.cancel")){
    	  
    	  bsel=6;
          result = PromptEventResult.CANCEL;
          return result;
      }
      //}else if(component.equals("main.nav.help")){
    	  
    	/*  bsel=4;
          result = PromptEventResult.RETURN;
          return result;*/
    	  
      
      
      
      
      return result;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.VlmlPrompt#init(com.lexmark.prtapp.prompt.VlmlPromptContext, com.lexmark.prtapp.profile.VlmlNavigator)
    */
   public void init(VlmlPromptContext promptContext, VlmlNavigator navigator)
   {
      // This is where initialization typically takes place.
      this.context = promptContext;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.VlmlPrompt#dismissed()
    */
   public void dismissed()
   {
      // Called when the prompt goes away.  This can be used for clean-up
      // (such as shutting down threads)
   }
   
   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.VlmlPrompt#validate()
    */
   public boolean validate() throws PromptException
   {
      // This gets called if the handleEvent method returns
      // PromptEventResult.VALIDATE.  We can then stop the prompt
      // from dismissing by returning false.
      return true;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getDismissButton()
    */
   public String getDismissButton()
   {
      // Typically this is a navigator button, but this prompt has
      // no navigator.  So we define our own dismiss buttons.
      // The profile code can call this to determine how the prompt
      // was exited.
      return dismissButton;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getDisplayType()
    */
   public DisplayType getDisplayType()
   {
      return DisplayType.VLML;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getId()
    */
   public String getId()
   {
      // This is a unique prompt ID, however it is really only useful if the prompt
      // can be created in a prompt factory.  This example prompt cannot, but we'll
      // give it a nice name anyway
      return "example.customvlmlprompt.medio";
   }
   
   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#setHelp(java.lang.String)
    */
   public void setHelp(String text)
   {
      // If we have a tips button, this can be used to get the help text.
   }
   public int bcualsel()
 {
	   return bsel;
 }
   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getHelp()
    */
   public String getHelp()
   {
      // This prompt does not use the tips (help) button, so we just return null.
      return null;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#setLabel(java.lang.String)
    */
   public void setLabel(String text)
   {
      // This corresponds to a label typically displayed at the top of the prompt.
   }
   
   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getLabel()
    */
   public String getLabel()
   {
      // We do not allow any labels to be changed, so this will always return null.
      return null;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#setName(java.lang.String)
    */
   public void setName(String name)
   {
      // This allows the top level VLML name to be changed.  This top level name is used
      // by testing automation software.
      this.vlmlName = name;
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getName()
    */
   public String getName()
   {
      return vlmlName;
   }
}

