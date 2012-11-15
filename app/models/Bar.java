package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Bar extends Model {
    
    @Id
    public UUID id;
    
    public String name;
    
}
