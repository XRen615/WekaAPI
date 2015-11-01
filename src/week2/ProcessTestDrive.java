package week2;

import weka.core.Instances;
import weka.classifiers.trees.J48;

public class ProcessTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InstanceReader reader = new InstanceReader();
		MyFilter filter = new MyFilter();
		MyClassifier classifier = new MyClassifier();
		MyEvaluation eval = new MyEvaluation();

		String[] options = new String[2];
		options[0] = "-R";
		options[1] = "1";

		//
		String[] optionsOfClassifier = { "-C", "0.25" };
		try {
			Instances test = reader.instancesFromFile("/Applications/weka-3-6-12/data/breast-cancer.arff");

			Instances filteredData = filter.filterInstances(test, options);

			J48 tree = classifier.classifyInstances(test, optionsOfClassifier);

			eval.crossValidation(test, tree);

			eval.evaluateTestData(test, test, tree);

		} catch (Exception e) {

			System.out.println("System ERROR");
		}

		System.out.println("System Check PASS");
	}
}
