package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Notebook.class)
public abstract class Notebook_ extends entities.BaseModel_ {

	public static volatile ListAttribute<Notebook, Note> notes;
	public static volatile SingularAttribute<Notebook, String> name;
	public static volatile ListAttribute<Notebook, User> users;

}

