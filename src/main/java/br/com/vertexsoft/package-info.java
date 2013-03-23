@TypeDefs({ @TypeDef(name = "dateTime", typeClass = DateTimeUserType.class, defaultForType = DateTime.class) })
package br.com.vertexsoft;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;

import br.com.vertexsoft.mycash.usertype.DateTimeUserType;

