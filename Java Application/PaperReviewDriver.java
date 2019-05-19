package cs623;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.columns.Author;
import db.columns.Paper;

import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();

		//Replace "author@gmail.com" with author email
		printPaperByAuthorId(conn, "author@gmail.com");
		
		//Replace the number 3 with a paperId
		getPaperReviewsById(conn, 3);
		
		//count all papers
		countAllPapers(conn);
		
		//****************************************************************
		//Insert new author email, first name and last name
		Author author = new Author("newman.fake.com", "sam", "jon");
		
		//Insert existing author email and reviewer email
		Paper paper = new Paper("Made up","This is only a test", "nothing.txt", "Brainless@outlook.com", "jscott@mercy.edu ");
		
		//Method for new entry
		createNewEntry(conn,author,paper);
		//****************************************************************
		
		//Method to delete author replace nothing@gmail.com
		deleteAuthor(conn, "nothing@gmail.com");
	}

	// connecting to database
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/paperreview"; //change to match database location
			String username = "newuser"; //change to match database
			String password = "password";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	// Print a paper by its author's ID
	public static void printPaperByAuthorId(Connection conn, String authorId) {
		try {

			String sqlQuery = "SELECT paper.id, paper.title, paper.abstract, author.emailAddr, author.firstName, author.lastName "
					+ "FROM Author INNER JOIN Paper ON( author.emailAddr = paper.authorId ) "
					+ "WHERE author.emailAddr = ?";

			boolean returnedRows = false;

			// 1. Prepare the statement
			PreparedStatement preparedSelect = conn.prepareStatement(sqlQuery);
			// 2. Fill in the parameter value(s)
			preparedSelect.setString(1, authorId);
			// 3. Execute the statement
			ResultSet rs = preparedSelect.executeQuery();

			

			// 1. Call rs.next( )
			while (rs.next()) {
				int id = rs.getInt("paper.id");
				String title = rs.getString("paper.title");
				String abtract = rs.getString("paper.abstract");
				String emailAddr = rs.getString("author.emailAddr");
				String firstName = rs.getString("author.firstName");
				String lName = rs.getString("author.lastName");

				//Print out the results of the query
				System.out.println("Paper: \n ID: " + id + "\n Title: " + title + "\n Paper Abstract: " + abtract
						+ "\n Author Email: " + emailAddr + "\n Author First Name: " + firstName
						+ "\n Author Last Name: " + lName);
				returnedRows = true;
				// 3. Repeat, if necessary
			}

			// Output a message if NO rows were returned
			if (returnedRows == false)
				System.out.println("No rows were returned.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("the end of the program");
		System.out.println("*******************************************************");
	}

	// Get paper reviews by Paper Id
	public static void getPaperReviewsById(Connection conn, int paperId) {
		try {

			String sqlQuery = "SELECT * " + "FROM Review " + "WHERE paperId = ?";

			boolean returnedRows = false;

			// 1. Prepare the statement
			PreparedStatement preparedSelect = conn.prepareStatement(sqlQuery);
			// 2. Fill in the parameter value(s)
			preparedSelect.setInt(1, paperId);
			// 3. Execute the statement
			ResultSet rs = preparedSelect.executeQuery();

			// 1. Call rs.next( ) //change to match column in database
			while (rs.next()) {
				// 2. Call rs.getInt( ), rs.getString( ), etc...
				int id = rs.getInt("review.id");
				String recommendation = rs.getString("review.recommendation");
				int meritScore = rs.getInt("review.meritScore");
				int readAbility = rs.getInt("review.readabilityScore");
				int relevance = rs.getInt("review.relevanceScore");
				int originality = rs.getInt("review.originalityScore");
				int papersId = rs.getInt("review.paperId");
				String reviewersId = rs.getString("review.reviewerId");

				System.out.println("Paper: \n ID: " + id + "\n Recommendation " + recommendation + "\n Merit Score " + meritScore
						+ "\n Readability " + readAbility + "\n relevance " + relevance
						+ "\n orginality " + originality + "\n Paper ID: " + papersId + "\n Reviewers: " + reviewersId);
				returnedRows = true;
				// 3. Repeat, if necessary
			}

			// Output a message if NO rows were returned
			if (returnedRows == false)
				System.out.println("No rows were returned.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("the end of the program");
		System.out.println("*******************************************************");
	}

	

//Count of all Papers Submitted
	public static void countAllPapers(Connection conn) {
		try {

			String sqlQuery = "SELECT COUNT(id) FROM paper;";

			boolean returnedRows = false;

			// 1. Prepare the statement
			Statement stmt = conn.createStatement();

			//Execute the statement
			ResultSet rs = stmt.executeQuery(sqlQuery);

			// 1. Call rs.next( ) //change to match column in database
				rs.next(); 
				int id = rs.getInt(1);
				

				System.out.println("The count is: " + id);
					
				returnedRows = true;
				// 3. Repeat, if necessary


			// Output a message if NO rows were returned
			if (returnedRows == false)
				System.out.println("No rows were returned.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("the end of the program");
		System.out.println("*******************************************************");
	}
	// Create a new entry
	public static void createNewEntry(Connection conn, Author author, Paper paper) {
		try {

			String sqlInsert1 = "INSERT INTO author(`emailAddr`, `firstName`, `lastName`) VALUES(?,?,?)";
			String sqlInsert2 = "INSERT INTO paper (`title`, `abstract`, `fileName`,`authorId`,`reviewerId`) VALUES(?,?,?,?,?)";

			boolean returnedRows = false;

			// 1. Prepare the statement
			PreparedStatement preparedInsert = conn.prepareStatement(sqlInsert1);
			PreparedStatement preparedInsert2 = conn.prepareStatement(sqlInsert2);
			// 2. Fill in the parameter value(s)
			preparedInsert.setString(1, author.getEmailAddr());
			preparedInsert.setString(2, author.getFirstName());
			preparedInsert.setString(3, author.getLastName());
			preparedInsert2.setString(1, paper.getTitle());
			preparedInsert2.setString(2, paper.getabsstract());
			preparedInsert2.setString(3, paper.getFileName());
			preparedInsert2.setString(4, paper.getAuthorId());
			preparedInsert2.setString(5, paper.getReviewerId());
			// 3. Execute the statement
			int status = preparedInsert.executeUpdate();
			int status2 = preparedInsert2.executeUpdate();
			System.out.println("Rows inserted into author table: " + status);
			System.out.println("Rows inserted into paper table: " + status2);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("the end of the program");
		System.out.println("*******************************************************");
	}
	//delete Author
	public static void deleteAuthor(Connection conn, String emailAddr) {
		try {

			String sqlExecute = "DELETE FROM author WHERE emailAddr=?";
		

			// 1. Prepare the statement
			PreparedStatement preparedDelete = conn.prepareStatement(sqlExecute);
			// 2. Fill in the parameter value(s)
			preparedDelete.setString(1, emailAddr);
			// 3. Execute the statement
			int deletedRows = preparedDelete.executeUpdate();

		
				System.out.println("Number of Rows Deleted: " + deletedRows);
				

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("the end of the program");
		System.out.println("*******************************************************");
	}


}
