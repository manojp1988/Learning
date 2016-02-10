import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by manojperiathambi on 2/9/16.
 */
public class DataLoader {

    public static void main(String... arg) throws SQLException {
        new DataLoader().loadData();
    }

    public void loadData() throws SQLException {
        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        try(Connection conn = OracleConnection.getConnection()) {

            conn.setAutoCommit(false);

            Scanner scan = new Scanner(System.in);
            System.out.println("How many records you want to load ?");
            Long totalRecords = scan.nextLong();

            System.out.println("What is the page size ?");
            int pageSize = scan.nextInt();

            while (totalRecords > 0) {

                List<InputDataModel> inpList = new ArrayList<>(pageSize);
                try(PreparedStatement stmt = conn.prepareStatement("");) {
                    ResultSet rs = stmt.executeQuery();

                    int tmpPage = pageSize;
                    while (tmpPage-- > 0) {
                        inpList.add(getInputModel(rs));
                    }
                }

                try(PreparedStatement insertStmt = conn.prepareStatement("");) {
                    for (InputDataModel in : inpList) {
                        prepareData(insertStmt, in).addBatch();
                    }

                    int[] count = insertStmt.executeBatch();
                }
                conn.commit();

                totalRecords = totalRecords - pageSize;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded all the data");
    }

    private PreparedStatement prepareData(PreparedStatement insertStmt, InputDataModel in) {
        return null;
    }

    private InputDataModel getInputModel(ResultSet rs) {
        return null;
    }
}
