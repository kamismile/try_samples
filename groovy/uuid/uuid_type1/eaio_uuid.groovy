@Grab('com.eaio.uuid:uuid:3.2')
import com.eaio.uuid.UUID

(1..5).each {
	//タイプ1 の UUID 生成
	println new UUID()
}
