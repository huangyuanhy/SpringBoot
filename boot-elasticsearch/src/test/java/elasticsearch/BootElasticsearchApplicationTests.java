package elasticsearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import elasticsearch.bean.Article;

import io.searchbox.client.JestClient;

import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootElasticsearchApplicationTests {
	 
	@Autowired
	JestClient JestClient;
	
	@Test
	public void contextLoads() {
		Article article = new Article();
		article.setAuthor("huangyuan");
		article.setContent("helloworld");
		article.setTitle("fisrt news");
		//构件一个索引
		Index build = new Index.Builder(article).index("huangyuan").type("news").build();
		 
		try {
			// Index extends SingleResultAbstractDocumentTargetedAction implements BulkableAction<DocumentResult>
			JestClient.execute(build);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询结果
	@Test
	public void search() {
		//查询表达式
		String  json="{\n" + 
				"    \"query\" : {\n" + 
				"        \"match\" : {\n" + 
				"            \"content\" : \"news\"\n" + 
				"        }\n" + 
				"    }\n" + 
				"}";
		//构建搜索功能
		Search build = new Search.Builder(json).addIndex("huangyuan").addType("news").build();
		try {
			
			SearchResult execute = JestClient.execute(build);
			System.out.println(execute.getJsonString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
