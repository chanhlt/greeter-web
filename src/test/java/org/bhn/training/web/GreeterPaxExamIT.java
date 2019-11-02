package org.bhn.training.web;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import javax.inject.Inject;

import static org.ops4j.pax.exam.CoreOptions.*;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class GreeterPaxExamIT
    extends TestCase
{
//    @Inject
//    private Greeter greeter;

    @Configuration
    public Option[] config(){
        return options(
                mavenBundle("org.apache.felix","org.apache.felix.scr","1.6.2"),
                //mavenBundle("org.bhn.training","greeter-bundle"),
//                bundle("reference:file:target/classes"),
                bundle("reference:file:target/greeter-bundle-1.0-SNAPSHOT.jar"),
                junitBundles()
        );
    }

    @Test
    public void simpleGreetingImplCheck()
    {
//        String testValue = greeter.greet();
//        assertEquals(testValue,"Hello World!");
    }
}
