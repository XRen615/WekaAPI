package instanceTest;

import java.io.FileReader;
import weka.core.Instances;

public class InstanceTest {
	
	public static Instances getFileInstances( String fileName ) throws Exception//getFileInstances方法,返回一个instance
	//throws表示可能抛出异常。用arff文件创建instance
    {
        FileReader frData = new FileReader( fileName );//frData，Filereader实例化
          Instances data = new Instances( frData );//用frData的内容创建Instance类对象data
        
          return data;
    }
	
	 public static void main(String[] args) throws Exception
	    {
	Instances instances = getFileInstances( "/Applications/weka-3-6-12/data/breast-cancer.arff");
	       
	        //把数据集全部输入出
	        //System.out.println( instances );
	       
	        //用numInstances可以获得数据集中有多少样本
	        for( int i = 0; i < instances.numInstances(); i++ )
	        {
	            //instance( i )是得到第i个样本
	            System.out.println( instances.instance( i ) );
	        }
	    }

}
