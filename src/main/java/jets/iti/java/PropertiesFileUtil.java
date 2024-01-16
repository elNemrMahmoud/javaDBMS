package jets.iti.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.util.Properties;


class PropertiesFileUtil {

    public static void WritePropertiesFile(){

        Properties prop = new Properties();
        OutputStream output = null;

        try{
            output = new FileOutputStream("C:/Users/dark1/Desktop/JavaCore/Projects/JDBC/Day3/src/main/resources/db.properties");

            prop.setProperty("ORACLE_DB_URL","jdbc:oracle:thin:@tcp://localhost:1521/XE");
            prop.setProperty("ORACLE_DB_USERNAME","HR");
            prop.setProperty("ORACLE_DB_PASSWORD","1234");

            prop.store(output,null);
        }
        catch(IOException io){
            io.printStackTrace();
        }
        finally{
            if(output!=null){
                try{
                    output.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static Properties getPropertiesFromFile(){

        Properties props = new Properties();
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("C:/Users/dark1/Desktop/JavaCore/Projects/JDBC/Day3/src/main/resources/db.properties");
            props.load(fis);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        // Close file input stream in finally clause
        finally
        {
            try{
                fis.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return props;
        

        
    }
}
