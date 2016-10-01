package be.odisee.verhuursysteem_sharingbox.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends Rol {

    public Administrator(){}

    public Administrator(String status, String usernaam, Persoon persoon){
        super(status,usernaam,persoon);
    }

    public Administrator(int id, String status, String usernaam, Persoon persoon){
        super(id,status,usernaam,persoon);
    }

    @Override
    public String getType() {
        return "Administrator";
    }

}