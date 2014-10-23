// recursion example in scala
// we'll use 3 methods to calculate sum of 1 + 2 + ... + n
import scala.annotation.tailrec


object RecursionSum {

  // simple recursive option
  def sum(input: BigInt): BigInt = (if (input <=1) 1 else input + sum(input - 1))

  // optimized tail recursion
  @tailrec
  def tailSum (input: BigInt, result: BigInt = 0): BigInt = 
    if (input <= 0)
      result
    else
      tailSum(input - 1, input + result)
  
  // good ol' iterative
  def iterSum(input: Int): BigInt = {
    var result: BigInt = 0
    for(i <- 1 to input) {
      result += i
    }
    result
  }


  def main(args: Array[String]) {
    
    if (args.length > 0) {
      // reg rec will overflow stack, let's not even run it
      /*
      val t0 = System.nanoTime
      println (sum(args(0).toInt) + "\n")
      val time = (System.nanoTime - t0 ) / 1000000
      println ("sum elapsed time: " + time + " (ms)")
      */

      // tailrec won't crash!
      val t0 = System.nanoTime
      println (tailSum(args(0).toInt) + "\n")
      val time = (System.nanoTime - t0 ) / 1000000
      println ("tailSum elapsed time: " + time + " (ms)")

      // iterative solution
      val t0_a = System.nanoTime
      println (iterSum(args(0).toInt) + "\n")
      val time_a = (System.nanoTime - t0_a ) / 1000000
      println ("iterSum elapsed time: " + time_a + " (ms)")

    } else {
      println ("Usage: RecursionSum [some number]\n\n")
    } 
      
  }

}