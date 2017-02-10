/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver;

/**
 *
 * @author mcgol_000
 */
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.*;
    
public class RequestProcessor implements Runnable {
  
  private final static Logger logger = Logger.getLogger(
      RequestProcessor.class.getCanonicalName());

  private File rootDirectory = new File("../Web_Servers");
  private String indexFileName = "main_login.php";
  private Socket connection;
  
  public RequestProcessor(File rootDirectory, 
      String indexFileName, Socket connection) {
        
    if (rootDirectory.isFile()) {
      throw new IllegalArgumentException(
          "rootDirectory must be a directory, not a file");   
    }
    try {
      rootDirectory = rootDirectory.getCanonicalFile();
    } catch (IOException ex) {
    }
    this.rootDirectory = rootDirectory;

    if (indexFileName != null) this.indexFileName = indexFileName;
    this.connection = connection;
  }
  
  @Override
  public void run() {
    // for security checks
    String root = rootDirectory.getPath();
    try {              
      OutputStream raw = new BufferedOutputStream(
                          connection.getOutputStream()
                         );         
      Writer out = new OutputStreamWriter(raw);
      Reader in = new InputStreamReader(
                   new BufferedInputStream(
                    connection.getInputStream()
                   ),"US-ASCII"
                  );
      StringBuilder requestLine = new StringBuilder();
      while (true) {
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        requestLine.append((char) c);
      }
      
      StringBuilder secondline = new StringBuilder();
      while (true) {
       // logger.info("Hello from outside of post");
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        secondline.append((char) c);
      }
      
      
      String get = requestLine.toString();
      
      logger.info(connection.getRemoteSocketAddress() + " " + get);
      logger.info(secondline.toString());
      
      String[] tokens = get.split("\\s+");
      String method = tokens[0];
      String version = "";
      if (method.equals("GET")) {
        String fileName = tokens[1];
        if (fileName.endsWith("/")) fileName += indexFileName;
        String contentType = 
            URLConnection.getFileNameMap().getContentTypeFor(fileName);
        if (tokens.length > 2) {
          version = tokens[2];
        }

        File theFile = new File(rootDirectory, 
            fileName.substring(1, fileName.length()));
        
        if (theFile.canRead() 
            // Don't let clients outside the document root
            && theFile.getCanonicalPath().startsWith(root)) {
          byte[] theData = Files.readAllBytes(theFile.toPath());
          if (version.startsWith("HTTP/")) { // send a MIME header
            sendHeader(out, "HTTP/1.0 200 OK", contentType, theData.length);
          } 
      
          // send the file; it may be an image or other binary data 
          // so use the underlying output stream 
          // instead of the writer
          raw.write(theData);
          raw.flush();
        }
        
        else { // can't find the file
          String body = new StringBuilder("<HTML>\r\n")
              .append("<HEAD><TITLE>File Not Found</TITLE>\r\n")
              .append("</HEAD>\r\n")
              .append("<BODY>")
              .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
              .append("</BODY></HTML>\r\n").toString();
          if (version.startsWith("HTTP/")) { // send a MIME header
            sendHeader(out, "HTTP/1.0 404 File Not Found", 
                "text/html; charset=utf-8", body.length());
          } 
          out.write(body);
          out.flush();
        }
      }
      else if(method.equals("HEAD")) {
          String body = new StringBuilder("<HTML>\r\n")
              .append("<HEAD><TITLE>Title</TITLE>\r\n")
              .append("</HEAD>\r\n")
              .append("<BODY>")
              .append("<H1>Header</H1>\r\n")
              .append("")
              .append("</BODY></HTML>\r\n").toString();
          
          if (version.startsWith("HTTP/")) { // send a MIME header
            sendHeader(out, "HTTP/1.0 404 File Not Found", 
                "text/html; charset=utf-8", body.length());
          } 
          out.write(body);
          out.flush();
                
        }
      else if(method.equals("POST")){
          StringBuilder thirdline = new StringBuilder();
          while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        thirdline.append((char) c);
      }
          logger.info(thirdline.toString());
          
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
       
      }
      
      StringBuilder fourthline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        fourthline.append((char) c);
      }
      logger.info(fourthline.toString());
      
      
      StringBuilder fivethline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        fivethline.append((char) c);
      }
      logger.info(fivethline.toString());
      
      
      StringBuilder sixthline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        sixthline.append((char) c);
      }
      logger.info(sixthline.toString());
      
      
      StringBuilder seventhline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        seventhline.append((char) c);
      }
      logger.info(seventhline.toString());
      
      StringBuilder eighthline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        eighthline.append((char) c);
      }
      logger.info(eighthline.toString());
      
      StringBuilder nineline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        nineline.append((char) c);
      }
      logger.info(nineline.toString());
      
      StringBuilder tenline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        tenline.append((char) c);
      }
      logger.info(tenline.toString());
      
      StringBuilder moreline = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        moreline.append((char) c);
      }
      logger.info(moreline.toString());
      
      
      StringBuilder more1line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more1line.append((char) c);
      }
      logger.info(more1line.toString());
      
      
      StringBuilder more2line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more2line.append((char) c);
      }
      logger.info(more2line.toString());
      
      
      StringBuilder more3line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more3line.append((char) c);
      }
      logger.info(more3line.toString());
      
      
      StringBuilder more4line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more4line.append((char) c);
      }
      logger.info(more4line.toString());
      

      StringBuilder more5line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more5line.append((char) c);
      }
      logger.info(more5line.toString());
      
      
      StringBuilder more6line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more6line.append((char) c);
      }
      logger.info(more6line.toString());
      
      StringBuilder more7line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more7line.append((char) c);
      }
      logger.info(more7line.toString());
      
      StringBuilder more8line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more8line.append((char) c);
      }
      logger.info(more8line.toString());
      
      StringBuilder more9line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more9line.append((char) c);
      }
      logger.info(more9line.toString());
      
      StringBuilder more10line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more10line.append((char) c);
      }
      logger.info(more10line.toString());
      
      StringBuilder more11line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more11line.append((char) c);
      }
      logger.info(more11line.toString());
      
      StringBuilder more13line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more13line.append((char) c);
      }
      logger.info(more13line.toString());
      
      StringBuilder more12line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more12line.append((char) c);
      }
      logger.info(more12line.toString());
      
      int a = in.read();
      if (a=='\n')
          System.out.println("Got Somehting");
     
      
      StringBuilder more14line = new StringBuilder();
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more14line.append((char) c);
      }
      logger.info(more14line.toString());
      
      StringBuilder more15line = new StringBuilder();
      
      while (true) {
        
        int c = in.read();
        if (c == '\r' || c == '\n') break;
        more15line.append((char) c);
      }
      logger.info(more15line.toString());
      
      }
      else { // method does not equal "GET"
        String body = new StringBuilder("<HTML>\r\n")
            .append("<HEAD><TITLE>Not Implemented</TITLE>\r\n")
            .append("</HEAD>\r\n")
            .append("<BODY>")
            .append("<H1>HTTP Error 501: Not Implemented</H1>\r\n")
            .append("</BODY></HTML>\r\n").toString();
        if (version.startsWith("HTTP/")) { // send a MIME header
          sendHeader(out, "HTTP/1.0 501 Not Implemented", 
                    "text/html; charset=utf-8", body.length());
        }
        out.write(body);
        out.flush();
      }
    } catch (IOException ex) {
      logger.log(Level.WARNING, 
          "Error talking to " + connection.getRemoteSocketAddress(), ex);
    } finally {
      try {
        connection.close();        
      }
      catch (IOException ex) {} 
    }
  }

  private void sendHeader(Writer out, String responseCode,
      String contentType, int length)
      throws IOException {
    out.write(responseCode + "\r\n");
    Date now = new Date();
    out.write("Date: " + now + "\r\n");
    out.write("Server: JHTTP 2.0\r\n");
    out.write("Content-length: " + length + "\r\n");
    out.write("Content-type: " + contentType + "\r\n\r\n");
    out.flush();
  }
}