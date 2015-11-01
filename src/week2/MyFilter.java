package week2;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class MyFilter {

	public Instances filterInstances(Instances instances, String[] options) throws Exception {

		Remove remove = new Remove();
		remove.setOptions(options);// inform filter about dataset //**AFTER**
									// setting options
		remove.setInputFormat(instances); // Sets the format of the input
											// instances
		Instances newData = Filter.useFilter(instances, remove); // apply filter

		for (int i = 0; i < newData.numInstances(); i++) { // 用numInstances可以获得数据集中有多少样本
			System.out.println(newData.instance(i));
		}

		System.out.println("Filtering Finished");
		System.out.println("*******************************************************************");
		return newData;
	}

}
