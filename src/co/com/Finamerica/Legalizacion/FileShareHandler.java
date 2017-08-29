package co.com.Finamerica.Legalizacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.lexmark.prtapp.scan.ScanCancelledException;
import com.lexmark.prtapp.scan.ScanConsumer;
import com.lexmark.prtapp.scan.ScanData;
//import com.lexmark.prtapp.smbclient.SmbClient;
import com.lexmark.ui.Constants;

/**
 * This class does the file share operations. It acts as a Scan Consumer to write
 * the scan data to the file share, but it also has other methods to aid in broswing.
 */
public class FileShareHandler implements ScanConsumer
{
   //private SmbClient smbClient;
   private int fileFormat;
   
   /**
    * The constructor requires an SmbClient instance to do its dirty work.
    */
/*   public FileShareHandler(SmbClient client, int fileFormat)
   {
      this.smbClient = client;
      this.fileFormat = fileFormat;
   }*/

   /* (non-Javadoc)
    * @see com.lexmark.prtapp.scan.ScanConsumer#consume(com.lexmark.prtapp.scan.ScanData)
    */
   public void consume(ScanData data)
   {
      byte buffer[] = new byte[65536];
      int bytesRead = 0;

      InputStream s = null;
      OutputStream os = null;
      
      try
      {
         while((s = data.nextImageFile()) != null)
         {
            String outPath = getScanFileName();

        //    os = smbClient.getOutputStream("",  outPath);
            
            // Copy the scan data to the network file.
            while((bytesRead = s.read(buffer)) != -1)
            {
               os.write(buffer, 0, bytesRead);
            }
            // Close our streams. Set the output stream to null
            // so we know it's closed - the finally block will also
            // try to close it
            os.close();
            os = null;
            s.close();
         }
      }
      catch(ScanCancelledException e)
      {
         Activator.getLog().debug("The scan has been CANCELLED!!");
      }
      catch(Exception e)
      {
         Activator.getLog().debug("Exception thrown while scanning", e);
      }
      finally
      {
         try
         {
            if(os != null) os.close();
         }
         catch(IOException ignore)
         {
            Activator.getLog().debug("Problem closing SMB output stream", ignore);
         }
         try
         {
            if(s != null) s.close();
         }
         catch(IOException ignore)
         {
            Activator.getLog().debug("Problem closing scan data stream", ignore);
         }
      }
   }
   
   /**
    * Helper to generate a file name based on the file type. Adds a time stamp to
    * have a greater probability that the file name is unique
    */
   private String getScanFileName()
   {
      String ext = null;
      switch(fileFormat)
      {
      case Constants.e_TIFF:
         ext = ".tif";
         break;
      case Constants.e_JPEG:
         ext = ".jpg";
         break;
      case Constants.e_PDF:
      case Constants.e_SECURE_PDF:
         ext = ".pdf";
         break;
      case Constants.e_XPS:
         ext = ".xps";
         break;
      default:
         ext = ".unknown";
      }

      return "ScanToSmbShareExample-" + (new Date()).getTime() + ext;
   }
}
