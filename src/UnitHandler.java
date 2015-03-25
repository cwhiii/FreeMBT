import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class UnitHandler 
{
    
String unit_ID;
String name;
String unitClass;
String tech_req;      
String obsolete_by;   
String graphic;      
String graphic_alt;   
String sound_move;    
String sound_move_alt; 
String sound_fight;   
String sound_fight_alt; 
int build_cost;    
int  pop_cost;      
int  attack;       
int  defense;       
int  hitpoints;     
int  firepower;     
int   move_rate;     
int   vision_radius_sq; 
int   transport_cap; 
int  fuel;          
int  uk_happy;      
int  uk_shield;     
int  uk_food;     
int  uk_gold;       
String flags;   
String veteran_raise_chance;
String veteran_work_raise_chance;
String veteran_power_fact;
String veteran_move_bonus;
String roles;
String helptext;




String unitText;
String allString;
String myFile = "C:\\Users\\cwhiii\\Dropbox\\Projects\\Freeciv\\FreeMBT\\output\\units.ruleset";
FileWriter writer;



// Later on I need to test to ensure good data in each field. But for now...
void compileUnit(
        String _id, 
        String _name, 
        String _class, 
        String _techReq, 
        String _obsolete,  
        String _graphic, 
        String _graphicAlt, 
        String _soundMove, 
        String _soundMoveAlt, 
        String _fight, 
        String _fightAlt, 
        int _buildCost, 
        int _popCost, 
        int _atk, 
        int _def, 
        int _hp, 
        int _fp, 
        int _move, 
        int _vision, 
        int _transport, 
        int _fuel, 
        int _ukHappy, 
        int _ukShield, 
        int _ukfood, 
        int _ukGold, 
        String _flags, 
        String _roles, 
        String _help){
    unit_ID =           _id; 
    name = 		_name; 
    unitClass =  	_class; 
    tech_req =       	_techReq; 
    obsolete_by =    	_obsolete; 
     graphic =       	_graphic; 
    graphic_alt =    	_graphicAlt; 
     sound_move =     	_soundMove; 
    sound_move_alt =  	_soundMoveAlt; 
    sound_fight =    	_fight; 
    sound_fight_alt =  	_fightAlt; 
    build_cost =     	_buildCost; 
    pop_cost =       	_popCost; 
    attack =        	_atk; 
    defense =       	_def; 
    hitpoints = 	_hp; 
    firepower =      	_fp; 
    move_rate =      	_move; 
    vision_radius_sq =  _vision; 
    transport_cap =  	_transport; 
    fuel =           	_fuel; 
    uk_happy =       	_ukHappy; 
    uk_shield =    	_ukShield; 
    uk_food =      	_ukfood; 
    uk_gold =        	_ukGold; 
    flags =    		_flags; 
    roles = 		_roles; 
    helptext =          _help;

    
    
    
    
    unitText = "";
        /*
        unitText += "[unit_"+ unit_ID +"]\n";
        unitText +=  "name\t\t\t=_(\""+ _name +"\")\n";
        unitText +=  "class\t\t\t=\""+ _class +"\"\n"; 
        unitText +=  "tech_req\t\t=\""+ _techReq +"\"\n";  
        unitText +=  "obsolete_by\t=\""+ _obsolete +"\"\n";   
        unitText +=  "graphic_alt\t=\""+ _graphic +"\"\n"; 
        unitText +=  "graphic_alt\t=\""+ _graphicAlt +"\"\n"; 
        unitText +=  "sound_move\t\t=\""+ _soundMove +"\"\n"; 
        unitText +=  "sound_move_alt\t=\""+ _soundMoveAlt +"\"\n"; 
        unitText +=  "sound_fight\t=\""+ _fight +"\"\n"; 
        unitText +=  "sound_fight_alt\t=\""+ _fightAlt +"\"\n"; 
        unitText +=  "build_cost\t\t="+ _buildCost +"\n"; 
        unitText +=  "pop_cost\t\t="+ _popCost +"\n"; 
        unitText +=  "attack\t\t="+ _atk +"\n"; 
        unitText +=  "defense\t\t="+ _def +"\n"; 
        unitText +=  "hitpoints\t\t="+ _hp +"\n"; 
        unitText +=  "firepower\t\t="+ _fp +"\n"; 
        unitText +=  "move_rate\t\t="+ _move +"\n"; 
        unitText +=  "vision_radius_sq\t="+ _vision +"\n"; 
        unitText +=  "transport_cap\t="+ _transport +"\n"; 
        unitText +=  "fuel\t\t\t="+ _fuel +"\n"; 
        unitText +=  "uk_happy\t\t="+ _ukHappy +"\n"; 
        unitText +=  "uk_shield\t\t="+ _ukShield +"\n"; 
        unitText +=  "uk_food\t\t="+ _ukfood +"\n"; 
        unitText +=  "uk_gold\t\t="+ _ukGold +"\n"; 
        unitText +=  "flags\t\t\t="+ _flags +"\n"; 
        unitText +=  "roles\t\t\t="+ _roles +"\n"; 
        unitText +=  "helptext\t\t="+ _help +"\n";  
        */
    System.out.println( "What you have so far: FOR WRTING TO FILE AT THE END OF TIME." + unitText);
    
            
            
            
            
            
    }

// Combines each piece of data to form a long string with a single unit in a 
// block of text. Then spit it out to  a file.
void buildUnit() throws IOException{
    System.out.println( "About to try ");
    
    //Tries to open file to write to it.
    try {
         writer = new FileWriter(new File(myFile), false);
        System.out.println("File found! Ready to edit.");
        } catch (NumberFormatException e) {
            //If it can't find the file, make a new one.
            try {
            File file = new File(myFile);
              if (file.createNewFile()){
                System.out.println("File is created! Ready to edit.");
              }
            }  catch (IOException e2) {}
        }
        
    System.out.println( "File ready.");
    writer.write(unitText);  
    writer.flush();
    writer.close();
    }




String getValues(){
    allString =   "'" + unit_ID +  "', ";   
    allString +=  "'" + name +  "', ";   
    allString +=  "'" + unitClass +  "', ";   
    allString +=  "'" + tech_req +  "', ";   
    allString +=  "'" + obsolete_by +  "', ";   
    allString +=  "'" + graphic +  "', ";      
    allString +=  "'" + graphic_alt +  "', ";   
    allString +=  "'" + sound_move +  "', ";    
    allString +=  "'" + sound_move_alt +  "', "; 
    allString +=  "'" + sound_fight +  "', ";   
    allString +=  "'" + sound_fight_alt +  "', "; 
    allString +=  "'" + Integer.toString(build_cost) +  "', ";    
    allString +=  "'" + Integer.toString(pop_cost) +  "', ";      
    allString +=  "'" + Integer.toString(attack) +  "', ";       
    allString +=  "'" + Integer.toString(defense) +  "', ";       
    allString +=  "'" + Integer.toString(hitpoints) +  "', ";     
    allString +=  "'" + Integer.toString(firepower) +  "', ";     
    allString +=  "'" + Integer.toString(move_rate) +  "', ";     
    allString +=  "'" + Integer.toString(vision_radius_sq) +  "', "; 
    allString +=  "'" + Integer.toString(transport_cap) +  "', "; 
    allString +=  "'" + Integer.toString(fuel) +  "', ";          
    allString +=  "'" + Integer.toString(uk_happy) +  "', ";      
    allString +=  "'" + Integer.toString(uk_shield) +  "', ";     
    allString +=  "'" + Integer.toString(uk_food) +  "', ";     
    allString +=  "'" + Integer.toString(uk_gold) +  "', ";       
    allString +=  "'" + flags +  "', ";   
    allString +=  "'" + roles + "',";
    allString +=  "'" + helptext + "'";

 
    
    return allString;
    }









}