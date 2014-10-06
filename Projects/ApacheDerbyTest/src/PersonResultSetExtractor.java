import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

public class PersonResultSetExtractor implements ResultSetExtractor {


@Override
public Object extractData(ResultSet rs) throws SQLException
		{
    Person person = new Person();
    person.setFirstName(rs.getString(1));
    person.setLastName(rs.getString(2));
    return person;
}

} 