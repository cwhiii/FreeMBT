import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBHandler
{
    Connection connection;
    Statement statement;
    String updateDBMegaString;
    String makeTableString;
    
DBHandler() throws SQLException{
    makeTableString = "create table units (" +
                "\"id\" TEXT,"  +
                "\"name\" TEXT,"  +
                "\"class\" TEXT, " +
                " \"tech_req\" TEXT,"  +
                "\"obsolete_by\" TEXT, " +
                " \"graphic\" TEXT,"  +
                "\"graphic_alt\" TEXT,"  +
                "\"sound_move\" TEXT,"  +
                " \"sound_move_alt\" TEXT,"  +
                "\"sound_fight\" TEXT, " +
                " \"sound_fight_alt \" TEXT,"  +
                "\"build_cost\" INTEGER,"  +
                "\"pop_cost\" INTEGER,"  +
                "\"attack\" INTEGER, " +
                "\"defense\" INTEGER,"  +
                "\"hitpoints\" INTEGER,"  +
                "\"firepower\" INTEGER,"  +
                "\"move_rate \" INTEGER,"  +
                "\"vision_radius_sq\" INTEGER,"  +
                "\"transport_cap\" INTEGER,"  +
                "\"fuel\" INTEGER,"  +
                "\"uk_happy\" INTEGER, " +
                "\"uk_shield\" INTEGER,"  +
                "\"uk_food\" INTEGER,"  +
                "\"uk_gold\" INTEGER,"  +
                "\"flags\" TEXT, " +
                "\"roles\" TEXT, " +
                "\"helptext\" TEXT" +
            ") ";
    
    updateDBMegaString = "";
    
    //Check if table exits:
    //SELECT name FROM sqlite_master WHERE type='table' AND name='table_name'
    
    openDB();
    
    // updateDB();
    }


void buildAUnit(Unit _unitPassedIn) throws SQLException{
    System.out.println("db.buildAUnit(): Values are: \n\t" + _unitPassedIn.getValuesAsCSV());
 
    statement.executeUpdate("INSERT INTO units VALUES(" + _unitPassedIn.getValuesAsCSV() +")");
    }


void openDB() throws SQLException{
    try {
        System.out.println("Attempting to access database...");
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);}

    connection = null;
    try{
        // create a database connection
        // TODO: Strip out the hard coded location. 
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\cwhiii\\Dropbox\\Projects\\Freeciv\\FreeMBT\\output\\freembt.sqlite");
        statement = connection.createStatement();
        statement.setQueryTimeout(3);  // set timeout to 30 sec.
        statement.executeUpdate(updateDBMegaString);
        //statement.executeUpdate("insert into person values(2, 'yui')");

        //statement.executeUpdate("drop table if exists units");
        // TODO: More this to it's own function:
        
        // YAHere
        //Check if table already exits, and if not, create it.
        /*
        Useless, mabye helpful bits.
        ResultSet result = statement.`
                .executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='table_name'");    
        System.out.println("LLOOK WHAR O FOUND: "  );
        System.out.println(result.getString("name"));
        System.out.println(result.toString()); 
        System.out.println("----------Post Chceck"  );
        */
        
        
        
        statement.executeUpdate(makeTableString);
        
        
      }
    // if the error message is "out of memory",  it probably means no database file is found
    catch(SQLException e){System.err.println(e.getMessage());}}

void updateDB() throws SQLException{
    statement.executeUpdate(updateDBMegaString);
    }

ResultSet runQuery(String _dbQuery) throws SQLException{
    //statement.executeUpdate(updateDBMegaString);
    String aLine = ""; 
    
    ResultSet result = statement.executeQuery(_dbQuery);    //"SELECT * FROM units"
    while(result.next()){
        System.out.println("name = " + result.getString("name"));
        }
    
    return result;
    }

Boolean unitExists(String _name){
        try {
            ResultSet result = statement.executeQuery("SELECT name FROM units WHERE name = '" + _name + "'");
            
            //If there's a unit with this same, pass that info back out.
            if (result.next()){
                return true;
                }
            else {
                return false;
                }
        } catch (SQLException ex) {Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);}
    // Fixme: Fallback should not exist. Adds redundancy, and defaults to no unit.
    return false;
    }

Unit fetchUnitFromDB(String _name){
    Unit thisOne = new Unit();
    try {
        ResultSet result = statement.executeQuery("SELECT * FROM units WHERE name = '" + _name + "'");    
        while(result.next()){
            thisOne.id = result.getString("id");
            thisOne.unitName = result.getString("name");
            thisOne.unitClass = result.getString("class");
            thisOne.tech_req = result.getString("tech_req");
            thisOne.obsolete_by = result.getString("obsolete_by");
            thisOne.graphic = result.getString("graphic");
            thisOne.graphic_alt = result.getString("graphic_alt");
            thisOne.sound_move = result.getString("sound_move");
            thisOne.sound_move_alt = result.getString("sound_move_alt");
            thisOne.sound_fight = result.getString("sound_fight");
            //FIXME: 
            //thisOne.sound_fight_alt = result.getString("sound_fight_alt"); 
            thisOne.build_cost = result.getInt("build_cost");
            thisOne.pop_cost = result.getInt("pop_cost");
            thisOne.attack = result.getInt("attack");
            thisOne.defence = result.getInt("defense");
            thisOne.hitpoints = result.getInt("hitpoints");
            thisOne.firepower = result.getInt("firepower");
            //FIXME: 
            //thisOne.move_rate = result.getInt("move_rate");
            thisOne.vision_radius_sq = result.getInt("vision_radius_sq");
            thisOne.transport_cap = result.getInt("transport_cap");
            thisOne.fuel = result.getInt("fuel");
            thisOne.uk_happy = result.getInt("uk_happy");
            thisOne.uk_shield = result.getInt("uk_shield");
            thisOne.uk_food = result.getInt("uk_food");
            thisOne.uk_gold = result.getInt("uk_gold");
            thisOne.flags = result.getString("flags");
            thisOne.roles = result.getString("roles");
            thisOne.helptext = result.getString("helptext");
            
            
            }        
        } catch (SQLException ex) {Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);}
    return thisOne;
    }

void  refreshUnitsDisplays(java.awt.Choice _ioChoice, java.awt.List _ioList) throws SQLException{
    ResultSet result = statement.executeQuery("SELECT * FROM units");    //"SELECT * FROM units"
    while(result.next()){
        _ioChoice.addItem(result.getString("name"));    //+"   -   "+result.getString("id"));
        _ioList.addItem(result.getString("name"));    //+"   -   "+result.getString("id"));
        }
    }


            
            



String returnEntry(String _dbQuery) throws SQLException{
    ResultSet result = statement.executeQuery(_dbQuery);    
    String out = ""; 
    while(result.next()){
        out += result.getString("id") + "\n";
        out += result.getString("name");
        }
    return out;
    }


int countUnits(String _dbQuery) throws SQLException{
    int count = 0;
    ResultSet result = statement.executeQuery(_dbQuery);    //"SELECT * FROM units"
    while(result.next()){
        System.out.println("Counted! name = " + result.getString("name"));
        count++;
        }
    
    return count;
    }



void closeDB(){
    try
    {
      if(connection != null)
        connection.close();
    }
    catch(SQLException e){
      // connection close failed.
      System.err.println(e);
          }
    }










  }
