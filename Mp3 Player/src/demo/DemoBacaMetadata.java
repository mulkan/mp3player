package demo;


import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.image.JpegParser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//https://stackoverflow.com/questions/5759331/finding-duration-of-an-mp3-file-in-java
//https://www.delftstack.com/howto/java/java-play-mp3/
/**
 *
 * @author User
 */
public class DemoBacaMetadata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //new MP3Player(new File("")).play();
        DemoBacaMetadata.demo();
        
    }
    public static void demo(){
        String fileLocation = "D:/y2mate.com - Zinidin Zidan Ft Tri Suaka Buih Jadi Permadani Full Album Terbaru 2021.mp3";

        try {
            InputStream input = new FileInputStream(new File(fileLocation));
            ContentHandler handler =  (ContentHandler) new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            //parser = new PDFParser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input,  handler, metadata, parseCtx);
            input.close();

            // List all metadata
            String[] metadataNames = metadata.names();

            for(String name : metadataNames){
                System.out.println(name + ": " + metadata.get(name));
            }
            System.out.println(metadata.get("xmpDM:duration"));
            //int durasi = Double.valueOf()metadata.get("xmpDM:duration");

            // Retrieve the necessary info from metadata
            // Names - title, xmpDM:artist etc. - mentioned below may differ based
//            System.out.println("----------------------------------------------");
//            System.out.println("Title: " + metadata.get("title"));
//            System.out.println("Artists: " + metadata.get("xmpDM:artist"));
//            System.out.println("Composer : "+metadata.get("xmpDM:composer"));
//            System.out.println("Genre : "+metadata.get("xmpDM:genre"));
//            System.out.println("Album : "+metadata.get("xmpDM:album"));

        } catch (FileNotFoundException e) {
        } catch (IOException | SAXException | TikaException e) {
            System.out.println(e.toString());
        }
    }
    
    public void demo2() throws InterruptedException{
        MP3Player player = new MP3Player();
        player.addToPlayList(new File("D:/y2mate.com - Wings Sejati 1990 YouTube.mp3"));
        player.setRepeat(true);
        player.setShuffle(true);
        player.play();
        while(!player.isStopped()){
            Thread.sleep(5000);
        }
    }
    
        
    
}
