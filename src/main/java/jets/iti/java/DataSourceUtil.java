package jets.iti.java;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

class DataSourceUtil{


    public static OracleDataSource getOracleDataSource(){

            Properties prop = PropertiesFileUtil.getPropertiesFromFile();
            
            OracleDataSource oracleDS = null;
            try{
            oracleDS = new OracleDataSource();
            oracleDS.setURL(prop.getProperty("ORACLE_DB_URL"));
            oracleDS.setUser(prop.getProperty("ORACLE_DB_USERNAME"));
            oracleDS.setPassword(prop.getProperty("ORACLE_DB_PASSWORD"));
            }catch(SQLException e){
                e.printStackTrace();
            }
            return oracleDS;
        

    }
}