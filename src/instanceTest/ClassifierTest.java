package instanceTest;

import java.io.FileReader;

import weka.classifiers.trees.J48;
import weka.core.Instances;

public class ClassifierTest {
    private Instances m_instances = null;
   
    public void getFileInstances( String fileName ) throws Exception
    {
        FileReader frData = new FileReader( fileName );
        m_instances = new Instances( frData );
       
        m_instances.setClassIndex( m_instances.numAttributes() - 1 );//设置最后一个attribute为class index
    }
   
    public void classify() throws Exception//classify方法
    {
        J48 classifier = new J48();//classifier为新的J48实例
        //NaiveBayes classifier = new NaiveBayes();
        //SMO classifier = new SMO();
       
        classifier.buildClassifier( m_instances );//训练分类器使用buildClassifier方法
        System.out.println( classifier.classifyInstance( m_instances.instance( 1 ) ) );//分类数据用J48类中的classifyInstance方法
    }
    
    public static void main( String[] args ) throws Exception
    {
        ClassifierTest ctest = new ClassifierTest();
       
        ctest.getFileInstances( "/Applications/weka-3-6-12/data/breast-cancer.arff");
        ctest.classify();
    }
}
