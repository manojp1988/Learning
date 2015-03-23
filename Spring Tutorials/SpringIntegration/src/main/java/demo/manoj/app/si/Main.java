/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.manoj.app.si;

import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Manoj
 * @since 1.0
 *
 */
public final class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private Main() {
	}

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args
	 *            - command line arguments
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(final String... args) throws InterruptedException, ExecutionException {

		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/integration/*-context.xml");
		
		iTransformer transformer = context.getBean("trans", iTransformer.class);
		Person person = context.getBean("person", Person.class);
		transformer.printAsString(person);
		System.out.println();
		System.out.println("Completed !!");
		System.exit(0);
	}
}
