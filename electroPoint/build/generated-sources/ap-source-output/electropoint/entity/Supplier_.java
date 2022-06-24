package electropoint.entity;

import electropoint.entity.Sensor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-17T14:25:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Supplier.class)
public class Supplier_ { 

    public static volatile SingularAttribute<Supplier, String> country;
    public static volatile SingularAttribute<Supplier, Integer> idSupplier;
    public static volatile SingularAttribute<Supplier, String> name;
    public static volatile CollectionAttribute<Supplier, Sensor> sensorCollection;

}