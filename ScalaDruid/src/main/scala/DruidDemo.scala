
import java.time.ZonedDateTime
import com.ing.wbaa.druid._
import com.ing.wbaa.druid.definitions._
import scala.concurrent.duration._
import com.ing.wbaa.druid.SQL._


implicit val druidConf = DruidConfig(
  hosts = Seq("localhost:8082"),
  datasource = "wikiticker-2015-09-12-sampled",
  responseParsingTimeout = 10.seconds
)
object DruidDemo {
  def main(args: Array[String]): Unit = {
    val query = dsql"""SELECT COUNT(*) as "count" FROM wikiticker-2015-09-12-sampled WHERE "__time" >= TIMESTAMP '2015-09-12 00:00:00'"""

    val response = query.execute()
  }
}