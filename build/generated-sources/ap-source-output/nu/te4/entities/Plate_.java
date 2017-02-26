package nu.te4.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import nu.te4.entities.PlatePK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-26T17:17:58")
@StaticMetamodel(Plate.class)
public class Plate_ { 

    public static volatile SingularAttribute<Plate, Date> date;
    public static volatile SingularAttribute<Plate, String> note;
    public static volatile SingularAttribute<Plate, PlatePK> platePK;

}