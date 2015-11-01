package week2;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import java.util.Random;
import weka.core.Instances;

public class MyEvaluation {

	public void crossValidation(Instances instances, J48 classifier) throws Exception { // CV方法获得分类结果

		// 首先初始化一个Evaluation对象，Evaluation类没有无参的构造函数，一般用Instances对象作为构造函数的参数。
		Evaluation eval = new Evaluation(instances);

		// crossValidateModel方法的四个参数分别为，第一个是分类器，第二个是数据集，第三个参数是交叉检验的次数（10是比较常见的），第四个是一个随机数对象。
		eval.crossValidateModel(classifier, instances, 10, new Random(1));

		System.out.println(eval.toClassDetailsString());//
		System.out.println(eval.toSummaryString());// 打印正确分类数，准确率，误差等
		System.out.println(eval.toMatrixString());// 打印Confusion Matrix
		System.out.println("Cross validation finished");
		System.out.println("*******************************************************************");
	}

	public void evaluateTestData(Instances trainingSet, Instances testSet, J48 classifier) throws Exception// 用training
																											// set和test
																											// set方法
	{
		Evaluation eval = new Evaluation(trainingSet);
		eval.evaluateModel(classifier, testSet);// 测试集，第一个参数为已经训练过的分类器，第二个参数为测试集（本例中和训练集一样）
		System.out.println(eval.toClassDetailsString());
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toMatrixString());
		System.out.println("Testset validation finished");
		System.out.println("*******************************************************************");
	}

}
