package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.expressions.TestASM;
import test.expressions.sbql.TestParser;
import test.infrastructure.TestDB4O;
import test.infrastructure.TestSpringAndDB;
import test.task.definition.TestTaskDefinition;

 
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestASM.class,
        TestDB4O.class,
        TestTaskDefinition.class,
        TestSpringAndDB.class,
        TestParser.class
})
public class WSHTTestSuite {}
