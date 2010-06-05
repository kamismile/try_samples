
import groovy.xml.StreamingMarkupBuilder

def doc = new XmlSlurper().parse(new File(args[0]))

//要素の追加 <data id="3"><details>added</details></data>
doc.appendNode {
	data(id: "3") {
		details("added")
	}
}



def builder = new StreamingMarkupBuilder()

//文字列でXML取得
def xmlString = builder.bind{
	mkp.yield doc
}

println xmlString

