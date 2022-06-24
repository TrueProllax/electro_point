package electropoint.entity;

import electropoint.entity.Supplier;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T14:25:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Sensor.class)
public class Sensor_ { 

    public static volatile SingularAttribute<Sensor, String> accuracyCoordinates;
    public static volatile SingularAttribute<Sensor, String> code;
    public static volatile SingularAttribute<Sensor, String> additionally;
    public static volatile SingularAttribute<Sensor, Supplier> supplier;
    public static volatile SingularAttribute<Sensor, Integer> idSensor;
    public static volatile SingularAttribute<Sensor, String> model;
    public static volatile SingularAttribute<Sensor, String> type;

}