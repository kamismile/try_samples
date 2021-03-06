package fits.sample

import scala.io._
import eu.henkelmann.actuarius.ActuariusApp

object Sample extends App {

	val mkStr = new BufferedSource(System.in)(Codec.UTF8).mkString

	val ps = new java.io.PrintStream(System.out, false, "UTF-8")

	ps.println(ActuariusApp(mkStr))
}
