package week2;

import weka.core.Instances;
import weka.classifiers.trees.J48;

public class MyClassifier {

	public J48 classifyInstances(Instances instances, String[] optionsOfClassifier) throws Exception// classify方法
	{
		J48 classifier = new J48();// classifier为新的J48实例
		classifier.setOptions(optionsOfClassifier);// e.g. {"-C","0.25"}
		classifier.buildClassifier(instances);// 训练分类器使用buildClassifier方法
		System.out.println("Classifier built, now dispaly the classification result of first instance: "
				+ classifier.classifyInstance(instances.instance(0)));// 分类数据用J48类中的classifyInstance方法
		System.out.println("*******************************************************************");
		return classifier;
	}

}
