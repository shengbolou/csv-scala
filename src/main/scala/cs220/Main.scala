package cs220

import cs220.ds._

object Main {

  def main(args: Array[String]) = {
    if (args.length != 1) {
      println("please specify the csv file")
      println("usage: scala cs220.Main csv-file")
      System.exit(1)
    }

    val file = args(0)
    val c    = CerealCsv.read(file)

    println(c.nrows)
    println(c.ncols)
    println(c.toCSV(c.rows))
    println(c.toCSV(c.minCalories))
    println(c.toCSV(c.maxCalories))
    println(c.toCSV(c.secondMaxCalories))
    println(c.toCSV(c.thirdMaxCalories))
    println(c.toCSV(c.forthMaxCalories))
    }

}
