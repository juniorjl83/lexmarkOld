
package co.com.Finamerica.Legalizacion.logic;

import java.io.InputStream;
import java.io.OutputStream;

import jcifs.smb.SmbFile;
import co.com.Finamerica.Legalizacion.Activator;
//New
import co.com.Finamerica.Legalizacion.FabricaCreditoProfile;

import com.lexmark.prtapp.scan.ScanConsumer;
import com.lexmark.prtapp.scan.ScanData;
import com.lexmark.prtapp.settings.SettingsAdmin;
//import com.lexmark.prtapp.smbclient.AuthOptions;
//import com.lexmark.prtapp.smbclient.SmbClient;
//import com.lexmark.prtapp.smbclient.SmbConfig.ConfigBuilder;
//import com.lexmark.prtapp.smbclient.SmbClientService;

import co.com.Finamerica.Legalizacion.service.AdminSettings;
import co.com.Finamerica.Legalizacion.service.PropertyReader;
import co.com.Finamerica.Legalizacion.service.SmbService;
import co.com.Finamerica.Legalizacion.service.SmbPathBuilder;



 
public class FabricaCreditoConsumer implements ScanConsumer {

    private static final int BUFFER_SIZE = 32767;
    
    int reales = 1;

    private String path;


    public FabricaCreditoConsumer() {
    }

    public FabricaCreditoConsumer(String path) {
        this.path = path;
    }


    /*
     * (non-Javadoc)
     * 
     * @see com.lexmark.prtapp.scan.ScanConsumer#consume(com.lexmark.prtapp.scan.ScanData)
     */
    public void consume(ScanData scanData) {

    	 int n = 1;
    	 int x = 0;
    	 
    	 
    	 
    	  InputStream scanImage = null;
    	//  Activator.getLog().info(path);      
    	  
    	 
        try {
            byte buffer[] = new byte[BUFFER_SIZE];
          
          String Path1=path; 

          
           
            while ((scanImage = scanData.nextImageFile()) != null) {
                   reales=reales+1;
            	 x=n-x;
            	 
            	if(n%2 == 0){            		
            	 path=path+"0"+x+"B.tif";
            	}else{
            		 path=path+"0"+x+"A.tif";
            	}
                SmbFile sbm = new SmbFile(path);
                OutputStream sbmOut = sbm.getOutputStream();

              n++;
                int readBytes = 0;
                  
                while ((readBytes = scanImage.read(buffer)) != -1) {
                    sbmOut.write(buffer, 0, readBytes);
                    path=Path1;
                        }

                sbmOut.close();
                scanImage.close();

            }
        //   
          //aqui pongo el archivo plano para el log
            String IP = ""; 	
           // Activator.getLog().info("0A:   :");
            
   		 String ruta=path;
   		 int tamano=ruta.length();
   		 int raya=ruta.indexOf("-");
   		 //oFICINA:
   		String antes=ruta.substring(raya+1, tamano-1);
   		int meslas=antes.indexOf("-");
   		 String ofis=antes.substring(meslas+1, antes.length());
   		int rayapiso=ruta.indexOf("_");
   		 String otro=ruta.substring(rayapiso, raya);
   		 int eslas=otro.indexOf("/");
   		 //CASO
   		 String caso=otro.substring(eslas+1, otro.length());
   		 if(caso.indexOf("/")!=-1){
   			 caso=caso.substring(caso.indexOf("/")+1,caso.length());
   			 
   		 }
  
   		 
   	// Log de tecnoimagenes

      //   byte informacion[] = new byte[300]; 
      
           String PathTecno=path+"LogTecnoimagenes.txt";
         //  Activator.getLog().info("2A:   :"+PathTecno);
            SmbFile sbmLogTecno = new SmbFile(PathTecno);
           
            OutputStream ipSbmoutTecno = sbmLogTecno.getOutputStream();
            ipSbmoutTecno.write(buffer, 0, 0 );

             ipSbmoutTecno.close(); 
             /////////////////termina log de tecnoimagenes
            
 	 
            /////////////
            String PathIp=path+ofis+"-"+caso+"-"+IP+"-"+reales+".logfin";
         //  Activator.getLog().info("log A: " + PathIp);
            SmbFile sbmip = new SmbFile(PathIp);
      //      Activator.getLog().info("log B: " + PathIp);
             OutputStream ipSbmout = sbmip.getOutputStream();
       //      Activator.getLog().info("log C: " + PathIp);
            ipSbmout.write(buffer, 0, 100);
            ipSbmout.close();
     //       Activator.getLog().info("log D: " + PathIp);
            ///
          
        } catch (Exception e) {
            Activator.getLog().info("Error en el proceso de escaneo: " + e.getMessage());
            return;
        }
 
        
    }

}
