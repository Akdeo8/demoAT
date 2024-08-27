package Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TransFormer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annonation, Class testClass, Constructor testConstructor, Method testMethod) {
		annonation.setRetryAnalyzer(RetryNG.class);
	}

}
