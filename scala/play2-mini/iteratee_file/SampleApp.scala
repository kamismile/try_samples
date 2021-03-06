package fits.sample

import play.api.libs.iteratee._
import java.io.File

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object SampleApp extends App {
	import scala.concurrent.ExecutionContext.Implicits.global

	val enumerator = Enumerator.fromFile(new File(args(0)))

	// 1行取り出す
	val takeLine = for {
		line <- Enumeratee.takeWhile[Byte](_ != '\n'.toByte) &>> Iteratee.getChunks
		_    <- Enumeratee.take(1) &>> Iteratee.ignore[Byte]
	} yield new String(line.toArray)

	// 1行ずつ処理
	val f = enumerator &> Enumeratee.mapConcat( _.toSeq ) &> Enumeratee.grouped(takeLine) |>>> Iteratee.foreach { s => 
		println(s"#${s}")
	}

	Await.ready(f, Duration.Inf)
}
