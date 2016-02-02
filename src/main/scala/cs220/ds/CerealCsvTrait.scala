package cs220.ds

trait CerealCsvTrait extends CsvData {
  // Returns the rows containing the minimum calorie cereals. We
  // return multiple rows because we may have multiple cereals with
  // the same minimum calories.
  def minCalories(): List[List[String]]

  // Returns the rows containing the maximum calorie cereals. We
  // return multiple rows because we may have multiple cereals with
  // the same maximum calories.
  def maxCalories(): List[List[String]]
  
  // Returns the rows containing the forth maximum calorie cereals. We
  // return multiple rows because we may have multiple cereals with
  // the same maximum calories.
  def forthMaxCalories():List[List[String]]
  
  // Returns the rows containing the third maximum calorie cereals. We
  // return multiple rows because we may have multiple cereals with
  // the same maximum calories.
  def thirdMaxCalories():List[List[String]]
 
  // Returns the rows containing the second maximum calorie cereals. We
  // return multiple rows because we may have multiple cereals with
  // the same maximum calories.
  def secondMaxCalories():List[List[String]]
 
}
