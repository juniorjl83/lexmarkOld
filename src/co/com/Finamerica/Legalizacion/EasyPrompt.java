//*************************** Lexmark Confidential ****************************
// $URL$
// $Id$
//
// Copyright (c) 2010 Lexmark International, Inc.
// All Rights Reserved.
//*****************************************************************************

package co.com.Finamerica.Legalizacion;

import java.util.Random;

import com.lexmark.core.Element;
import com.lexmark.prtapp.prompt.BaseVlmlPrompt;
import com.lexmark.prtapp.prompt.Prompt;
import com.lexmark.prtapp.prompt.PromptEventResult;
import com.lexmark.prtapp.prompt.PromptException;





import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import com.lexmark.core.Element;
import com.lexmark.prtapp.image.Image;
import com.lexmark.prtapp.image.ImageException;
import com.lexmark.prtapp.image.ImageWriter;
import com.lexmark.prtapp.image.PngImageWriter;
import com.lexmark.prtapp.imageserver.ImageServer;
import com.lexmark.prtapp.profile.VlmlNavigator;
import com.lexmark.prtapp.prompt.DisplayType;
import com.lexmark.prtapp.prompt.PromptEventResult;
import com.lexmark.prtapp.prompt.PromptException;
import com.lexmark.prtapp.prompt.VlmlPrompt;
import com.lexmark.prtapp.prompt.VlmlPromptContext;

public class EasyPrompt extends BaseVlmlPrompt implements Prompt

{

   int sel=0;
   

   public EasyPrompt()
   {

   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.BaseVlmlPrompt#doGetVlml()
    */
   protected String doGetVlml()
      {
	   String bb="caracteriza nuestro servicio de impresión";
	   StringBuffer screen = new StringBuffer();
      
	      screen.append("<BoxLayout name=\"Main\" orientation=\"vertical\" distribution=\"homogeneous\" verticalScroll=\"never\" horizontalScroll=\"never\" >\n");
	        
	     /* ñ Ã±
	      á Ã¡
	      é Ã©
	      í Ã*
	      ó Ã³
	      ú Ãº*/
	      //Agrega texto

	     // screen.append("  <GridLayout name=\"main1\" columns=\"1\" rows=\"5\" distribution=\"homogeneous\" spacing=\"0\" Color=\"FF0000\">\n");
	      screen.append("  <GridLayout name=\"main1\" columns=\"5\" rows=\"10\" spacing=\"0\" horizontalScroll=\"never\" verticalScroll=\"automatic\" verticalIncrement=\"10\">\n");
	      screen.append("  <AttachChild left=\"0\" right=\"10\" top=\"0\" bottom=\"1\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label\" pointSize=\"22\" lineWrap=\"false\" justification=\"center\" text=\"Selecciona la opción que consideras \" shrinkToFit=\"false\" style=\"normal\" color=\"0000BB\"/>\n");
	      screen.append("  </AttachChild>\n");
	      screen.append("  <AttachChild left=\"0\" right=\"10\" top=\"1\" bottom=\"2\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label1\" pointSize=\"22\" justification=\"center\" text=\"" + bb + "\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000BB\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      
	     
	      screen.append("  <AttachChild left=\"0\" right=\"10\" top=\"2\" bottom=\"3\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label2\" pointSize=\"10\" justification=\"center\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      
	     
	      screen.append("  <AttachChild left=\"0\" right=\"10\" top=\"3\" bottom=\"4\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label3\" pointSize=\"10\" justification=\"center\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      
	     
	      screen.append("  <AttachChild left=\"6\" right=\"7\" top=\"4\" bottom=\"5\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label4\" pointSize=\"10\" justification=\"left\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      screen.append("  <AttachChild left=\"8\" right=\"9\" top=\"5\" bottom=\"6\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label5\" pointSize=\"10\" justification=\"right\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      screen.append("  <AttachChild left=\"9\" right=\"10\" top=\"6\" bottom=\"7\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label6\" pointSize=\"10\" justification=\"left\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      
	      
	       // boton muy satisfecho
	      screen.append("         <AttachChild left=\"4\" right=\"5\" top=\"7\" bottom=\"8\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("            <LabeledImageButton name=\"randomNumberButton\" overlayColor=\"11ff11\" overlayPointSize=\"26\" overlayStyle=\"bold\" state=\"NORMAL\">\n");
	      screen.append("               <Normal imageName=\"ActionUp\" text=\"Muy Satisfecho\"/>\n");
	      screen.append("               <Selected imageName=\"ActionDown\" text=\"Muy Satisfecho!\"/>\n");
	      screen.append("            </LabeledImageButton>\n");
	      screen.append("         </AttachChild>\n");

	     
	      
	      // boton satisfecho
	      screen.append("         <AttachChild left=\"5\" right=\"6\" top=\"7\" bottom=\"8\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("            <LabeledImageButton name=\"changeColorButton\" overlayColor=\"FF7F00\" overlayPointSize=\"26\" overlayStyle=\"bold\" state=\"NORMAL\">\n");
	      screen.append("               <Normal imageName=\"ActionUp\" text=\"Satisfecho\"/>\n");
	      screen.append("               <Selected imageName=\"ActionDown\" text=\"Satisfecho\"/>\n");
	      screen.append("            </LabeledImageButton>\n");
	      screen.append("         </AttachChild>\n");
	      
	      
	      // boton muy insatisfecho
	      screen.append("         <AttachChild left=\"6\" right=\"7\" top=\"7\" bottom=\"8\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("            <LabeledImageButton name=\"changeColorButton1\" overlayColor=\"FF0000\" overlayPointSize=\"26\" overlayStyle=\"bold\" state=\"NORMAL\">\n");
	      screen.append("               <Normal imageName=\"ActionUp\" text=\"Muy Insatisfecho\"/>\n");
	      screen.append("               <Selected imageName=\"ActionDown\" text=\"Muy Insatisfecho!\"/>\n");
	      screen.append("            </LabeledImageButton>\n");
	      screen.append("         </AttachChild>\n"); 
	      
	      
	      screen.append("  <AttachChild left=\"6\" right=\"7\" top=\"8\" bottom=\"9\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label7\" pointSize=\"10\" justification=\"left\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      screen.append("  <AttachChild left=\"8\" right=\"9\" top=\"9\" bottom=\"10\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label8\" pointSize=\"10\" justification=\"right\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      screen.append("  <AttachChild left=\"6\" right=\"7\" top=\"10\" bottom=\"11\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label71\" pointSize=\"10\" justification=\"left\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	      
	      screen.append("  <AttachChild left=\"8\" right=\"9\" top=\"11\" bottom=\"12\" xFill=\"shrink\" yFill=\"shrink\">\n");
	      screen.append("  <Label name=\"Label81\" pointSize=\"10\" justification=\"right\" text=\".\" shrinkToFit=\"true\" lineWrap=\"false\" style=\"normal\" color=\"0000ff\"/>\n");
	      screen.append("  </AttachChild>\n");
	         

	      screen.append("  </GridLayout>\n");
	     
	    
	     screen.append("      </BoxLayout>\n");
	   

	   
	  
      return screen.toString();
   }

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.BaseVlmlPrompt#doHandleEvent(java.lang.String, java.lang.String, com.lexmark.core.Element)
    */
   protected PromptEventResult doHandleEvent(String component, String event,
		   
         Element data) throws PromptException
   {
      /**
       * Any non-navigator bar event that an eSF prompt can catch will come through
       * this method.  The component will match the name of the button or other item
       * specified in VLML.  The event and data will be specific to the component.
       * The VLML guide in the Reference section of the SDK documents all of the
       * possible events.
       */
      PromptEventResult result = null;      // NULL means we didn't handle the event

      Activator.getLog().info("caiiiiii:   ");
     

      if(component.equals("Basic.Main.main1.randomNumberButton"))
      {
    	  Activator.getLog().info("caiuuu:   ");
    	  
         // This one does not require a refresh
         sel=1;
         result = PromptEventResult.RETURN;
         return result;
        // 
      }

      else if(component.equals("Basic.Main.main1.changeColorButton"))
      {
         // This one shows how to make changes by refreshing the VLML
        // newTextColor();
        // result = PromptEventResult.REDRAW;
    	  sel=2;
         result = PromptEventResult.RETURN;
         return result;
      }
      else if(component.equals("Basic.Main.main1.changeColorButton1"))
      {
         // This one shows how to make changes by refreshing the VLML
      //   newTextColor();
    	  sel=3;
         result = PromptEventResult.RETURN;
         return result;
      }
      
      return result;
      //Activator.getLog().info("cajjjj:   ");
   }

   /**
    * Helper to generate a random number, and then change the label text to show it.
    */
     private int newRandomNumber() throws PromptException
   {
 
    	 int eleccion=10;
    	 return eleccion;
    	 
   } 
 /*  private void newRandomNumber() throws PromptException
   {
      Random r = new Random();
      randomNumber = Integer.toString(r.nextInt(100));
      
     getContext().setText("Basic.Main.randomNumberLabel", randomNumber);
   } */  
   
   /**
    * Helper to change the text color.
    */
/*   private void newTextColor()
   {
      Random r = new Random();
      int red = r.nextInt(256);
      int blue = r.nextInt(256);
      int green = r.nextInt(256);

      textColor = toColorHexString(red) + toColorHexString(green) + toColorHexString(blue);
   }*/
   
   /**
    * Helper to create a two-digit hex string; used for getting 
    * a random color.
    */
   private String toColorHexString(int i)
   {
      String hex = Integer.toHexString(i);
      if(i < 0x10) hex = "0" + hex;
      
      return hex;
   }
   
   
   //obtener valor sel
   public int cualsel()
   {
	   return sel;
   }
   
   
   /* (non-Javadoc)
    * @see com.lexmark.prtapp.prompt.Prompt#getId()
    */
   public String getId()
   {
      // This is a unique prompt ID, however it is really only useful if the prompt
      // can be created in a prompt factory.  This example prompt cannot, but we'll
      // give it a nice name anyway
      return "example.customvlmlprompt.EasyPrompt";
   }

}
