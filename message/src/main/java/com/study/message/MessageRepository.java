package com.study.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MessageRepository {

    private DataSource dataSource;

    public MessageRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public Message saveMessage(Message message) {
        Connection c = DataSourceUtils.getConnection(dataSource);
        try {
            String insertSql = "insert into messages (`id`, `text`, `created_date`) value (null, ?,?)";
            PreparedStatement ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getText());
            ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet result = ps.getGeneratedKeys();
                if(result.next()) {
                    int id = result.getInt(1);
                    return new Message(id, message.getText(), message.getCreatedDate());
                } else {
                    log.error("failed to retrieve id.");
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            log.error("failed to save message", e);
            try {
                c.close();
            } catch (SQLException ex) {
                log.error("fail to close", ex);
            }
        } finally {
            DataSourceUtils.releaseConnection(c, dataSource);
        }

        return null;
    }
}
