package instanceTest;

import java.io.FileReader;
import java.util.Random;//产生随机数需要用的包
 
import weka.classifiers.Evaluation;//Evaluation包
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class EvaluationTest {
	
	private Instances m_instances = null;
	   
    public void getFileInstances( String fileName ) throws Exception//从arff文件建立instance实例
    {
        FileReader frData = new FileReader( fileName );
        m_instances = new Instances( frData );
       
        m_instances.setClassIndex( m_instances.numAttributes() - 1 );
    }
   
    public void crossValidation() throws Exception //CV方法获得分类结果
    {
    
        J48 classifier = new J48();
        //NaiveBayes classifier = new NaiveBayes();
        //SMO classifier = new SMO();
        
        String[] options ={"-C","0.25"};
        classifier.setOptions(options);//对J48方法设定参数 (ISSUE: 如何获得所有参数的代号？）
        
        Evaluation eval = new Evaluation( m_instances );
        //首先初始化一个Evaluation对象，Evaluation类没有无参的构造函数，一般用Instances对象作为构造函数的参数。
        eval.crossValidateModel( classifier, m_instances, 10, new Random(1));
        //crossValidateModel方法的四个参数分别为，第一个是分类器，第二个是数据集，第三个参数是交叉检验的次数（10是比较常见的），第四个是一个随机数对象。
        System.out.println(eval.toClassDetailsString());//
        System.out.println(eval.toSummaryString());//打印正确分类数，准确率，误差等
        System.out.println(eval.toMatrixString());//打印Confusion Matrix
    }
   
    public void evaluateTestData() throws Exception//用training set和test set方法
    {
        J48 classifier = new J48();
        //NaiveBayes classifier = new NaiveBayes();
        //SMO classifier = new SMO();
       
        classifier.buildClassifier( m_instances );//训练分类器
       
        Evaluation eval = new Evaluation( m_instances );
        eval.evaluateModel( classifier, m_instances );//测试集，第一个参数为已经训练过的分类器，第二个参数为测试集（本例中和训练集一样）
        System.out.println(eval.toClassDetailsString());
        System.out.println(eval.toSummaryString());
        System.out.println(eval.toMatrixString());
    }
   
    public static void main( String[] args ) throws Exception
    {
        EvaluationTest etest = new EvaluationTest();
       
        etest.getFileInstances( "/Applications/weka-3-6-12/data/breast-cancer.arff");
        etest.crossValidation();
        System.out.println( "***********************************\n\n" );
        //etest.evaluateTestData();
    }
}
