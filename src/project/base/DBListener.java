package project.base;

import project.controllers.DatDoUongController;
import project.controllers.HoaDonController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class DBListener extends Thread {
    private Connection conn;
    private org.postgresql.PGConnection pgconn;
    private DatDoUongController datDoUongController;
    private HoaDonController hoaDonController;

    public DBListener(Connection conn, DatDoUongController datDoUongController, HoaDonController hoaDonController) throws SQLException {
        this.datDoUongController = datDoUongController;
        this.hoaDonController = hoaDonController;
        this.conn = conn;
        this.pgconn = conn.unwrap(org.postgresql.PGConnection.class);
        Statement stmt = conn.createStatement();
        stmt.execute("LISTEN mymessage");
        stmt.close();
    }

    public void run() {
        try {
            while (true) {
                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();

                // If this thread is the only one that uses the connection, a timeout can be used to
                // receive notifications immediately:
                // org.postgresql.PGNotification notifications[] = pgconn.getNotifications(10000);

                if (notifications != null) {
                    System.out.println(Arrays.toString(notifications));
                    for (org.postgresql.PGNotification notification : notifications)
                        System.out.println("Got notification: " + notification.getName());
                    datDoUongController.refresh_data();
                    hoaDonController.initialize();
                }

                // wait a while before checking again for new
                // notifications

                Thread.sleep(500);
            }
        } catch (SQLException | InterruptedException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
