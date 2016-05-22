package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends entities.BaseModel_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> displayName;
	public static volatile ListAttribute<User, Notebook> notebooks;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Integer> age;

}

