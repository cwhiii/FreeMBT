/**
 *
 * @author cwhiii
 */
public class Unit {
    // Freeciv fields:
    public String id;
    public String unitName;
    public String unitClass;
    public String tech_req;      
    public String obsolete_by;   
    public String graphic;      
    public String graphic_alt;   
    public String sound_move;    
    public String sound_move_alt; 
    public String sound_fight;   
    public String sound_fight_alt; 
    public int build_cost;    
    public int  pop_cost;      
    public int  attack;       
    public int  defence;       
    public int  hitpoints;     
    public int  firepower;     
    public int  move_rate;     
    public int  vision_radius_sq; 
    public int  transport_cap; 
    public int  fuel;          
    public int  uk_happy;      
    public int  uk_shield;     
    public int  uk_food;     
    public int  uk_gold;       
    public String flags;   
    public String roles;
    public String helptext;
    
    
    public String veteran_raise_chance;
    public String veteran_work_raise_chance;
    public String veteran_power_fact;
    public String veteran_move_bonus;
    // General
    public String fullString;
    public String allFieldsAsCSV;
    
    
    Unit(){}
    Unit(
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
        id =                _id; 
        unitName =              _name; 
        unitClass =         _class; 
        tech_req =          _techReq; 
        obsolete_by =       _obsolete; 
        graphic =           _graphic; 
        graphic_alt =       _graphicAlt; 
        sound_move =        _soundMove; 
        sound_move_alt =    _soundMoveAlt; 
        sound_fight =       _fight; 
        sound_fight_alt =   _fightAlt; 
        build_cost =        _buildCost; 
        pop_cost =          _popCost; 
        attack =            _atk; 
        defence =           _def; 
        hitpoints =         _hp; 
        firepower =         _fp; 
        move_rate =         _move; 
        vision_radius_sq =  _vision; 
        transport_cap =     _transport; 
        fuel =              _fuel; 
        uk_happy =          _ukHappy; 
        uk_shield =         _ukShield; 
        uk_food =           _ukfood; 
        uk_gold =           _ukGold; 
        flags =             _flags; 
        roles =             _roles; 
        helptext =          _help;
        
        buildFullString();
    }
    
String buildFullString(){
    fullString = "";
    fullString +=  id;
    fullString +=  unitName;
    fullString +=  unitClass;
    fullString +=  tech_req;      
    fullString +=  obsolete_by;   
    fullString +=  graphic;      
    fullString +=  graphic_alt;   
    fullString +=  sound_move;    
    fullString +=  sound_move_alt; 
    fullString +=  sound_fight;   
    fullString +=  sound_fight_alt; 
    fullString +=  build_cost;    
    fullString +=  pop_cost;      
    fullString +=  attack;       
    fullString +=  defence;       
    fullString +=  hitpoints;     
    fullString +=  firepower;     
    fullString +=  move_rate;     
    fullString +=  vision_radius_sq; 
    fullString +=  transport_cap; 
    fullString +=  fuel;          
    fullString +=  uk_happy;      
    fullString +=  uk_shield;     
    fullString +=  uk_food;     
    fullString +=  uk_gold;       
    fullString +=  flags;   
    fullString +=  roles;
    fullString +=  helptext;
    
    return fullString;
    } 




String getValuesAsCSV(){
    allFieldsAsCSV =   "'" + id +  "', ";   
    allFieldsAsCSV +=  "'" + unitName +  "', ";   
    allFieldsAsCSV +=  "'" + unitClass +  "', ";   
    allFieldsAsCSV +=  "'" + tech_req +  "', ";   
    allFieldsAsCSV +=  "'" + obsolete_by +  "', ";   
    allFieldsAsCSV +=  "'" + graphic +  "', ";      
    allFieldsAsCSV +=  "'" + graphic_alt +  "', ";   
    allFieldsAsCSV +=  "'" + sound_move +  "', ";    
    allFieldsAsCSV +=  "'" + sound_move_alt +  "', "; 
    allFieldsAsCSV +=  "'" + sound_fight +  "', ";   
    allFieldsAsCSV +=  "'" + sound_fight_alt +  "', "; 
    allFieldsAsCSV +=  "'" + Integer.toString(build_cost) +  "', ";    
    allFieldsAsCSV +=  "'" + Integer.toString(pop_cost) +  "', ";      
    allFieldsAsCSV +=  "'" + Integer.toString(attack) +  "', ";       
    allFieldsAsCSV +=  "'" + Integer.toString(defence) +  "', ";       
    allFieldsAsCSV +=  "'" + Integer.toString(hitpoints) +  "', ";     
    allFieldsAsCSV +=  "'" + Integer.toString(firepower) +  "', ";     
    allFieldsAsCSV +=  "'" + Integer.toString(move_rate) +  "', ";     
    allFieldsAsCSV +=  "'" + Integer.toString(vision_radius_sq) +  "', "; 
    allFieldsAsCSV +=  "'" + Integer.toString(transport_cap) +  "', "; 
    allFieldsAsCSV +=  "'" + Integer.toString(fuel) +  "', ";          
    allFieldsAsCSV +=  "'" + Integer.toString(uk_happy) +  "', ";      
    allFieldsAsCSV +=  "'" + Integer.toString(uk_shield) +  "', ";     
    allFieldsAsCSV +=  "'" + Integer.toString(uk_food) +  "', ";     
    allFieldsAsCSV +=  "'" + Integer.toString(uk_gold) +  "', ";       
    allFieldsAsCSV +=  "'" + flags +  "', ";   
    allFieldsAsCSV +=  "'" + roles + "',";
    allFieldsAsCSV +=  "'" + helptext + "'";
    
    return allFieldsAsCSV;
    }




String getFieldsAsView(){
    String fieldsViewString = "";
    
    fieldsViewString  =   id + "\n";   
    fieldsViewString +=  unitName + "\n";   
    fieldsViewString +=  unitClass + "\n";   
    fieldsViewString +=  tech_req + "\n";   
    fieldsViewString +=  obsolete_by + "\n";   
    fieldsViewString +=  graphic + "\n";      
    fieldsViewString +=  graphic_alt + "\n";   
    fieldsViewString +=  sound_move + "\n";    
    fieldsViewString +=  sound_move_alt + "\n"; 
    fieldsViewString +=  sound_fight + "\n";   
    fieldsViewString +=  sound_fight_alt + "\n"; 
    fieldsViewString +=  Integer.toString(build_cost) + "\n";    
    fieldsViewString +=  Integer.toString(pop_cost) + "\n";      
    fieldsViewString +=  Integer.toString(attack) + "\n";       
    fieldsViewString +=  Integer.toString(defence) + "\n";       
    fieldsViewString +=  Integer.toString(hitpoints) + "\n";     
    fieldsViewString +=  Integer.toString(firepower) + "\n";     
    fieldsViewString +=  Integer.toString(move_rate) + "\n";     
    fieldsViewString +=  Integer.toString(vision_radius_sq) + "\n"; 
    fieldsViewString +=  Integer.toString(transport_cap) + "\n"; 
    fieldsViewString +=  Integer.toString(fuel) + "\n";          
    fieldsViewString +=  Integer.toString(uk_happy) + "\n";      
    fieldsViewString +=  Integer.toString(uk_shield) + "\n";     
    fieldsViewString +=  Integer.toString(uk_food) + "\n";     
    fieldsViewString +=  Integer.toString(uk_gold) + "\n";       
    fieldsViewString +=  flags + "\n";   
    fieldsViewString +=  roles + "\n";   
    fieldsViewString +=  helptext;

    return fieldsViewString;
    }




}
