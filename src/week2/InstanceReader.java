package week2;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class InstanceReader {

	public Instances instancesFromFile(String fileName) throws Exception
	// 用.arff文件创建instance, throws表示可能抛出异常

	{
		DataSource source = new DataSource(fileName);
		Instances instances = source.getDataSet();// weka.core.Instances类内标准方法
		instances.setClassIndex(instances.numAttributes() - 1);// 设置最后一个attribute为class
																// index

		for (int i = 0; i < instances.numInstances(); i++) { // 用numInstances可以获得数据集中有多少样本
			System.out.println(instances.instance(i));
		}

		System.out.println("Instances Loading Successful");
		System.out.println("*******************************************************************");

		return instances;
	}

}
