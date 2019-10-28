import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateSerializationTest {

    private static final Logger log = LoggerFactory.getLogger(DateSerializationTest.class);

    @Test
    public void name() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        mapper.setDateFormat(dateFormat);

        String sqlDateJson = mapper.writeValueAsString(new Date(System.currentTimeMillis()));
        String utilDate = mapper.writeValueAsString(new java.util.Date());

        log.info("sql: {}, util: {}", sqlDateJson, utilDate);

    }
}
