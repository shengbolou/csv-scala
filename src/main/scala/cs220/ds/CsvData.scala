package cs220.ds

trait CsvReader[T <: CsvData] {
  // The read method reads in a CSV file and returns a type T that
  // extends the CsvData trait. In Java, you would normally see
  // <T extends CsvData>, Scala uses the <: syntax for this.
  def read(file: String): T
}

trait CsvData {
  // The number of rows in the CSV data (excluding the header).
  def nrows(): Int

  // The number of columns in the CSV data.
  def ncols(): Int

  // Returns the rows in the CSV file.
  def rows(): List[List[String]]

  // Returns a list of the header names in the CSV file.
  def headers(): List[String]

  // Returns a list of the row data.
  def row(idx: Int): List[String]

  // Returns a pair containing the header name and the list of the
  // data in a column given by the header name. If the header name
  // does not exist then the returned pair will contain the empty
  // list.
  def column(hname: String): (String, List[String])

  // Returns the rows that match the given value in a row with the
  // given header name. If there is no match the empty list is
  // returned. 
  def rowMatch(hname: String, value: String): List[List[String]]

  // Converts a list of rows into a String in CSV format.
  def toCSV(xss: List[List[String]]): String
}
