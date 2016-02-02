package cs220.ds

import scala.io.Source

class CerealCsv(val hs: List[String], val ds: List[List[String]]) extends CerealCsvTrait {
      // The number of rows in the CSV data (excluding the header).
      def nrows(): Int = ds.length
      // The number of columns in the CSV data.
      def ncols(): Int = hs.length
      // Returns the rows in the CSV file.
      def rows(): List[List[String]] = ds
      // Returns a list of the header names in the CSV file.
      def headers(): List[String] = hs
      // Returns a list of the row data.
      def row(idx: Int): List[String] = ds(idx)
      
      // Returns a pair containing the header name and the list of the
      // data in a column given by the header name. If the header name
      // does not exist then the returned pair will contain the empty
      // list.
      def column(hname: String): (String, List[String]) = {
        //this local function returns the list of String of column 
        def getColumn(hname: String): List[String] = {
        val idx = hs.indexOf(hname)
        var toreturn = List[String]()
           for(list <- ds) toreturn = list(idx) :: toreturn
               toreturn.reverse
        } 
             
         val idx = hs.indexOf(hname)
              if(idx == -1) (hname , List())
              else (hname , getColumn(hname))
           
      }
      // Returns the rows that match the given value in a row with the
      // given header name. If there is no match the empty list is
      // returned. 
      def rowMatch(hname: String, value: String): List[List[String]] = {
        //get the index of hname
        val idx = hs.indexOf(hname)
        val lists = column(hname)._2
        var toreturn = List[List[String]]()
        if(idx == -1)  List(List())
        else{
          for(i:Int <- 0 to lists.length-1){
            if(lists(i) == value) toreturn = ds(i) :: toreturn 
            }
           toreturn.reverse
        }
      }
      // Converts a list of rows into a String in CSV format.
      def toCSV(xss: List[List[String]]): String = {
       var toreturn: String = ""
        for(list <- xss){
          toreturn = toreturn + list.mkString(",")+"\n"
        } 
       toreturn
      }

     // Returns the rows containing the minimum calorie cereals. We
     // return multiple rows because we may have multiple cereals with
     // the same minimum calories.
          def minCalories(): List[List[String]] = {
           //get the calories list
           val calorieslist = column("calories")._2
           val minlist = for { c <- calorieslist; v = c.toInt } yield v
           //sort the list and get the biggest one
           val min = minlist.sorted.head.toString
           rowMatch("calories",min)
        }
     // Returns the rows containing the maximum calorie cereals. We
     // return multiple rows because we may have multiple cereals with
     // the same maximum calories.
          def maxCalories(): List[List[String]] = {
          //get the calories list
           val calorieslist = column("calories")._2
           val maxlist = for { c <- calorieslist; v = c.toInt } yield v
           // sort the list and get the biggest number
           val max = maxlist.sorted.last.toString
           rowMatch("calories",max)
        } 
     // Returns the rows containing the second maximum calorie cereals. We
     // return multiple rows because we may have multiple cereals with
     // the same maximum calories.
          def secondMaxCalories():List[List[String]] = {
                val calorieslist = column("calories")._2
                val list = for { c <- calorieslist; v = c.toInt } yield v
                // delete duplicate elements
                val secondMax = list.distinct.sorted
                val result = secondMax(1).toString
                rowMatch("calories",result)
              }  
     
     // Returns the rows containing the forth maximum calorie cereals. We
     // return multiple rows because we may have multiple cereals with
     // the same maximum calories.
            
          def thirdMaxCalories():List[List[String]] = {
                val calorieslist = column("calories")._2
                val list = for { c <- calorieslist; v = c.toInt } yield v
                // delete duplicate elements
                val thirdMax = list.distinct.sorted
                val result = thirdMax(2).toString
                rowMatch("calories",result)
              }      

     // Returns the rows containing the forth maximum calorie cereals. We
     // return multiple rows because we may have multiple cereals with
     // the same maximum calories.
          
               def forthMaxCalories():List[List[String]] = {
                val calorieslist = column("calories")._2
                val list = for { c <- calorieslist; v = c.toInt } yield v
                // delete duplicate elements
                val forthMax = list.distinct.sorted
                val result = forthMax(3).toString
                rowMatch("calories",result)
              }      
              
}

object CerealCsv extends CsvReader[CerealCsvTrait] {

  def read(file: String): CerealCsvTrait = {
      val lines= Source.fromFile(file).getLines().toList
          val headers = lines.head.split(",").toList

          val data =
          for {
            line <- lines.tail;
            row = line.split(",").toList
          } yield row
          val toreturn = new CerealCsv(headers,data)
          toreturn

  }

}

