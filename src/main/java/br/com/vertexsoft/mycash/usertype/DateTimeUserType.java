package br.com.vertexsoft.mycash.usertype;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.joda.time.DateTime;

public class DateTimeUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Timestamp timestamp = rs.getTimestamp(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		else {
			return new DateTime(timestamp.getTime());
		}
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.TIMESTAMP);
		}
		else {
			DateTime dateTime = (DateTime) value;
			st.setTimestamp(index, new Timestamp(dateTime.getMillis()));
		}
	}

	@Override
	public Class<?> returnedClass() {
		return DateTime.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.TIMESTAMP };
	}

}